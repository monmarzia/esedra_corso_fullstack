package it.esedra.corso.shoppinglist.controller;

import java.io.IOException;
import java.math.BigInteger;

import javax.json.JsonException;
import javax.json.JsonObject;

import com.sun.net.httpserver.HttpExchange;

import it.esedra.corso.shoppinglist.model.User;

public class GetUser extends ShoppingListHandler {

	@Override
	public String handleRequest(HttpExchange exchange) throws IOException {
		
		User userGet = new User();
		userGet = userGet.get(BigInteger.TWO);
		
		String userString = "";
		
		try {
			userString = new JSONObject()
			        .put("user", new JSONObject()
			        		.put("isNewsletter", userGet.isNewsletter())
			        		.put("isPrivacyConsent", userGet.isPrivacyConsent())
			        		.put("isActive", userGet.isActive())
			        		.put("mobilePhone", userGet.getMobilePhone())
			        		.put("email", userGet.getEmail())
			        		.put("lastName", userGet.getLastName())
			        		.put("firstName", userGet.getFirstName()))
			        		.toString();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return userString;
	}

}
