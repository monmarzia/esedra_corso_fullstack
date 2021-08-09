package it.esedra.corso.shoppinglist.controller;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigInteger;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.sun.net.httpserver.HttpExchange;

import it.esedra.corso.esercitazione.mvc.ValidateException;
import it.esedra.corso.shoppinglist.model.ShoppingList;
import it.esedra.corso.shoppinglist.model.Validate;

public class DeleteShoppingList extends ShoppingListHandler implements Validate  {

	@Override
	public String handleRequest(HttpExchange exchange) throws IOException {
		return "";
	}

	@Override
	public void validate(String params) throws ValidateException {
		
		JsonReader reader = Json.createReader(new StringReader(params));
		JsonObject listaSpesaObject = reader.readObject();
		try {
			new BigInteger(listaSpesaObject.get(ShoppingList.Fields.id.name()).toString());  
		} catch (Exception e) {
			throw new ValidateException("L'id inserito non è un intero");
		}
		

		
	}

}
