package it.esedra.corso.shoppinglist.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.json.JsonException;
import javax.json.JsonObject;

import com.sun.net.httpserver.HttpExchange;

import it.esedra.corso.shoppinglist.model.User;

public class GetUser extends ShoppingListHandler {

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		try {
			this.setHttpExchangeResponseHeaders(exchange);
			String param = null;


			if (exchange.getRequestMethod().equals("GET")) {

				param = this.handleRequest(exchange);

				String response = "Get su utente: " + param;

				exchange.sendResponseHeaders(200, response.length());
				OutputStream stream = exchange.getResponseBody();

				stream.write(response.getBytes());
				stream.close();
			}

		} catch (Exception e) {

			exchange.sendResponseHeaders(500, e.getMessage().length());
			OutputStream stream = exchange.getResponseBody();

			stream.write(e.getMessage().getBytes());
			stream.close();
		}
	}

	@Override
	public String handleRequest(HttpExchange exchange) throws IOException {
		User userGet = new User();
		userGet = userGet.get();
		
		String userString = "";
		
		try {
//			userString = new JsonObject()
//			        .put("user", new JsonObject()
//			        		.put("firstName", userGet.getFirstName())
//			        		.put("lastName", userGet.getLastName())
//			        		.put("email", userGet.getEmail())
//			        		.put("mobilePhone", userGet.getMobilePhone())
//			        		.put("isActive", userGet.isActive())
//			        		.put("isPrivacyConsent", userGet.isPrivacyConsent())
//			        		.put("isNewsletter", userGet.isNewsletter()))
//			        		.toString();
		} catch (JsonException e) {
			e.printStackTrace();
		}
		
		return userString;
	}

}
