package it.esedra.corso.shoppinglist.helper;

import java.math.BigInteger;

public final class IdSingleton {
	private static IdSingleton instance = getInstance();
	private static BigInteger idUser = new BigInteger("0");
	private static BigInteger idShoppingList = new BigInteger("0");
	
	private IdSingleton() {

	}
	
	public static IdSingleton getInstance() {
		if(instance == null) {
			instance = new IdSingleton();
		}
		return instance;
	}

	public static BigInteger getIdUser() { // Id corrente: è già l'ultimo assegnato
		return idUser;
	}

	public static synchronized BigInteger newIdUser() { // Incrementa l'id corrente e restituisce il nuovo valore
		return IdSingleton.idUser = idUser.add(BigInteger.ONE);
	}

	public static BigInteger getIdShoppingList() {
		return idShoppingList;
	}

	public static synchronized BigInteger newIdShoppingList() {
		return IdSingleton.idShoppingList = idShoppingList.add(BigInteger.ONE);
	}
	
}
