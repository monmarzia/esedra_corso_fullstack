package it.esedra.corso.shoppinglist.helper;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.esedra.corso.shoppinglist.exceptions.DaoException;
import it.esedra.corso.shoppinglist.model.ShoppingList;
import it.esedra.corso.shoppinglist.model.User;
import it.esedra.corso.shoppinglist.model.UserDao;

public final class SequenceManager {
	private static SequenceManager instance;
	private BigInteger idUser = new BigInteger("0");
	private BigInteger idShoppingList = new BigInteger("0");
	private final static Logger logger = LoggerFactory.getLogger(SequenceManager.class.getName());

	private SequenceManager() {

	}

	public static SequenceManager getInstance() {
		try {
			if (instance == null) {
				instance = new SequenceManager();

				UserDao userDao = new UserDao();
				instance.idUser = SequenceManager.findLastUserId(userDao.getAll());
				instance.idShoppingList = ShoppingList.getLastId();

			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return instance;
	}

	public BigInteger getCurrentIdUser() { // Id corrente: è già l'ultimo assegnato
		return getInstance().idUser;
	}

	/**
	 * 
	 * @return a new BigInteger idUser
	 * 
	 */
	public synchronized BigInteger getNewIdUser() { // Incrementa l'id corrente e restituisce il nuovo valore
		return getInstance().idUser = idUser.add(BigInteger.ONE);
	}

	public BigInteger getIdShoppingList() {
		return getInstance().idShoppingList;
	}

	/**
	 * 
	 * @return a new BigInteger idShoppingList
	 * @throws IOException
	 * 
	 */
	public static synchronized BigInteger newIdShoppingList() throws IOException {
		SequenceManager.getInstance().idShoppingList = SequenceManager.getInstance().idShoppingList.add(BigInteger.ONE);
		return SequenceManager.getInstance().idShoppingList;
	}

	/**
	 * Get the last inserted user Id
	 * 
	 * @return l'id più in alto assegnato
	 * @throws IOException
	 */

	public static synchronized BigInteger findLastUserId(Collection<User> users) throws IOException {
		if (users == null) {
			users = new ArrayList<User>();
		}
		BigInteger lastId = (users.isEmpty()) ? SequenceManager.getInstance().getNewIdUser()
				: users.stream().sorted((u1, u2) -> u1.getUserId().compareTo(u2.getUserId())).reduce((f, s) -> s)
						.orElse(null).getUserId();
		return lastId;

	}

}
