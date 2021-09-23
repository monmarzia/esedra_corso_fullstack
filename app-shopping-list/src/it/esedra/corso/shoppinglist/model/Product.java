package it.esedra.corso.shoppinglist.model;

import java.math.BigInteger;

/**
 * Entity Gli elementi di queso modello sono: Descrizione Quantità Prezzo Unità
 * Identificativo univoco numerico sequenziale TODO: Implementare identificatore
 * numerico BigInteger,
 */

public class Product {
	private String name;
	private Integer qty;
	private Unit unit;
	private String description;

	public static enum Fields {
		name, qty, unit
	}

	public Product() {

	}

	public Product(String name, Integer qty, Unit unit) {
		this.name = name;
		this.qty = qty;
		this.unit = unit;
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

	public void setName(String name) {
		this.name = name;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

}
