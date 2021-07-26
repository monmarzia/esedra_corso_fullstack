package it.esedra.corso.shoppinglist.controller;

import java.io.IOException;
import java.math.BigInteger;

import com.sun.net.httpserver.HttpExchange;

import it.esedra.corso.shoppinglist.model.User;

public class GetUser extends ShoppingListHandler {

	@Override
	public String handleRequest(HttpExchange exchange) throws IOException {
		
		User userGet = new User();
		userGet = userGet.get(BigInteger.TWO);
		
		String userString = "";
		
		
		return userString;
	}

}
