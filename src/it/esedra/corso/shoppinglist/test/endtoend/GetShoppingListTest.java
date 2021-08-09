package it.esedra.corso.shoppinglist.test.endtoend;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import it.esedra.corso.shoppinglist.helper.GetFileResource;

public class GetShoppingListTest {

	public static void main(String[] args) {
		execute();
	}

	public static void execute() {
		try {
			// server client
			HttpClient client = HttpClient.newBuilder().version(Version.HTTP_1_1).followRedirects(Redirect.NORMAL)
					.connectTimeout(Duration.ofSeconds(80)).build();
			
			StringBuilder sb = new StringBuilder();
			InputStream inputShoppingList = new FileInputStream(GetFileResource.get("item.json", "test"));
			int i;
			while((i = inputShoppingList.read()) != -1) {
				sb.append((char) i);
			}
			String jsonStr = sb.toString();
			
			JsonReader reader = Json.createReader(new StringReader(jsonStr));
			JsonObject sbJson = reader.readObject();
			String uniqueCode = sbJson.getString("uniqueCode");
			
			//creo una request
			HttpRequest request = HttpRequest.newBuilder().version(Version.HTTP_1_1).uri(URI.create("http://localhost:3000/get-shopping-list/" + uniqueCode))
					.timeout(Duration.ofMinutes(2)).GET().build();

			HttpResponse<String> response;

			response = client.send(request, BodyHandlers.ofString());

			System.out.println(response.statusCode());
			System.out.println(response.body());

		


		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
