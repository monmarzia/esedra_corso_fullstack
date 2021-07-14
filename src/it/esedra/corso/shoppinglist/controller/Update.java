package it.esedra.corso.shoppinglist.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.sun.net.httpserver.HttpExchange;

import it.esedra.corso.shoppinglist.model.Product;
import it.esedra.corso.shoppinglist.model.ShoppingList;

public class Update extends ShoppingListHandler{

	@Override
	public String handlePostRequest(HttpExchange exchange) throws IOException {
		StringBuilder sb = new StringBuilder();
		InputStream ios = exchange.getRequestBody();
		int i;
		while ((i = ios.read()) != -1) {
			sb.append((char) i);
		}

		String jsonStr = sb.toString();

		try {
			JsonReader reader = Json.createReader(new StringReader(jsonStr));
			JsonObject listaSpesaObject = reader.readObject();

			JsonArray items = listaSpesaObject.get("items").asJsonArray();

			ShoppingList shoppingList = new ShoppingList();
			for (Object o: items)  {
				JsonObject tmpObj = (JsonObject)o;
				Product item = new Product();
				item.setName(tmpObj.getString("name"));
				item.setQty(Integer.parseInt(tmpObj.getString("qty")));
				//TODO enum
				//item.setUnit(tmpObj.getString("unit"));
				shoppingList.addProduct(item);
			}

			shoppingList.store();
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException("Errore interno");
		}

		return ".";
	}

}
