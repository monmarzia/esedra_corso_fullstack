package it.esedra.corso.shoppinglist.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import it.esedra.corso.shoppinglist.helper.GetFileResource;
import it.esedra.corso.shoppinglist.model.User;

public class TestUser {

	public static void main(String[] args) throws IOException {
		try {
			StringBuilder sb = new StringBuilder();
			InputStream inputUser = new FileInputStream(GetFileResource.get("user.json", "test"));
			User user = null;
			int i;
			while((i = inputUser.read()) != -1) {
				sb.append((char) i);
			}
			String jsonStr = sb.toString();
			
			JsonReader reader = Json.createReader(new StringReader(jsonStr));
			JsonObject userJson = reader.readObject();
			JsonArray userArr = userJson.get("users").asJsonArray();
			for(Object el: userArr) {
				JsonObject tmpUser = (JsonObject)(el);
				String firstName = tmpUser.getString("firstName");
				String lastName = tmpUser.getString("lastName");
				String email = tmpUser.getString("email");
				String mobilePhone = tmpUser.getString("mobilePhone");
				String isActive = tmpUser.getString("isActive");
				String isPrivacyConsent = tmpUser.getString("isPrivacyConsent");
				String isNewsletter = tmpUser.getString("isNewsletter");
				user = new User()
						.setFirstName(firstName)
						.setLastName(lastName)
						.setEmail(email)
						.setMobilePhone(mobilePhone)
						.setActive(Boolean.parseBoolean(isActive))
						.setPrivacyConsent(Boolean.parseBoolean(isPrivacyConsent))
						.setNewsletter(Boolean.parseBoolean(isNewsletter))
						.build();
				user.getSequence();
				user.store();
				System.out.println("ID: " + user.get().getUserId() + " Nome: " + user.getFirstName() + ", salvato.");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
