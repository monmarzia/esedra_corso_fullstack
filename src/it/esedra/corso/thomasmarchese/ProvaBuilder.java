package it.esedra.corso.thomasmarchese;

import it.esedra.corso.francescorossi.ListaSpesa;

public class ProvaBuilder {

	private String nome;
	private String cognome;
	private String annoNascita;
	private String altezza;
	private int peso;
	
	public String getNome() {
		return nome;
	}
	public ProvaBuilder setNome(String nome) {
		this.nome = nome;
		return this;
	}
	public String getCognome() {
		return cognome;
	}
	public ProvaBuilder setCognome(String cognome) {
		this.cognome = cognome;
		return this;
	}
	public String getAnnoNascita() {
		return annoNascita;
	}
	public ProvaBuilder setAnnoNascita(String annoNascita) {
		this.annoNascita = annoNascita;
		return this;
	}
	public String getAltezza() {
		return altezza;
	}
	public ProvaBuilder setAltezza(String altezza) {
		this.altezza = altezza;
		return this;
	}
	public int getPeso() {
		return peso;
	}
	public ProvaBuilder setPeso(int peso) {
		this.peso = peso;
		return this;
	}
	
	public ProvaBuilder(String nome, String cognome, String annoNascita, String altezza, int peso) {
		this.nome = nome;
		this.cognome = cognome;
		this.annoNascita = annoNascita;
		this.altezza = altezza;
		this.peso = peso;
		
	}

	public ProvaBuilder() {
				
	}
	
	
	public Prova build() {
		return new Prova(nome, cognome, annoNascita, altezza, peso);
	}
	
}
