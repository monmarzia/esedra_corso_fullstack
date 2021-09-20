package it.esedra.corso.esercitazione.mvc;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Product {

	public Product() {

	}

	private String name = new String();
	private BigInteger id = null;
	private BigDecimal price = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	
}
