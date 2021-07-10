package it.esedra.corso.francescorossi;

public class ListaSpesaBuilder {

	private String prodotto;
	private Integer quantita;
	private String unitaMisura;
	private String nomeLista;

	public ListaSpesaBuilder() {

	}

	public ListaSpesaBuilder(String prodotto, Integer quantita, String unitaMisura, String nomeLista) {

		this.prodotto = prodotto;
		this.quantita = quantita;
		this.unitaMisura = unitaMisura;
		this.nomeLista = nomeLista;

	}

	public ListaSpesa build() {
		return new ListaSpesa(prodotto, quantita, unitaMisura, nomeLista);
	}

	public String getProdotto() {
		return prodotto;
	}

	public ListaSpesaBuilder setProdotto(String prodotto) {
		this.prodotto = prodotto;
		return this;
	}

	public Integer getQuantita() {
		return quantita;
	}

	public ListaSpesaBuilder setQuantita(Integer quantita) {
		this.quantita = quantita;
		return this;
	}

	public String getUnitaMisura() {
		return unitaMisura;
	}

	public ListaSpesaBuilder setUnitaMisura(String unitaMisura) {
		this.unitaMisura = unitaMisura;
		return this;
	}

	public String getNomeLista() {
		return nomeLista;
	}

	public ListaSpesaBuilder setNomeLista(String nomeLista) {
		this.nomeLista = nomeLista;
		return this;
	}

}
