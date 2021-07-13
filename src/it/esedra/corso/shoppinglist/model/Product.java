package it.esedra.corso.shoppinglist.model;

import java.math.BigInteger;
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
	private BigInteger id;


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
	
	public BigInteger getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
	public void setId(BigInteger id) {
		this.id = id;
	}

}
