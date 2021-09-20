package it.esedra.corso.shoppinglist.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;

import it.esedra.corso.shoppinglist.helper.GetFileResource;
/**
 *  Gli elementi di queso modello sono:
 *  Descrizione
 *  Quantità
 *  Prezzo
 *  Unità
 *  Identificativo univoco numerico sequenziale
 * 	TODO: valutare se rinominare in "Product"
 *  TODO: valutare l'utlizzo di un'enum al posto di "unit"
 *  TODO: Implementare identificatore numerico BigInteger,
 */

public class Product {
	private String name;
	private Integer qty;
	private Unit unit;
	private String description;
	private static BigInteger id = new BigInteger("1");

	
	public static enum Fields {
		name, qty, unit
	}
	
	/**
	 * @return id incrementato di 1
	 */
	public BigInteger getSequence() {
		return id.add(new BigInteger("1"));
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQty() {
		return qty;
	}

	public Unit getUnit() {
		return unit;
	}

	public String getName() {
		return name;
	}
	
//	public BigInteger getId() {
//		return id;
//	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
//	public void setId(BigInteger id) {
//		this.id = id;
//	}
	
	/**
	 * Restituisce un nuovo oggetto Product
	 * 
	 * 
	 * @return
	 * @throws IOException
	 */
//	public Product get() throws IOException {
//		
//		BufferedReader br = Files.newBufferedReader(GetFileResource.get("lista.csv", "shoppinglist").toPath());
//		
//		
//		String line = br.readLine();
//		
//		Product product = null;
//		
//		while (line != null) {
//			String[] fields = line.split(",");
//			BigInteger tmpId = new BigInteger(fields[4]);
//			if (tmpId.equals(this.getId())) {
//				product = new Product();
//				product.setName(fields[0]);
//				product.setQty(Integer.parseInt(fields[1]));
//				product.setUnit(Unit.valueOf(fields[2]));
//				product.setDescription(fields[3]);
//				product.setId(tmpId);
//			}	
//		}
//		return new Product();
//	}
}
