package it.esedra.corso.shoppinglist.controller;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public abstract class ShoppingListHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		OutputStream stream = null;
		try {
			this.setHttpExchangeResponseHeaders(exchange);
			String param = null;

			param = this.handleRequest(exchange);

			String response = "Risposta: " + param;

			exchange.sendResponseHeaders(200, response.length());
			stream = exchange.getResponseBody();

			stream.write(response.getBytes());

		} catch (Exception e) {

			exchange.sendResponseHeaders(500, e.getMessage().length());
			stream.write(("errore: " + e.getMessage()).getBytes());
			
		} finally {
			if (stream != null) {
				stream.close();
			}
		}
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
