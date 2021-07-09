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

public class Server {

	/**
	 * Run server
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
		server.createContext("/", new MyHandler());
		server.createContext("/add-shopping-list", new AddShoppingList());
		server.setExecutor(null);
		server.start();
		System.out.println("Server stared");
	}

	static class MyHandler implements HttpHandler {

		@Override
		public void handle(HttpExchange exchange) throws IOException {
			MyHandler.setHttpExchangeResponseHeaders(exchange);
			String param = null;
			if (exchange.getRequestMethod().equals("POST")) {
				param = this.handlePostRequest(exchange);
			}
			String response = "Benvenuto mi hai passato: " + param;

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

				String prodotto = listaSpesaObject.get(0).asJsonObject().getString("prodotto");

				String quantita = listaSpesaObject.get(0).asJsonObject().getString("quantita");

				System.out.println(prodotto);
				System.out.println(quantita);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new IOException("Errore interno");
			}

			return ".";
		}

	}
}
