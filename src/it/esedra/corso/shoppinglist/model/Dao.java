package it.esedra.corso.shoppinglist.model;

import java.math.BigInteger;
import java.util.SortedSet;

import it.esedra.corso.shoppinglist.exceptions.DaoException;

public interface Dao <T>{
	public void save(T t) throws DaoException;
	public T get(BigInteger id) throws DaoException;
	public void delete(BigInteger id) throws DaoException;
	public SortedSet<T> find(T t) throws DaoException;

}
