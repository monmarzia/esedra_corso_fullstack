package src.it.esedra.corso.thomasmarchese;

public class Prova {

	private String nome;
	private String cognome;
	private String annoNascita;
	private String altezza;
	private int peso;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getAnnoNascita() {
		return annoNascita;
	}
	public void setAnnoNascita(String annoNascita) {
		this.annoNascita = annoNascita;
	}
	public String getAltezza() {
		return altezza;
	}
	public void setAltezza(String altezza) {
		this.altezza = altezza;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public Prova(String nome, String cognome, String annoNascita, String altezza, int peso) {
		this.nome = nome;
		this.cognome = cognome;
		this.annoNascita = annoNascita;
		this.altezza = altezza;
		this.peso = peso;
		
	}

	
	
}
