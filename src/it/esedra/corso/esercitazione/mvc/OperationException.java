package it.esedra.corso.esercitazione.mvc;

public class OperationException extends  Exception{
	public OperationException(String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		return getMessage() + ": Dao exception";
	}
}
