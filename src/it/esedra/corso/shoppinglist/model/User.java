package it.esedra.corso.shoppinglist.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import it.esedra.corso.shoppinglist.helper.GetFileResource;
import it.esedra.corso.shoppinglist.helper.IdSingleton;

/**
 * @author monica
 *
 */
public class User implements Persist, Comparable<User> {
	private BigInteger userId = new BigInteger("0");
	private String firstName;
	private String lastName;
	private String email;
	private String mobilePhone;
	private boolean isActive = false;
	private boolean privacyConsent = false;
	private boolean newsletter = false;
	private Map<BigInteger, User> storedUsers = new HashMap<>();

	public User() {
		
	}
	
	public User(String firstName, String lastName, String email, String mobilePhone, boolean isActive, boolean privacyConsent, boolean newsletter) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobilePhone = mobilePhone;
		this.isActive = isActive;
		this.privacyConsent = privacyConsent;
		this.newsletter = newsletter;
	}
	
	/**
	 * 
	 * @return new User()
	 * restituisce un'istanza di User con i parametri nell'ordine
	 */
	public User build() {
		return new User(firstName, lastName, email, mobilePhone, isActive, privacyConsent, newsletter);
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

	public User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public User setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	public String getEmail() {
		return email;
	}
	
	public User setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public boolean isPrivacyConsent() {
		return privacyConsent;
	}
	
	public User setPrivacyConsent(boolean privacyConsent) {
		this.privacyConsent = privacyConsent;
		return this;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public User setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;
	}

	public boolean isActive() {
		return isActive;
	}

	public User setActive(boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	public boolean isNewsletter() {
		return newsletter;
	}

	public User setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
		return this;
	}
	
	public Map<BigInteger, User> getStoredUsers() {
		return storedUsers;
	}

	/**
	 * 
	 * @return userID incrementato di 1
	 *  Sostituito getSequence() con newUserId()
	 */
	
	public BigInteger newUserId() {
		return userId = IdSingleton.newIdUser();
	}
	
	public Map<BigInteger, User> addToStoredUsers (User user) {
		storedUsers.put(user.getUserId(), user);
		return storedUsers;
	}
	
	/*
	 * @return SortedSet users
	 * 
	 * Restituisce un TreeSet di User ordinato secondo userId
	 * 
	 */
	public SortedSet<User> getAll() throws IOException {
		try {
			List<String> lines = Files.readAllLines(GetFileResource.get("user.csv", "shoppinglist").toPath());
			SortedSet<User> users = new TreeSet<User>();
			for(String line:lines) {				
				User user = null;
				String[] fields = line.split(",");
				if (!fields[0].equals("")) {
					user = new User();
					user.setActive(Boolean.parseBoolean(fields[5]));
					user.setEmail(fields[3]);
					user.setFirstName(fields[1]);
					user.setLastName(fields[2]);
					user.setMobilePhone(fields[4]);
					user.setNewsletter(Boolean.parseBoolean(fields[7]));
					user.setPrivacyConsent(Boolean.parseBoolean(fields[6]));
					user.setUserId(new BigInteger(fields[0]));
					users.add(user);
				}
			}
			return users;
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}		
	}
	
	/**
	 * 
	 * @return l'id più in alto assegnato
	 * @throws IOException
	 */
	
	public synchronized BigInteger getLastId() throws IOException{
		try {
					
			BigInteger lastId = (getAll().isEmpty())? this.getUserId() :  getAll().last().getUserId();
			return lastId;			
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}
	}
	
	/**
	 * Restituisce un nuovo oggetto User
	 * 
	 * 
	 * @return
	 * @throws IOException
	 */
	
	/**
	 * 
	 * Modifica: aggiunto blocco try/catch per gestire l'errore ed evitare l'uso del blocco
	 * nella classe TestUser.
	 * 
	 * Modificato return (era "new User()" vuoto)
	 * 
	 * Modificato Il BufferedReader con il metodo statico Files.readAlLines(path) che restituisce
	 * una List di String ciascuna con una linea. Utilizzato un ciclo for migiorato per la ricerca
	 * dello User nel file user.csv.
	 * 
	 * Modifica: aggiunta di un argomento BigInteger findId per la ricerca: se il file è vuoto, 
	 * il campo tmpUserId assume un valore BigInteger.zeroLenght e da luogo ad un flusso non gestito;
	 * 
	 */
	
	public User get(BigInteger findId) throws IOException {
		try {
			List<String> lines = Files.readAllLines(GetFileResource.get("user.csv", "shoppinglist").toPath());
			User user = null;
			for(String line:lines) {				
				String[] fields = line.split(",");
				BigInteger tmpUserId = new BigInteger(fields[0]);
				if (tmpUserId.equals(findId)) {
					user = new User();
					user.setActive(Boolean.parseBoolean(fields[5]));
					user.setEmail(fields[3]);
					user.setFirstName(fields[1]);
					user.setLastName(fields[2]);
					user.setMobilePhone(fields[4]);
					user.setNewsletter(Boolean.parseBoolean(fields[7]));
					user.setPrivacyConsent(Boolean.parseBoolean(fields[6]));
					user.setUserId(tmpUserId);
				}
			}
			return user;
		} catch (Exception e) {
			throw new IOException();
		}
				
	}
	
	/**
	 * Viene chiamato su un'istanza di User:
	 * legge i records dal file csv e se trova un record con userId corrispondente
	 * a quello dell'istanza chiamante, restituisce un nuovo user con i dati del record,
	 * altrimenti restituisce user = null;
	 * 
	 * @return
	 * @throws IOException
	 */
	public User get() throws IOException {
		try {
			List<String> lines = Files.readAllLines(GetFileResource.get("user.csv", "shoppinglist").toPath());
			User user = null;
			for(String line:lines) {				
				String[] fields = line.split(",");
				BigInteger tmpUserId = new BigInteger(fields[0]);
				if (tmpUserId.equals(this.getUserId())) {
					user = new User();
					user.setActive(Boolean.parseBoolean(fields[5]));
					user.setEmail(fields[3]);
					user.setFirstName(fields[1]);
					user.setLastName(fields[2]);
					user.setMobilePhone(fields[4]);
					user.setNewsletter(Boolean.parseBoolean(fields[7]));
					user.setPrivacyConsent(Boolean.parseBoolean(fields[6]));
					user.setUserId(tmpUserId);
				}
			}
			return user;
		} catch (Exception e) {
			throw new IOException();
		}
	}
	
	public boolean addUser(User user) {
		
		return false;
	}
	
	/**
	 * Salva un oggetto user se non è già registrato il suo userId
	 */
  
	public void store() throws IOException {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(GetFileResource.get("user.csv", "shoppinglist").toPath().toString(), true));
			StringBuilder builder = new StringBuilder();
			if ((this.getUserId().equals(BigInteger.ONE) || this.getUserId().compareTo(getLastId()) > 0) && !getAll().contains(this)) {
				builder.append(this.getUserId());
				builder.append(",");
				builder.append(this.getFirstName());
				builder.append(",");
				builder.append(this.getLastName());
				builder.append(",");
				builder.append(this.getEmail());
				builder.append(",");
				builder.append(this.getMobilePhone());
				builder.append(",");
				builder.append(this.isActive());
				builder.append(",");
				builder.append(this.isPrivacyConsent());
				builder.append(",");
				builder.append(this.isNewsletter());
				builder.append(",");
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
}
