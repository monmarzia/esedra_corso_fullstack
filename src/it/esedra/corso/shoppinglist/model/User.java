package it.esedra.corso.shoppinglist.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import it.esedra.corso.shoppinglist.helper.GetFileResource;
import it.esedra.corso.shoppinglist.helper.SequenceManager;

/**
 * @author monica
 *
 */
public class User implements Persist, Comparable<User> {
	private static BigInteger id = new BigInteger("0");
	private BigInteger userId = id;
	private String firstName;
	private String lastName;
	private String email;
	private String mobilePhone;
	private boolean isActive = false;
	private boolean privacyConsent = false;
	private boolean newsletter = false;
	private final static Map<String, Integer> fieldsMap;
	private static final String fileName = "user.csv";
	private static final String folderName = "shoppinglist";
	private static final String fieldSeparator = ",";

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

	private Map<BigInteger, User> storedUsers = new HashMap<>();

	public User() {

	}

	public User(BigInteger userId, String firstName, String lastName, String email, String mobilePhone,
			boolean isActive, boolean privacyConsent, boolean newsletter) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobilePhone = mobilePhone;
		this.isActive = isActive;
		this.privacyConsent = privacyConsent;
		this.newsletter = newsletter;
	}

	public BigInteger getUserId() {
		return userId;
	}

	public User setUserId(BigInteger userId) {
		this.userId = userId;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public boolean isPrivacyConsent() {
		return privacyConsent;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public boolean isActive() {
		return isActive;
	}

	public boolean isNewsletter() {
		return newsletter;
	}

	public Map<BigInteger, User> getStoredUsers() {
		return storedUsers;
	}

	/**
	 * 
	 * @return userID incrementato di 1 Sostituito getSequence() con newUserId()
	 */

	public BigInteger newUserId() {
		return userId = SequenceManager.newIdUser();
	}

	public Map<BigInteger, User> addToStoredUsers(User user) {
		storedUsers.put(user.getUserId(), user);
		return storedUsers;
	}

	/**
	 * 
	 * @return l'id piÃ¹ in alto assegnato
	 * @throws IOException
	 */

	public static synchronized BigInteger getLastId() throws IOException {
		try {
			BigInteger lastId = (getAll().isEmpty()) ? SequenceManager.newIdUser() : getAll().last().getUserId();
			return lastId;
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}

	}

	/**
	 * 
	 * Modifica: aggiunto blocco try/catch per gestire l'errore ed evitare l'uso del
	 * blocco nella classe TestUser.
	 * 
	 * Modificato return (era "new User()" vuoto)
	 * 
	 * Modificato Il BufferedReader con il metodo statico Files.readAlLines(path)
	 * che restituisce una List di String ciascuna con una linea. Utilizzato un
	 * ciclo for migiorato per la ricerca dello User nel file user.csv.
	 * 
	 * Modifica: aggiunta di un argomento BigInteger findId per la ricerca: se il
	 * file vuoto, il campo tmpUserId assume un valore BigInteger.zeroLenght e da
	 * luogo ad un flusso non gestito;
	 * 
	 */

	@Deprecated
	public User get(BigInteger findId) throws IOException {
		try {
			List<String> lines = Files.readAllLines(GetFileResource.get(User.fileName, User.folderName).toPath());
			for (String line : lines) {
				String[] fields = line.split(User.fieldSeparator);
				BigInteger tmpUserId = new BigInteger(fields[fieldsMap.get(Fields.userId.name())]);
				if (tmpUserId.equals(findId)) {
					return UserBuilder.builder().firstName(fields[fieldsMap.get(Fields.firstName.name())])
							.lastName(fields[fieldsMap.get(Fields.lastName.name())])
							.email(fields[fieldsMap.get(Fields.email.name())])
							.mobilePhone(fields[fieldsMap.get(Fields.mobilePhone.name())])
							.active(Boolean.parseBoolean(fields[fieldsMap.get(Fields.isActive.name())]))
							.privacyConsent(Boolean.parseBoolean(fields[fieldsMap.get(Fields.isPrivacyConsent.name())]))
							.userId(tmpUserId)
							.newsletter(Boolean.parseBoolean(fields[fieldsMap.get(Fields.isNewsletter.name())]))
							.build();

				}
			}

			return null;
		} catch (Exception e) {
			throw new IOException();
		}

	}

	/*
	 * @return SortedSet users
	 * 
	 * Restituisce un TreeSet di User ordinato secondo userId: Manca
	 * l'implementazione dell'interfaccia Comparator in una classe da utilizzare per
	 * l'ordinamento:
	 * 
	 * public class UserComparator implements Comparator<User> {
	 * 
	 * @Override public int compare(User o1, User o2) { return
	 * o1.getUserId().compareTo(o2.getUserId(); } }
	 * 
	 * Costruire il TreeSet usando il comparator e il metodo
	 * Collections.syncronizedSortedSet
	 * 
	 * SortedSet users = Collections.syncronizedSortedSet(new TreeSet<User>(new
	 * UserComparator()));
	 */
	@Deprecated
	public static SortedSet<User> getAll() throws IOException {
		try {
			List<String> lines = Files.readAllLines(GetFileResource.get(User.fileName, User.folderName).toPath());
			SortedSet<User> users = new TreeSet<User>();
			for (String line : lines) {
				User user = null;
				String[] fields = line.split(User.fieldSeparator);
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
			e.printStackTrace();
			throw new IOException();
		}
	}

	/**
	 * Salva un oggetto user se non registrato il suo userId
	 */
	@Deprecated
	public void store() throws IOException {
		try {
			BufferedWriter writer = new BufferedWriter(
					new FileWriter(GetFileResource.get(User.fileName, User.folderName).toPath().toString(), true));
			StringBuilder builder = new StringBuilder();
			if ((this.getUserId().equals(BigInteger.ONE) || this.getUserId().compareTo(getLastId()) > 0)
					&& !getAll().contains(this)) {
				builder.append(this.getUserId());
				builder.append(User.fieldSeparator);
				builder.append(this.getFirstName());
				builder.append(User.fieldSeparator);
				builder.append(this.getLastName());
				builder.append(User.fieldSeparator);
				builder.append(this.getEmail());
				builder.append(User.fieldSeparator);
				builder.append(this.getMobilePhone());
				builder.append(User.fieldSeparator);
				builder.append(this.isActive());
				builder.append(User.fieldSeparator);
				builder.append(this.isPrivacyConsent());
				builder.append(User.fieldSeparator);
				builder.append(this.isNewsletter());
				builder.append(User.fieldSeparator);
				builder.append(System.getProperty("line.separator"));
				writer.write(builder.toString());
				writer.flush();
				writer.close();
				System.out.println("User " + this.getFirstName() + " salvato");
				addToStoredUsers(this);
			} else {
//				Implementazione del blocco per l'update o chiamata ad un metodo apposito
				System.out.println("no user stored or updated!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException();
		}
	}

	@Override
	public int compareTo(User o) {
		return o.getUserId().compareTo(userId);
	}

	public void updateUser() {

	}

	public void deleteUser() {

	}

}
