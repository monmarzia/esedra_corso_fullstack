package it.esedra.corso.esercitazioneB.matteocirri;

public class Book {
	public String author;
	public String title;
	public Double price;

	public Book(String title, Double price) {
		this.title = title;
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
