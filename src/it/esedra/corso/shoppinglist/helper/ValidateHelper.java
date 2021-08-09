package it.esedra.corso.shoppinglist.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.esedra.corso.esercitazione.mvc.ValidateException;

public class ValidateHelper {

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
	
	public static boolean validateUniqueCode(String inputString) {
		// TODO validate uniqueCode
		return true;
	}

}
