package it.esedra.corso.shoppinglist.model;

import java.io.IOException;
import java.util.SortedSet;

public interface Dao <T>{
	public T get(T t) throws IOException;
	public void store() throws IOException;
	public SortedSet<T> getAll() throws IOException;
	public void update();
	public void delete();
}
