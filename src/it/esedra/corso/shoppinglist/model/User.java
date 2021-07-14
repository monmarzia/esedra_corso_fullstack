package it.esedra.corso.shoppinglist.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

import it.esedra.corso.shoppinglist.helper.GetFileResource;

/**
 * 
 */
/**
 * @author monica
 *
 */
public class User implements Persist {
	private static BigInteger userId = new BigInteger("1");
	private String firstName;
	private String lastName;
	private String email;
	private String mobilePhone;
	private boolean isActive;
	private boolean privacyConsent;
	private boolean newsletter;

	public User() {
		
	}
	
	public User(String firstName, String lastName, String email, String mobilePhone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobilePhone = mobilePhone;
		isActive = false;
		privacyConsent = false;
		newsletter = false;
	}
	
	public User build() {
		return new User(firstName, lastName, email, mobilePhone);
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
	
	public void setPrivacyConsent(boolean privacyConsent) {
		this.privacyConsent = privacyConsent;
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
	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
	public void setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
	}
	
	public BigInteger getSequence() {
		return	userId.add(new BigInteger("1"));
	}

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
