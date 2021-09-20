package it.esedra.corso.shoppinglist.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.sun.net.httpserver.HttpExchange;

import it.esedra.corso.shoppinglist.helper.GetFileResource;
import it.esedra.corso.shoppinglist.model.Product;
import it.esedra.corso.shoppinglist.model.ShoppingList;
import it.esedra.corso.shoppinglist.model.Unit;
import it.esedra.corso.shoppinglist.model.User;

public class AddUser extends ShoppingListHandler {

	public String handlePostRequest(HttpExchange exchange) throws IOException {

		//� praticamente TestUser con un unica modifica
		
		try {
//MODIFICA  InputStream inputUser = new FileInputStream(GetFileResource.get("user.json", "test"));
			InputStream inputUser = exchange.getRequestBody(); //possibile avendo fatto partire AddUser tramite richiesta usando AddUserTest per postare sul body
			

			StringBuilder sb = new StringBuilder();
			int i;
			while((i = inputUser.read()) != -1) {
				sb.append((char) i);
			}
			String jsonStr = sb.toString();
			
			JsonReader reader = Json.createReader(new StringReader(jsonStr));
			JsonObject userObj = reader.readObject().get("user").asJsonObject();
			String firstName = userObj.getString("firstName");
			String lastName = userObj.getString("lastName");
			String email = userObj.getString("email");
			String mobilePhone = userObj.getString("mobilePhone");
			String isActive = userObj.getString("isActive");
			String isPrivacyConsent = userObj.getString("isPrivacyConsent");
			String isNewsletter = userObj.getString("isNewsletter");
			User user = new User()
					.setFirstName(firstName)
					.setLastName(lastName)
					.setEmail(email)
					.setMobilePhone(mobilePhone)
					.build();
			user.store();
		//	System.out.println(user.getUserId());  
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return "User aggiunto";
	}

	@Override
	public String handleRequest(HttpExchange exchange) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
