package it.esedra.corso.francescorossi;

public class ListaSpesa {
	public String getProdotto() {
		return prodotto;
	}
	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}
	public Integer getQuantita() {
		return quantita;
	}
	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}
	public String getUnitaMisura() {
		return unitaMisura;
	}
	public void setUnitaMisura(String unitaMisura) {
		this.unitaMisura = unitaMisura;
	}
	public String getNomeLista() {
		return nomeLista;
	}
	public void setNomeLista(String nomeLista) {
		this.nomeLista = nomeLista;
	}
	private String prodotto;
	private Integer quantita;
	private String unitaMisura;
	private String nomeLista;
}
