package it.esedra.corso.shoppinglist.controller;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public abstract class ShoppingListHandler implements HttpHandler {
	
	@Override
	public void handle(HttpExchange exchange) throws IOException {
		try { 
			this.setHttpExchangeResponseHeaders(exchange);
			String param = null;
			
			if (exchange.getRequestMethod().equals("POST")) {
				param = this.handlePostRequest(exchange);
			}
			String response = "Risposta: " + param;

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
	public abstract String handlePostRequest(HttpExchange exchange) throws IOException;
	
	private void setHttpExchangeResponseHeaders(HttpExchange httpExchange) {
		// Set common response headers
		httpExchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
		httpExchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
		httpExchange.getResponseHeaders().add("Access-Control-Allow-Headers", "*");
		httpExchange.getResponseHeaders().add("Access-Control-Allow-Credentials", "true");
		httpExchange.getResponseHeaders().add("Access-Control-Allow-Credentials-Header", "*");
	}
	
}

	
