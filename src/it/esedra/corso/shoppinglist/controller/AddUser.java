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
import it.esedra.corso.shoppinglist.model.UserBuilder;

public class AddUser extends ShoppingListHandler {

@Override
	public String handleRequest(HttpExchange exchange) throws IOException {

		InputStream inputUser = exchange.getRequestBody(); // possibile avendo fatto partire AddUser tramite richiesta
															// usando AddUserTest per postare sul body

		StringBuilder sb = new StringBuilder();
		int i;
		while ((i = inputUser.read()) != -1) {
			sb.append((char) i);
		}
		String jsonStr = sb.toString();
		
		System.out.println(jsonStr);
		
		User user = null;

		try {
			JsonReader reader = Json.createReader(new StringReader(jsonStr));
			JsonObject userJson = reader.readObject();
			JsonArray userArr = userJson.get("users").asJsonArray();
			for(Object el: userArr) {
				JsonObject tmpUser = (JsonObject)(el);
					
				user = UserBuilder.builder()
						.firstName (tmpUser.getString("firstName"))
						.lastName(tmpUser.getString("lastName"))
						.email(tmpUser.getString("email"))
						.mobilePhone(tmpUser.getString("mobilePhone"))
						.active(Boolean.parseBoolean(tmpUser.getString("isActive")))
						.privacyConsent(Boolean.parseBoolean(tmpUser.getString("isPrivacyConsent")))
						.newsletter(Boolean.parseBoolean(tmpUser.getString("isNewsletter")))
						.build();
				user.newUserId();
				user.store();
			}
			// System.out.println(user.getUserId());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return "Utente aggiunto";
	}

}
