package it.esedra.corso.shoppinglist.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.List;

import it.esedra.corso.shoppinglist.helper.GetFileResource;

/**
 * @author monica
 *
 */
public class User implements Persist {
	private static BigInteger userId = new BigInteger("0");
	private String firstName;
	private String lastName;
	private String email;
	private String mobilePhone;
	private boolean isActive = false;
	private boolean privacyConsent = false;
	private boolean newsletter = false;

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
	
	public User build() {
		return new User(firstName, lastName, email, mobilePhone, isActive, privacyConsent, newsletter);
	}
	
	/**
	 * @return the userId
	 */
	public BigInteger getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public User setUserId(BigInteger userId) {
		this.userId = userId;
		return this;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	
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

	/**
	 * @return the mobilePhone
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * @param mobilePhone the mobilePhone to set
	 */
	public User setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;
	}

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public User setActive(boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	/**
	 * @return the newsletter
	 */
	public boolean isNewsletter() {
		return newsletter;
	}

	/**
	 * @param newsletter the newsletter to set
	 */
	public User setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
		return this;
	}
	/**
	 * 
	 * @return userID incrementato di 1
	 * 
	 * Testato l'incremento: il secondo user ha userId = 2;
	 */
	
	public BigInteger getSequence() {
		return userId =	userId.add(new BigInteger("1"));
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
	
	/**
	 * Salva un oggetto user
	 * 
	 * Problema: Il file viene sovrascritto ad ogni chiamata del metodo.
	 * Il problema riguarda anche ShoppingList in quanto non possono essere salvate
	 * sul file due diverse liste, ma solo una per volta
	 * 
	 */
	public void store() throws IOException {
		try {
			PrintWriter writer = new PrintWriter(GetFileResource.get("user.csv", "shoppinglist"));
			StringBuilder builder = new StringBuilder();

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

		} catch (Exception e) {
			throw new IOException();
		}

	}

}
