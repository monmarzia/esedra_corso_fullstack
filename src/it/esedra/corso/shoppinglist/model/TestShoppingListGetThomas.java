package it.esedra.corso.shoppinglist.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

public class TestShoppingListGetThomas implements Persist {

	private List<Product> products = new ArrayList<Product>();
	private String listName = new String();
	private User user; 
	private BigInteger id; 
	private String uniqueCode;
	private final static String[] campi = {		
			"name",
			"qty",
			"unit"
		//	,"listName" non presente nel file
	};
	private final static HashMap<String, String> fieldsMap = new HashMap<>() ;
	static {		
		for(int i = 0 ; i < campi.length; i++) {
			fieldsMap.put(campi[i],null ); // mi aggiunge alla mappa tutti i campi con le chiavi null così dopo posso richiamare i campi e rimpiazzare il null con la chiave desiderata
		}
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
	 * Restituisce un nuovo oggetto con il nome della lista e le proprietà del prodotto
	 * 
	 * 
	 * @return
	 * @throws IOException
	 */
	
	
	
	
public void aggiornaMappa(String[] fields) {
		
		for(int i = 0 ; i < campi.length; i++) {
			fieldsMap.replace(campi[i],fields[i] );
		}
	}


public static void main(String[] args) throws IOException {
	TestShoppingListGetThomas prova = new TestShoppingListGetThomas();
	prova.get();
}

	
	
	public void get() throws IOException {
		
		BufferedReader br = Files.newBufferedReader(GetFileResource.get("lista.csv", "shoppinglist").toPath());	
		
		String line = br.readLine();
		String[] fields = line.split(",");
		aggiornaMappa(fields);									
		System.out.println(fieldsMap.get("name"));
		System.out.println(Integer.parseInt(fieldsMap.get("qty")));
		System.out.println(Unit.valueOf(fieldsMap.get("unit")));
		//System.out.println(fieldsMap.get("listName")); non presente nel file
			
			
		
		
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

}
