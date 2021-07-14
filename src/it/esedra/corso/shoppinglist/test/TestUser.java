package it.esedra.corso.shoppinglist.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.json.Json;
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
			int i;
			while((i = inputUser.read()) != -1) {
				sb.append((char) i);
			}
			String jsonStr = sb.toString();
			
			JsonReader reader = Json.createReader(new StringReader(jsonStr));
			JsonObject userObj = reader.readObject().get("user").asJsonObject();
			String firstName = userObj.getString("firstName");
			String lastName = userObj.getString("lastName");
			String email = userObj.getString("email");
			String mobilePhone = userObj.getString("mobilePhone");
			String isActive = userObj.getString("isActive");
			String isPrivacyConsent = userObj.getString("isPrivacyConsent");
			String isNewsletter = userObj.getString("isNewsletter");
			User user = new User()
					.setFirstName(firstName)
					.setLastName(lastName)
					.setEmail(email)
					.setMobilePhone(mobilePhone)
					.build();
			user.store();
			System.out.println(user.getUserId());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
