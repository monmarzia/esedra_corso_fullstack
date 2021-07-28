package it.esedra.corso.shoppinglist.controller;

import java.io.IOException;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;

import com.sun.net.httpserver.HttpExchange;

import it.esedra.corso.shoppinglist.model.Product;
import it.esedra.corso.shoppinglist.model.ShoppingList;

public class GetShoppingList extends ShoppingListHandler {

	@Override
	public String handleRequest(HttpExchange exchange) throws IOException {

		ShoppingList shoppingList = new ShoppingList();

		shoppingList = shoppingList.get();

		String shoppingListString = "";

		List<Product> products = shoppingList.getProducts();

		try {

			JsonArray array = Json.createArrayBuilder().build();

			for (Product p : products) {
				array.add(Json.createObjectBuilder().add("name", p.getName()).add("qty", p.getQty()).build());
			}

			shoppingListString = Json.createObjectBuilder().add("list", array).build().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return shoppingListString;
	}

}
