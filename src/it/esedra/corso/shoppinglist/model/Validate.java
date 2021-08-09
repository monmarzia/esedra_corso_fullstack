package it.esedra.corso.shoppinglist.model;

import it.esedra.corso.esercitazione.mvc.ValidateException;

public interface Validate {
	public void validate(String params) throws ValidateException;

}
