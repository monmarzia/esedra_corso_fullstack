package it.esedra.corso.esercitazioneB.monicamarziani;

public class Automobile {
	private String targa;
	private Serbatoio serbatoio;
	
	
	public Automobile(String targa, Serbatoio serbatoio) {
		this.targa = targa;
		this.serbatoio = serbatoio;
	}
	
	private Automobile() {
		
	}
	
	/**
	 * @return the targa
	 */
	public String getTarga() {
		return targa;
	}
	/**
	 * @param targa the targa to set
	 */
	public void setTarga(String targa) {
		this.targa = targa;
	}
	/**
	 * @return the serbatoio
	 */
	public Serbatoio getSerbatoio() {
		return serbatoio;
	}
	/**
	 * @param serbatoio the serbatoio to set
	 */
	public void setSerbatoio(Serbatoio serbatoio) {
		this.serbatoio = serbatoio;
	}
	
	
	
}
