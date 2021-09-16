package it.esedra.corso.shoppinglist.model;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import it.esedra.corso.shoppinglist.helper.SequenceManager;

/**
 * @author monica
 *
 */
public class User {
	private static BigInteger id = new BigInteger("0");
	private BigInteger userId = id;
	private String firstName;
	private String lastName;
	private String email;
	private String mobilePhone;
	private boolean isActive = false;
	private boolean privacyConsent = false;
	private boolean newsletter = false;
	private String uniqueCode;

	private static Dao<User> userDao = new UserDao();

	public static enum Fields {
		userId, firstName, lastName, email, mobilePhone, isActive, isPrivacyConsent, isNewsletter
	}

	public User() {

	}

	public User(BigInteger userId, String firstName, String lastName, String email, String mobilePhone,
			boolean isActive, boolean privacyConsent, boolean newsletter, String uniqueCode) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobilePhone = mobilePhone;
		this.isActive = isActive;
		this.privacyConsent = privacyConsent;
		this.newsletter = newsletter;
		this.uniqueCode = uniqueCode;
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

	public String getUniqueCode() {
		return uniqueCode;
	}

	/**
	 * Get the new user ID
	 * 
	 * @return userID incrementato di 1 Sostituito getSequence() con newUserId()
	 */

	public BigInteger newUserId() {
		return userId = SequenceManager.getInstance().getCurrentIdUser();
	}



}
