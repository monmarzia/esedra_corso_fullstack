package it.esedra.corso.shoppinglist.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import it.esedra.corso.shoppinglist.model.Item;
import it.esedra.corso.shoppinglist.model.ShoppingList;

public class Update extends ShoppingListHandler implements HttpHandler {

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

			ShoppingList shoppingList = GET
			for (Object o: items)  {
				JsonObject tmpObj = (JsonObject)o;
				Item item = new Item();
				item.setName(tmpObj.getString("name"));
				item.setQty(Integer.parseInt(tmpObj.getString("qty")));
				item.setUnit(tmpObj.getString("unit"));
				shoppingList.addItem(item);
			}

			shoppingList.store();
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException("Errore interno");
		}

		return ".";
	}

}
