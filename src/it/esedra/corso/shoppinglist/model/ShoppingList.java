package it.esedra.corso.shoppinglist.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import it.esedra.corso.shoppinglist.helper.GetFileResource;
import it.esedra.corso.shoppinglist.helper.SequenceManager;

/**
 * 
 * Gli elementi di queso modello sono: Prodotti Nome Identificatio univoco
 * numerico sequenziale Identificatore univoco pubblico alfanumerico (questo
 * identificatore consente di non ricevere scanning o attacchi dall'esterno)
 * Utente
 * 
 */

public class ShoppingList implements Persist {

	private List<Product> products = new ArrayList<Product>();
	private String listName = new String();
	private User user;
	private BigInteger id;
	private String uniqueCode;
	private static final String fileName = "lista.csv";
	private static final String folderName = "shoppinglist";
	private static final String fieldSeparator = ",";

	public static enum Fields {
		listName
	}
	
	private final static Map<String, Integer> fieldsMap;
	static {
		HashMap<String, Integer> tmpMap = new HashMap<String, Integer>();
		tmpMap.put("name", 0);
		tmpMap.put("qty", 1);
		tmpMap.put("unit", 2);
		tmpMap.put(Fields.listName.name(), 3);
		fieldsMap = Collections.unmodifiableMap(tmpMap);

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getUniqueCode() {
		return uniqueCode;
	}

	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}

	public List<Product> getProducts() {
		return products;
	}

	public String getListName() {
		return listName;
	}

	public void addProduct(Product product) {
		this.products.add(product);
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	/**
	 * 
	 * @return l'id piÃ¹ in alto assegnato
	 * @throws IOException
	 */

	public static synchronized BigInteger getLastId() throws IOException {
		try {
			BigInteger lastId = (getAll().isEmpty()) ? SequenceManager.newIdUser() : getAll().last().getId();
			return lastId;
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}

	}

	public ShoppingList get() throws IOException {

		List<String> lines = Files.readAllLines(GetFileResource.get(ShoppingList.fileName, ShoppingList.folderName).toPath());

		ShoppingList shoppingList = new ShoppingList();

		for (String line : lines) {
			String[] fields = line.split(ShoppingList.fieldSeparator);
			BigInteger tmpId = new BigInteger("id");
			Product tmpProduct = new Product();
			if (tmpId.equals(this.getId())) {
				shoppingList = new ShoppingList();
				tmpProduct.setName(fields[fieldsMap.get("name")]);
				tmpProduct.setQty(Integer.parseInt(fields[fieldsMap.get("qty")]));
				tmpProduct.setUnit(Unit.valueOf(fields[fieldsMap.get("unit")]));
				shoppingList.setListName(fields[fieldsMap.get(Fields.listName.name())]);
				shoppingList.addProduct(tmpProduct);
			}
		}
		return shoppingList;
	}

	/**
	 * Salva un oggetto
	 */
	public void store() throws IOException {

		try {

			PrintWriter writer = new PrintWriter(GetFileResource.get(ShoppingList.fileName, ShoppingList.folderName));
			StringBuilder builder = new StringBuilder();
			builder.append(this.getId());
			builder.append(ShoppingList.fieldSeparator);
			builder.append(this.getListName());
			builder.append(ShoppingList.fieldSeparator);
			builder.append(this.getUniqueCode());
			builder.append(ShoppingList.fieldSeparator);
			builder.append(System.getProperty("line.separator"));
			for (Product listaTemp : products) {
				if (listaTemp == null) {
					continue;
				}
				builder.append(listaTemp.getName());
				builder.append(ShoppingList.fieldSeparator);
				builder.append(listaTemp.getQty());
				builder.append(ShoppingList.fieldSeparator);
				builder.append(listaTemp.getUnit());
				builder.append(ShoppingList.fieldSeparator);
				builder.append(this.getListName());
				builder.append(System.getProperty("line.separator"));

			}

			writer.write(builder.toString());
			writer.flush();
			writer.close();

		} catch (Exception e) {
			throw new IOException();
		}

	}

	public static SortedSet<ShoppingList> getAll() throws IOException {
		try {
			List<String> lines = Files.readAllLines(GetFileResource.get(ShoppingList.fileName, ShoppingList.folderName).toPath());
			SortedSet<ShoppingList> shoppingLists = new TreeSet<ShoppingList>();
			for (String line : lines) {
				ShoppingList shoppingList = new ShoppingList();
				String[] fields = line.split(ShoppingList.fieldSeparator);
				if (!fields[0].equals("")) {
					shoppingList = new ShoppingList();
					shoppingList.setListName(fields[fieldsMap.get(Fields.listName.name())]);
					Product tmpProduct = new Product();
					tmpProduct.setName(fields[fieldsMap.get("name")]);
					tmpProduct.setQty(Integer.parseInt(fields[fieldsMap.get("qty")]));
					tmpProduct.setUnit(Unit.valueOf(fields[fieldsMap.get("unit")]));
					shoppingList.addProduct(tmpProduct);
				}
				shoppingLists.add(shoppingList);
			}
			return shoppingLists;
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}
	}

	public void updateShoppingList() {

	}

	public void deleteShoppingList() {

	}

}
