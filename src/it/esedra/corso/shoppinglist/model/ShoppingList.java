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

/**
 * 
 *  Gli elementi di queso modello sono:
 *  Prodotti
 *  Nome
 *  Identificatio univoco numerico sequenziale
 *  Identificatore univoco pubblico alfanumerico
 *  (questo identificatore consente di non ricevere scanning
 *  o attacchi dall'esterno)
 *  Utente
 * 	
 */

public class ShoppingList implements Persist {

	private List<Product> products = new ArrayList<Product>();
	private String listName = new String();
	private User user; 
	private BigInteger id; 
	private String uniqueCode;

	private final static Map<String, Integer> fieldsMap ;
	static {		
		HashMap<String, Integer> tmpMap = new HashMap<String, Integer>() ;
		tmpMap.put("name", 0);
		tmpMap.put("qty", 1);
		tmpMap.put("unit", 2);
		tmpMap.put("listName", 3);
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
	

	private final static String[] campi = {		
			"name",
			"qty",
			"unit",
			"listName"
	};
	private final static HashMap<String, String> fieldsMap = new HashMap<>() ;
	static {		
		for(int i = 0 ; i < campi.length; i++) {
			fieldsMap.put(campi[i],null ); // mi aggiunge alla mappa tutti i campi con le chiavi null così dopo posso richiamare i campi e rimpiazzare il null con la chiave desiderata
		}
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

	

	
public ShoppingList get() throws IOException {
		
		BufferedReader br = Files.newBufferedReader(GetFileResource.get("lista.csv", "shoppinglist").toPath());	
		
		String line = br.readLine();
		ShoppingList shoppingList = new ShoppingList();
		
		while (line != null) {
			String[] fields = line.split(",");
			BigInteger tmpId = new BigInteger("id");
			Product tmpProduct = new Product();
			if (tmpId.equals(this.getId())) {
				shoppingList = new ShoppingList();				
				tmpProduct.setName(fields[fieldsMap.get("name")]);
				tmpProduct.setQty(Integer.parseInt(fields[fieldsMap.get("qty")]));
				tmpProduct.setUnit(Unit.valueOf(fields[fieldsMap.get("unit")]));
				shoppingList.setListName(fields[fieldsMap.get("listName")]);
				shoppingList.addProduct(tmpProduct);
			}
		}
		return  shoppingList;
	}
	
	/**
	 * Salva un oggetto 
	 */
	public void store() throws IOException {

		try {

			PrintWriter writer = new PrintWriter(GetFileResource.get("lista.csv", "shoppinglist"));
			StringBuilder builder = new StringBuilder();
			for (Product listaTemp : products) {
				if (listaTemp == null) {
					continue;
				}
				builder.append(listaTemp.getName());
				builder.append(",");
				builder.append(listaTemp.getQty());
				builder.append(",");
				builder.append(listaTemp.getUnit());
				builder.append(",");
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
	
	public SortedSet<ShoppingList> getAll() throws IOException {
		try {
			List<String> lines = Files.readAllLines(GetFileResource.get("user.csv", "shoppinglist").toPath());
			SortedSet<User> users = new TreeSet<User>();
			for(String line:lines) {				
				ShoppingList shoppingList = new ShoppingList();
				String[] fields = line.split(",");
				if (!fields[0].equals("")) {
					shoppingList = new ShoppingList();
					shoppingList.setListName(fields[3]);
					Product tmpProduct;
					tmpProduct.setName(fields[0]);
					tmpProduct.setQty(Integer.parseInt(fields[1]));
					tmpProduct.setUnit(Unit.valueOf(fields[2]));
					shoppingList.addProduct(tmpProduct);
				}
			}
			return users;
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
