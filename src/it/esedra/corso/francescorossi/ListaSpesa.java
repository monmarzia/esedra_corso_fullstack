package it.esedra.corso.francescorossi;

public class ListaSpesa {
	
	private String prodotto;
	private Integer quantita;
	private String unitaMisura;
	private String nomeLista;
	
	
	public ListaSpesa(String prodotto, Integer quantita, String unitaMisura, String nomeLista) {
		this.prodotto = prodotto;
		this.quantita = quantita;
		this.unitaMisura = unitaMisura;
		this.nomeLista = nomeLista;		
		
	}

	public String getProdotto() {
		return prodotto;
	}


	public Integer getQuantita() {
		return quantita;
	}


	public String getUnitaMisura() {
		return unitaMisura;
	}


	public String getNomeLista() {
		return nomeLista;
	}
	
	
}
