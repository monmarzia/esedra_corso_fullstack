package it.esedra.corso.esercitazione.mvc;

import java.math.BigInteger;

/* save, get, delete e find
 */
public interface Dao<T> {
	/*
	 * private|public|protected static? TipoDiRitorno nomeDelMetodo(parametri?)
	 */
	public void save(T t) throws DaoException;

	public void get(BigInteger id) throws DaoException;

	public void delete(BigInteger id) throws DaoException;

	public void find(T t) throws DaoException;
}
