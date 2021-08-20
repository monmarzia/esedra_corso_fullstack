package it.esedra.corso.shoppinglist.controller;

import java.io.IOException;
import java.math.BigInteger;

import javax.json.Json;
import javax.json.JsonArrayBuilder;

import com.sun.net.httpserver.HttpExchange;

import it.esedra.corso.esercitazione.mvc.ValidateException;
import it.esedra.corso.shoppinglist.model.User;
import it.esedra.corso.shoppinglist.model.UserBuilder;
import it.esedra.corso.shoppinglist.model.Validate;

public class GetUser extends ShoppingListHandler implements Validate {

	// TODO validate uniqueCode

	@Override
	public void validate(String params) throws ValidateException {

	}

	@Override
	public String handleRequest(HttpExchange exchange) throws IOException {

		String response = "";

		try {
			String uri = exchange.getRequestURI().toString();

			String[] fieldsUri = uri.split("/");

			String uniqueCode = fieldsUri[fieldsUri.length - 1];

			validate(uniqueCode);

			User userService = UserBuilder.builder().build();
			
			User user = null;

			//User user = userService.get(UserBuilder.builder().uniqueCode(uniqueCode).build());	
			
			response = Json.createObjectBuilder()
					.add("user",
							Json.createObjectBuilder().add("isNewsletter", user.isNewsletter())
									.add("isPrivacyConsent", user.isPrivacyConsent()).add("isActive", user.isActive())
									.add("mobilePhone", user.getMobilePhone()).add("email", user.getEmail())
									.add("lastName", user.getLastName()).add("firstName", user.getFirstName()).build())
					.build().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

}
