package it.esedra.corso.shoppinglist;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.InetSocketAddress;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import it.esedra.corso.shoppinglist.controller.AddShoppingList;
import it.esedra.corso.shoppinglist.controller.AddUser;


public class Server {

	/**
	 * Run server
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		HttpServer server = HttpServer.create(new InetSocketAddress(3000), 0);
		server.createContext("/", new DefaultHandler());
		server.createContext("/add-shopping-list", new AddShoppingList());
		server.createContext("/add-user", new AddUser());
		server.setExecutor(null);
		server.start();
		System.out.println("Server started"); 
	}

	static class DefaultHandler implements HttpHandler {

		@Override
		public void handle(HttpExchange exchange) throws IOException {
			DefaultHandler.setHttpExchangeResponseHeaders(exchange);
			String response = "Benvenuto su Shopping List";

			exchange.sendResponseHeaders(200, response.length());
			OutputStream stream = exchange.getResponseBody();

			stream.write(response.getBytes());
			stream.close();

		}

		private static void setHttpExchangeResponseHeaders(HttpExchange httpExchange) {
			// Set common response headers
			httpExchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
			httpExchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
			httpExchange.getResponseHeaders().add("Access-Control-Allow-Headers", "*");
			httpExchange.getResponseHeaders().add("Access-Control-Allow-Credentials", "true");
			httpExchange.getResponseHeaders().add("Access-Control-Allow-Credentials-Header", "*");
		}

	}
}
