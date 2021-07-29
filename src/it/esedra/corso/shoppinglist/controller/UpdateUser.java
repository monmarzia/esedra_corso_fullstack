package it.esedra.corso.shoppinglist.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.sun.net.httpserver.HttpExchange;

import it.esedra.corso.shoppinglist.model.User;

public class UpdateUser extends ShoppingListHandler {

	@Override
	public String handleRequest(HttpExchange exchange) throws IOException {

		InputStream inputUser = exchange.getRequestBody();

		StringBuilder sb = new StringBuilder();
		int i;
		while ((i = inputUser.read()) != -1) {
			sb.append((char) i);
		}
		String jsonStr = sb.toString();

		User user = null;

		try {
			JsonReader reader = Json.createReader(new StringReader(jsonStr));
			JsonObject userJson = reader.readObject();
			JsonArray userArr = userJson.get("users").asJsonArray();
			for (Object el : userArr) {
				JsonObject tmpUser = (JsonObject) (el);
				String firstName = tmpUser.getString("firstName");
				String lastName = tmpUser.getString("lastName");
				String email = tmpUser.getString("email");
				String mobilePhone = tmpUser.getString("mobilePhone");
				String isActive = tmpUser.getString("isActive");
				String isPrivacyConsent = tmpUser.getString("isPrivacyConsent");
				String isNewsletter = tmpUser.getString("isNewsletter");
				user = new User().firstName(firstName).lastName(lastName).email(email)
						.mobilePhone(mobilePhone).active(Boolean.parseBoolean(isActive))
						.privacyConsent(Boolean.parseBoolean(isPrivacyConsent))
						.newsletter(Boolean.parseBoolean(isNewsletter)).build();
				user.newUserId();
				user.store();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return "Utente aggiornato";
	}

}
