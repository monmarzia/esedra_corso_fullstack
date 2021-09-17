package it.esedra.corso.shoppinglist.model;

import java.io.IOException;
@FunctionalInterface
public interface Persist  {

	public void store() throws IOException;
	
}
