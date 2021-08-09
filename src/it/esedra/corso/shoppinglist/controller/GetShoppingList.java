package it.esedra.corso.shoppinglist.controller;

import java.io.IOException;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;

import com.sun.net.httpserver.HttpExchange;

import it.esedra.corso.esercitazione.mvc.ValidateException;
import it.esedra.corso.shoppinglist.model.Product;
import it.esedra.corso.shoppinglist.model.ShoppingList;
import it.esedra.corso.shoppinglist.model.ShoppingListBuilder;
import it.esedra.corso.shoppinglist.model.Validate;

public class GetShoppingList extends ShoppingListHandler implements Validate {
	
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

			ShoppingList shoppingListService = ShoppingListBuilder.builder().build();
					
			ShoppingList shoppingList = shoppingListService.get(ShoppingListBuilder.builder().uniqueCode(uniqueCode).build());

			JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
			List<Product> products = shoppingList.getProducts();

			for (Product product : products) {
				arrayBuilder.add(
						Json.createObjectBuilder()
						.add("name", product.getName())
						.add("qty", product.getQty())
						.add("unit", product.getUnit().name()).build());
			}

			response = Json.createObjectBuilder()
					.add("products", arrayBuilder.build())
					.add("listName", shoppingList.getListName())
					.add("id", shoppingList.getId())
					.add("uniqueCode", shoppingList.getUniqueCode()).build().toString();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

}
