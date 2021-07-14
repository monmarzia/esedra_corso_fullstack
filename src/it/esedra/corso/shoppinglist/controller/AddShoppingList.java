package it.esedra.corso.shoppinglist.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import it.esedra.corso.shoppinglist.model.Product;
import it.esedra.corso.shoppinglist.model.ShoppingList;
import it.esedra.corso.shoppinglist.model.Unit;

public class AddShoppingList implements HttpHandler {

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		try { 
			AddShoppingList.setHttpExchangeResponseHeaders(exchange);
			String param = null;
			
			if (exchange.getRequestMethod().equals("POST")) {
				param = this.handlePostRequest(exchange);
			}
			String response = "Benvenuto mi hai passato: " + param;

			exchange.sendResponseHeaders(200, response.length());
			OutputStream stream = exchange.getResponseBody();

			stream.write(response.getBytes());
			stream.close();
		} catch (Exception e) {

			exchange.sendResponseHeaders(500, e.getMessage().length());
			OutputStream stream = exchange.getResponseBody();

			stream.write(e.getMessage().getBytes());
			stream.close();
		}
		

	}

	private static void setHttpExchangeResponseHeaders(HttpExchange httpExchange) {
		// Set common response headers
		httpExchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
		httpExchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
		httpExchange.getResponseHeaders().add("Access-Control-Allow-Headers", "*");
		httpExchange.getResponseHeaders().add("Access-Control-Allow-Credentials", "true");
		httpExchange.getResponseHeaders().add("Access-Control-Allow-Credentials-Header", "*");
	}

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
				item.setUnit(Unit.valueOf(tmpObj.getString("unit")));
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
