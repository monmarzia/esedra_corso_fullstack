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

import it.esedra.corso.esercitazione.mvc.ValidateException;
import it.esedra.corso.shoppinglist.helper.ValidateHelper;
import it.esedra.corso.shoppinglist.model.User;
import it.esedra.corso.shoppinglist.model.UserBuilder;
import it.esedra.corso.shoppinglist.model.Validate;

public class AddUser extends ShoppingListHandler implements Validate {

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

		try {
			validate(jsonStr);
		} catch (ValidateException e1) {
			e1.printStackTrace();
		}

		User user = null;

		try {
			JsonReader reader = Json.createReader(new StringReader(jsonStr));
			JsonObject userJson = reader.readObject();
			JsonArray userArr = userJson.get("users").asJsonArray();
			for (Object el : userArr) {
				JsonObject tmpUser = (JsonObject) (el);

				user = UserBuilder.builder().firstName(tmpUser.getString("firstName"))
						.lastName(tmpUser.getString("lastName")).email(tmpUser.getString("email"))
						.mobilePhone(tmpUser.getString("mobilePhone"))
						.active(Boolean.parseBoolean(tmpUser.getString("isActive")))
						.privacyConsent(Boolean.parseBoolean(tmpUser.getString("isPrivacyConsent")))
						.newsletter(Boolean.parseBoolean(tmpUser.getString("isNewsletter"))).build();
				user.newUserId();
				user.store();
			}
			// System.out.println(user.getUserId());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return "Utente aggiunto";
	}

	@Override
	public void validate(String params) throws ValidateException {
		JsonReader reader = Json.createReader(new StringReader(params));
		JsonObject userJson = reader.readObject();
		JsonArray userArr = userJson.get("users").asJsonArray();
		for (Object el : userArr) {
			JsonObject tmpUser = (JsonObject) (el);
			if (ValidateHelper.validateUserName(tmpUser.get("firstName").toString())) {
				throw new ValidateException("Non è un nome valido per un utente");
			}
			if (ValidateHelper.validateUserName(tmpUser.get("lastName").toString())) {
				throw new ValidateException("Non è un cognome valido per un utente");
			}

			if (ValidateHelper.validateEmail(tmpUser.get("email").toString())) {
				throw new ValidateException("Non è un'email valida");
			}

			try {
				Integer.parseInt(tmpUser.get("mobilePhone").toString());
			} catch (NumberFormatException e) {
				throw new ValidateException("La quantità inserita non è un intero");
			}
			
			if (!Boolean.parseBoolean(tmpUser.get("isActive").toString())) {
				throw new ValidateException("isActive non è boolean");
			}
			if (!Boolean.parseBoolean(tmpUser.get("isPrivacyConsent").toString())) {
				throw new ValidateException("isPrivacyConsent non è boolean");
			}
			if (!Boolean.parseBoolean(tmpUser.get("isNewsletter").toString())) {
				throw new ValidateException("isNewsletter non è boolean");
			}


		}
	}

}
