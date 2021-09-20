package it.esedra.corso.lezioni.stream;

public class Snippet implements SingleMethod {
	public Snippet(String titolo) {
		this.titolo = titolo;
	}
	private String titolo;
	
	@Override
	public String getTitolo() {
		return titolo;
	}

}

