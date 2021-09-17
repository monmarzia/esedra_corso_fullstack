package it.esedra.corso.shoppinglist.exceptions;

public class ValidateException extends Exception{
	

	public ValidateException(Exception e) {
		super(e);
	}
	
	public ValidateException(String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		return getMessage() + ": Dao exception";
	}

}
