package it.esedra.corso.shoppinglist.model;

public class Item {
	private String name;
	private Integer qty;
	private String unit;


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
