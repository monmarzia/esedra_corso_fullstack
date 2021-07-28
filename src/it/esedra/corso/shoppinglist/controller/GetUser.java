package it.esedra.corso.shoppinglist.controller;

import java.io.IOException;
import java.math.BigInteger;

import javax.json.Json;

import com.sun.net.httpserver.HttpExchange;

import it.esedra.corso.shoppinglist.model.User;

public class GetUser extends ShoppingListHandler {

	@Override
	public String handleRequest(HttpExchange exchange) throws IOException {
		
		User userGet = new User();
		userGet = userGet.get(BigInteger.TWO);
		
		String userString = "";
		
		try {
			userString = Json.createObjectBuilder()
			        .add("user", Json.createObjectBuilder()
			        		.add("isNewsletter", userGet.isNewsletter())
			        		.add("isPrivacyConsent", userGet.isPrivacyConsent())
			        		.add("isActive", userGet.isActive())
			        		.add("mobilePhone", userGet.getMobilePhone())
			        		.add("email", userGet.getEmail())
			        		.add("lastName", userGet.getLastName())
			        		.add("firstName", userGet.getFirstName()).build())
			        		.build()
			        		.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userString;
	}

}
