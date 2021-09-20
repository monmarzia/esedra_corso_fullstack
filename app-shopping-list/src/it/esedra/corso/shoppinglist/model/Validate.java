package it.esedra.corso.shoppinglist.model;

import it.esedra.corso.shoppinglist.exceptions.ValidateException;

public interface Validate {
	public void validate(String params) throws ValidateException;

}
