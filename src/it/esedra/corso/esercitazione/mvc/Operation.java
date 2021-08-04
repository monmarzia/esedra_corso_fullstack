package it.esedra.corso.esercitazione.mvc;

import java.math.BigInteger;

public interface Operation<T> {
	public void save(T t) throws OperationException;

	public void get(BigInteger id) throws OperationException;

	public void delete(BigInteger id) throws OperationException;

	public void find(T t) throws OperationException;
	
	public T bind(String[] params) throws OperationException;
	
	public void process(String[] params) throws OperationException;
	
	public void processHandler(String action, T t) throws OperationException;
}
