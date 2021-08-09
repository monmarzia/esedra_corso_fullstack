package it.esedra.corso.shoppinglist.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

}
