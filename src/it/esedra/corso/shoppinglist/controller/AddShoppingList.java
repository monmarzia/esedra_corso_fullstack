package it.esedra.corso.shoppinglist.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.math.BigInteger;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.apache.commons.lang3.EnumUtils;

import com.sun.net.httpserver.HttpExchange;

import it.esedra.corso.esercitazione.mvc.ValidateException;
import it.esedra.corso.shoppinglist.helper.ValidateHelper;
import it.esedra.corso.shoppinglist.model.Product;
import it.esedra.corso.shoppinglist.model.ShoppingList;
import it.esedra.corso.shoppinglist.model.ShoppingListBuilder;
import it.esedra.corso.shoppinglist.model.Unit;
import it.esedra.corso.shoppinglist.model.Validate;

public class AddShoppingList extends ShoppingListHandler implements Validate {

	@Override
	public void validate(String params) throws ValidateException {
		JsonReader reader = Json.createReader(new StringReader(params));
		JsonObject listaSpesaObject = reader.readObject();
		try {
			Integer.parseInt(listaSpesaObject.get(ShoppingList.Fields.id.name()).toString());
		} catch (NumberFormatException e) {
			throw new ValidateException("L'id inserito non è un intero");
		}
		
		JsonArray items = listaSpesaObject.get("products").asJsonArray();
		
		for (Object o : items) {
			JsonObject tmpObj = (JsonObject) o;
			try {
				Integer.parseInt(tmpObj.get("qty").toString());
			} catch (NumberFormatException e) {
				throw new ValidateException("La quantità inserita non è un intero");
			}
			
			if (!EnumUtils.isValidEnum(Unit.class, tmpObj.get("unit").toString())) {
				throw new ValidateException("L'unità di misura non è corretta");
			}
			
			if (ValidateHelper.validateProductName(tmpObj.get("name").toString())) {
				throw new ValidateException("Non è un nome valido per un prodotto");
			}
		}
		
		if (ValidateHelper.validateListName(listaSpesaObject.get(ShoppingList.Fields.listName.name()).toString())) {
			throw new ValidateException("Non è un nome valido per un prodotto");
		}
		
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
