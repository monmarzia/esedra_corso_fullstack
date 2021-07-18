package it.esedra.corso.shoppinglist.controller;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public abstract class ShoppingListHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange exchange) throws IOException {
	}

	public abstract String handleRequest(HttpExchange exchange) throws IOException;

	protected void setHttpExchangeResponseHeaders(HttpExchange httpExchange) {
		// Set common response headers
		httpExchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
		httpExchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
		httpExchange.getResponseHeaders().add("Access-Control-Allow-Headers", "*");
		httpExchange.getResponseHeaders().add("Access-Control-Allow-Credentials", "true");
		httpExchange.getResponseHeaders().add("Access-Control-Allow-Credentials-Header", "*");
	}

}
