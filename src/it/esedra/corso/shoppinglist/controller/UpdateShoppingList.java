package it.esedra.corso.shoppinglist.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.sun.net.httpserver.HttpExchange;

import it.esedra.corso.esercitazione.mvc.ValidateException;
import it.esedra.corso.shoppinglist.helper.ValidateHelper;
import it.esedra.corso.shoppinglist.model.Product;
import it.esedra.corso.shoppinglist.model.ShoppingList;
import it.esedra.corso.shoppinglist.model.ShoppingListBuilder;
import it.esedra.corso.shoppinglist.model.Unit;
import it.esedra.corso.shoppinglist.model.Validate;

public class UpdateShoppingList extends ShoppingListHandler implements Validate {

	@Override
	public void validate(String params) throws ValidateException {
		ValidateHelper.validateShoppingList(params);
	}

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
			validate(jsonStr);
		} catch (ValidateException e1) {
			e1.printStackTrace();
		}

		try {
			JsonReader reader = Json.createReader(new StringReader(jsonStr));
			JsonObject listaSpesaObject = reader.readObject();

			JsonArray items = listaSpesaObject.get("items").asJsonArray();

			ShoppingList shoppingList = ShoppingListBuilder.builder().build();
			for (Object o : items) {
				JsonObject tmpObj = (JsonObject) o;
				Product item = new Product();
				item.setName(tmpObj.getString("name"));
				item.setQty(Integer.parseInt(tmpObj.getString("qty")));
				item.setUnit(Unit.valueOf(tmpObj.getString("unit")));
				ShoppingList shoppingListService = ShoppingListBuilder.builder().addProduct(item).build();
				shoppingList = shoppingListService;
			}

			shoppingList.store();
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException("Errore interno");
		}

		return "Lista aggiornata";
	}

}
