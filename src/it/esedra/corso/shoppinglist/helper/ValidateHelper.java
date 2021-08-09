package it.esedra.corso.shoppinglist.helper;

import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.apache.commons.lang3.EnumUtils;

import it.esedra.corso.esercitazione.mvc.ValidateException;
import it.esedra.corso.shoppinglist.model.ShoppingList;
import it.esedra.corso.shoppinglist.model.Unit;

public class ValidateHelper {

	public static void validateShoppingList(String params) throws ValidateException {
		JsonReader reader = Json.createReader(new StringReader(params));
		JsonObject listaSpesaObject = reader.readObject();
		try {
			Integer.parseInt(listaSpesaObject.get(ShoppingList.Fields.id.name()).toString());
		} catch (NumberFormatException e) {
			throw new ValidateException("L'id inserito non è un intero");
		}

		JsonArray items = listaSpesaObject.get("products").asJsonArray();

		for (Object o : items) {
			JsonObject tmpObj = (JsonObject) o;
			try {
				Integer.parseInt(tmpObj.get("qty").toString());
			} catch (NumberFormatException e) {
				throw new ValidateException("La quantità inserita non è un intero");
			}

			if (!EnumUtils.isValidEnum(Unit.class, tmpObj.get("unit").toString())) {
				throw new ValidateException("L'unità di misura non è corretta");
			}

			if (ValidateHelper.validateProductName(tmpObj.get("name").toString())) {
				throw new ValidateException("Non è un nome valido per un prodotto");
			}
		}

		if (ValidateHelper.validateListName(listaSpesaObject.get(ShoppingList.Fields.listName.name()).toString())) {
			throw new ValidateException("Non è un nome valido per un prodotto");
		}

	}

	public static void validateUser(String params) throws ValidateException {
		JsonReader reader = Json.createReader(new StringReader(params));
		JsonObject userJson = reader.readObject();
		JsonArray userArr = userJson.get("users").asJsonArray();
		for (Object el : userArr) {
			JsonObject tmpUser = (JsonObject) (el);
			if (ValidateHelper.validateUserName(tmpUser.get("firstName").toString())) {
				throw new ValidateException("Non è un nome valido per un utente");
			}
			if (ValidateHelper.validateUserName(tmpUser.get("lastName").toString())) {
				throw new ValidateException("Non è un cognome valido per un utente");
			}

			if (ValidateHelper.validateEmail(tmpUser.get("email").toString())) {
				throw new ValidateException("Non è un'email valida");
			}

			try {
				Integer.parseInt(tmpUser.get("mobilePhone").toString());
			} catch (NumberFormatException e) {
				throw new ValidateException("La quantità inserita non è un intero");
			}

			if (!Boolean.parseBoolean(tmpUser.get("isActive").toString())) {
				throw new ValidateException("isActive non è boolean");
			}
			if (!Boolean.parseBoolean(tmpUser.get("isPrivacyConsent").toString())) {
				throw new ValidateException("isPrivacyConsent non è boolean");
			}
			if (!Boolean.parseBoolean(tmpUser.get("isNewsletter").toString())) {
				throw new ValidateException("isNewsletter non è boolean");
			}

		}

	}

	public static boolean validateProductName(String inputString) {

		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
		Matcher matcher = pattern.matcher(inputString);
		boolean isStringContainsSpecialCharacter = matcher.find();
		if (isStringContainsSpecialCharacter)
			System.out.println(inputString + " contains special character");
		else
			System.out.println(inputString + " does NOT contain special character");

		return isStringContainsSpecialCharacter;
	}

	public static boolean validateListName(String inputString) {

		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
		Matcher matcher = pattern.matcher(inputString);
		boolean isStringContainsSpecialCharacter = matcher.find();
		if (isStringContainsSpecialCharacter)
			System.out.println(inputString + " contains special character");
		else
			System.out.println(inputString + " does NOT contain special character");

		return isStringContainsSpecialCharacter;
	}

	public static boolean validateUserName(String inputString) {

		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
		Matcher matcher = pattern.matcher(inputString);
		boolean isStringContainsSpecialCharacter = matcher.find();
		if (isStringContainsSpecialCharacter)
			System.out.println(inputString + " contains special character");
		else
			System.out.println(inputString + " does NOT contain special character");

		return isStringContainsSpecialCharacter;
	}

	public static boolean validateEmail(String inputString) {

		Pattern pattern = Pattern.compile("[^(.+)@(.+)$]");
		Matcher matcher = pattern.matcher(inputString);
		boolean isStringContainsSpecialCharacter = matcher.find();
		if (isStringContainsSpecialCharacter)
			System.out.println(inputString + " contains special character");
		else
			System.out.println(inputString + " does NOT contain special character");

		return isStringContainsSpecialCharacter;
	}

	public static boolean validateId(String inputString) {
		// TODO validate uniqueCode
		return true;
	}
	
	public static boolean validateUniqueCode(String inputString) {
		// TODO validate uniqueCode
		return true;
	}

}
