package it.esedra.corso.shoppinglist.helper;

import java.io.IOException;
import java.math.BigInteger;

import it.esedra.corso.shoppinglist.model.User;

public final class SequenceManager {
	private static SequenceManager instance;
	private static BigInteger idUser = new BigInteger("0");
	private static BigInteger idShoppingList = new BigInteger("0");
	
	private SequenceManager() {

	}
	
	public static SequenceManager getInstance() throws IOException {
		if(instance == null) {
			instance = new SequenceManager();
		}
		try {
			idUser = User.getLastId();
//			idShoppingListId = SoppingListGetLastId();
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}
		return instance;
	}

	public static BigInteger getIdUser() { // Id corrente: è già l'ultimo assegnato
		return idUser;
	}
	/**
	 * 
	 * @return a new BigInteger idUser
	 * 
	 */
	public static synchronized BigInteger newIdUser() { // Incrementa l'id corrente e restituisce il nuovo valore
		return SequenceManager.idUser = idUser.add(BigInteger.ONE);
	}

	public static BigInteger getIdShoppingList() {
		return idShoppingList;
	}
	/**
	 * 
	 * @return a new BigInteger idShoppingList
	 * 
	 */
	public static synchronized BigInteger newIdShoppingList() {
		return SequenceManager.idShoppingList = idShoppingList.add(BigInteger.ONE);
	}
	
}
