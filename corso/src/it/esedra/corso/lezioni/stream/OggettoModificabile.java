package it.esedra.corso.lezioni.stream;

public class OggettoModificabile implements SingleMethod {

	private String titolo;

	public OggettoModificabile(String titolo) {
		this.titolo = titolo;
	}


	public String toString() {
		return titolo;
	}


	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
}
