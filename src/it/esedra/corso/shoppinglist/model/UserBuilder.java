package it.esedra.corso.shoppinglist.model;

import java.math.BigInteger;

public class UserBuilder {
	private String firstName;
	private String lastName;
	private String email;
	private String mobilePhone;
	private boolean isActive = false;
	private boolean privacyConsent = false;
	private boolean newsletter = false;
	
	public UserBuilder(String firstName, String lastName, String email, String mobilePhone, boolean isActive,
			boolean privacyConsent, boolean newsletter) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobilePhone = mobilePhone;
		this.isActive = isActive;
		this.privacyConsent = privacyConsent;
		this.newsletter = newsletter;
	}
	
	public UserBuilder() {
		
	}
	
	public static UserBuilder builder() {
		return new UserBuilder();
	}
	
	public User build() {
		return new User(firstName, lastName, email, mobilePhone, isActive,
			privacyConsent, newsletter);
	}

	public UserBuilder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public UserBuilder setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public UserBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	public UserBuilder setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;
	}

	public UserBuilder setActive(boolean isActive) {
		this.isActive = isActive;		
		return this;
	}

	public UserBuilder setPrivacyConsent(boolean privacyConsent) {
		this.privacyConsent = privacyConsent;
		return this;
	}

	public UserBuilder setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
		return this;
	}
	
	
	
}
