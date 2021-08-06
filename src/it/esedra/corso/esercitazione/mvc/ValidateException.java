package it.esedra.corso.esercitazione.mvc;

public class ValidateException extends  Exception{
	public ValidateException(String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		return getMessage() + ": validate exception";
	}
}
