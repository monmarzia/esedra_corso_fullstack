package it.esedra.corso.shoppinglist.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.math.BigInteger;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.sun.net.httpserver.HttpExchange;

import it.esedra.corso.shoppinglist.model.Product;
import it.esedra.corso.shoppinglist.model.ShoppingList;
import it.esedra.corso.shoppinglist.model.ShoppingListBuilder;
import it.esedra.corso.shoppinglist.model.Unit;

public class AddShoppingList extends ShoppingListHandler {

	@Override
	public String handleRequest(HttpExchange exchange) throws IOException {

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

			String listName = listaSpesaObject.get(ShoppingList.Fields.listName.name()).toString();
			BigInteger id = new BigInteger(listaSpesaObject.get(ShoppingList.Fields.id.name()).toString());
			
			JsonArray items = listaSpesaObject.get("products").asJsonArray();

			ShoppingListBuilder shoppingListBuilder = ShoppingListBuilder.builder();
			
			for (Object o : items) {
				JsonObject tmpObj = (JsonObject) o;
				Product item = new Product();
				item.setName(tmpObj.getString("name"));
				item.setQty(Integer.parseInt(tmpObj.getString("qty")));
				item.setUnit(Unit.valueOf(tmpObj.getString("unit")));
				shoppingListBuilder.addProduct(item);
			}
			shoppingListBuilder.id(id).listName(listName).build().store();		
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException("Errore interno");
		}

		return "Lista aggiunta";
	}
}
