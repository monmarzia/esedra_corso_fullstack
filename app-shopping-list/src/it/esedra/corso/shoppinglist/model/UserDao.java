package it.esedra.corso.shoppinglist.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.esedra.corso.shoppinglist.exceptions.DaoException;
import it.esedra.corso.shoppinglist.helper.GetFileResource;
import it.esedra.corso.shoppinglist.helper.SequenceManager;

public class UserDao implements Dao<User> {

	private static final String fileName = "user.csv";
	private static final String folderName = "shoppinglist";
	private static final String fieldSeparator = ",";
	private final static Map<String, Integer> fieldsMap;
	private final static Logger logger = LoggerFactory.getLogger(UserDao.class.getName());

	public static enum Fields {
		userId, firstName, lastName, email, mobilePhone, isActive, isPrivacyConsent, isNewsletter
	}

	static {
		HashMap<String, Integer> tmpMap = new HashMap<String, Integer>();
		tmpMap.put(Fields.userId.name(), 0);
		tmpMap.put(Fields.firstName.name(), 1);
		tmpMap.put(Fields.lastName.name(), 2);
		tmpMap.put(Fields.email.name(), 3);
		tmpMap.put(Fields.mobilePhone.name(), 4);
		tmpMap.put(Fields.isActive.name(), 5);
		tmpMap.put(Fields.isPrivacyConsent.name(), 6);
		tmpMap.put(Fields.isNewsletter.name(), 7);
		fieldsMap = Collections.unmodifiableMap(tmpMap);

	}

	/**
	 * Return a ordered set of Users The method read all lines of csv file....
	 * return Collection<User> all user
	 */
	public SortedSet<User> getAll() throws DaoException {

		List<String[]> usersRows = UserDao.fetchRows();

		UserBuilder userBuilder = new UserBuilder();

		SortedSet<User> users = usersRows.stream()
				.map(s -> userBuilder.firstName(s[fieldsMap.get(Fields.firstName.name())])
						.lastName(s[fieldsMap.get(Fields.lastName.name())]).email(s[fieldsMap.get(Fields.email.name())])
						.mobilePhone(s[fieldsMap.get(Fields.mobilePhone.name())])
						.active(Boolean.parseBoolean(s[fieldsMap.get(Fields.isActive.name())]))
						.privacyConsent(Boolean.parseBoolean(s[fieldsMap.get(Fields.isPrivacyConsent.name())]))
						.newsletter(Boolean.parseBoolean(s[fieldsMap.get(Fields.isNewsletter.name())]))
						.userId(new BigInteger(s[fieldsMap.get(Fields.userId.name())])).build())
				.collect(Collectors.toCollection(TreeSet::new));

		return users;

	}

	/**
	 * TODO Implementare Parte per Update
	 */
	@Override
	public void save(User t) throws DaoException {
		try {

			BufferedWriter writer = new BufferedWriter(
					new FileWriter(GetFileResource.get(fileName, folderName).toPath().toString(), true));
			StringBuilder builder = new StringBuilder();
			if ((t.getUserId().equals(BigInteger.ONE)
					|| t.getUserId().compareTo(SequenceManager.getInstance().getCurrentIdUser()) > 0)
					&& !find(t).contains(t)) {
				builder.append(t.getUserId());
				builder.append(fieldSeparator);
				builder.append(t.getFirstName());
				builder.append(fieldSeparator);
				builder.append(t.getLastName());
				builder.append(fieldSeparator);
				builder.append(t.getEmail());
				builder.append(fieldSeparator);
				builder.append(t.getMobilePhone());
				builder.append(fieldSeparator);
				builder.append(t.isActive());
				builder.append(fieldSeparator);
				builder.append(t.isPrivacyConsent());
				builder.append(fieldSeparator);
				builder.append(t.isNewsletter());
				builder.append(fieldSeparator);
				builder.append(System.getProperty("line.separator"));
				writer.write(builder.toString());
				writer.flush();
				writer.close();
				logger.info("User " + t.getFirstName() + " salvato");

			} else {
				logger.warn("no user stored or updated!");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
	}

	@Override
	public User get(BigInteger id) throws DaoException {

		List<String[]> usersRows = UserDao.fetchRows();

		UserBuilder userBuilder = new UserBuilder();

		String[] userString = usersRows.stream().filter(s -> s[0].equals(id.toString())).collect(Collectors.toList())
				.get(0);

		User user = userBuilder.userId(new BigInteger(userString[fieldsMap.get(Fields.userId.name())]))
				.firstName(userString[fieldsMap.get(Fields.firstName.name())])
				.lastName(userString[fieldsMap.get(Fields.lastName.name())])
				.email(userString[fieldsMap.get(Fields.email.name())])
				.mobilePhone(userString[fieldsMap.get(Fields.mobilePhone.name())])
				.active(Boolean.parseBoolean(userString[fieldsMap.get(Fields.isActive.name())]))
				.newsletter(Boolean.parseBoolean(userString[fieldsMap.get(Fields.isNewsletter.name())]))
				.privacyConsent(Boolean.parseBoolean(userString[fieldsMap.get(Fields.isNewsletter.name())])).build();

		return user;
	}

	@Override
	public void delete(BigInteger id) throws DaoException {
		File db = null;
		File dbclone = null;
		try {
			// ottengo tutti gli user
			Collection<User> users = this.getAll();
			// rinominiamo il file
			// prendo il file del db
			db = new File(GetFileResource.get(fileName, folderName).toPath().toString());
			// clono il file del db
			dbclone = new File(GetFileResource.get(fileName, folderName).toPath().toString() + ".temp");
			// ma prima verifico che non esista già
			if (dbclone.exists()) {
				dbclone.delete();
			}
			// clono effettivamente il file del db
			db.renameTo(dbclone);
			/// elimino il file del db
			db.delete();
			// lo riscrivo da zero
			users.stream().filter(u -> !u.getUserId().equals(id)).forEach(u -> {
				try {
					save(u);
				} catch (DaoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			// se il id corrisponde a quello in input non lo scrivo
		} catch (Exception e) {
			// cancello il file nuovo del db
			db.delete();
			// ripristino il vecchio file del db
			dbclone.renameTo(db);
			throw new DaoException(e.getMessage());
		} finally {
			// eliminio il clone che avevo fatto per salvare i dati in caso di errore
			dbclone.delete();
		}
	}

	/**
	 * TODO Utilizzare gli stream
	 */
	@Override
	public SortedSet<User> find(User t) throws DaoException {
		try {
			List<String> lines = Files.readAllLines(GetFileResource.get(fileName, folderName).toPath());
			SortedSet<User> users = new TreeSet<User>();
			for (String line : lines) {
				String[] fields = line.split(fieldSeparator);
				if (!fields[fieldsMap.get(Fields.userId.name())].equals("")) {

					users.add(UserBuilder.builder().firstName(fields[fieldsMap.get(Fields.firstName.name())])
							.lastName(fields[fieldsMap.get(Fields.lastName.name())])
							.email(fields[fieldsMap.get(Fields.email.name())])
							.mobilePhone(fields[fieldsMap.get(Fields.mobilePhone.name())])
							.active(Boolean.parseBoolean(fields[fieldsMap.get(Fields.isActive.name())]))
							.privacyConsent(Boolean.parseBoolean(fields[fieldsMap.get(Fields.isPrivacyConsent.name())]))
							.newsletter(Boolean.parseBoolean(fields[fieldsMap.get(Fields.isNewsletter.name())]))
							.userId(new BigInteger(fields[fieldsMap.get(Fields.userId.name())])).build());
				}
			}
			return users;
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
	}

	private static List<String[]> fetchRows() throws DaoException {
		try {
			List<String> lines = Files.readAllLines(GetFileResource.get(fileName, folderName).toPath());

			return lines.stream().map(s -> s.split(fieldSeparator)).collect(Collectors.toList());
		} catch (IOException e) {
			throw new DaoException(e);
		}
	}

}
