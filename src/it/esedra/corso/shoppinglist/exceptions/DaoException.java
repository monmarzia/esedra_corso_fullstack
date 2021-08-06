package it.esedra.corso.shoppinglist.exceptions;

import java.io.IOException;

public class DaoException extends IOException{
	
	public DaoException(String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		return getMessage() + ": Dao exception";
	}

}
