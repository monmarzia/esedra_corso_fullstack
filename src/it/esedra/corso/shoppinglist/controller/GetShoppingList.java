package it.esedra.corso.shoppinglist.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;

import com.sun.net.httpserver.HttpExchange;

import it.esedra.corso.shoppinglist.helper.GetFileResource;

public class GetShoppingList extends ShoppingListHandler {

	@Override
	public String handleRequest(HttpExchange exchange) throws IOException {
		
		String response = "";
		
		try {
			String uri = exchange.getRequestURI().toString();

			String[] fieldsUri = uri.split("/");

			String uniqueCode = fieldsUri[fieldsUri.length - 1];

			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

}
