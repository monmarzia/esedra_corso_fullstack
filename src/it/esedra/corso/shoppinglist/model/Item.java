package it.esedra.corso.shoppinglist.model;

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

public class Item {
	private String name;
	private Integer qty;
	private String unit;
	private String description;


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

	public String getUnit() {
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

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
