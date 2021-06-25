package it.esedra.corso.esercitazioneB.antonellomaiorano;


public class Automobile {
	private String targa;
	private Serbatoio serbatoio;
	
	public Automobile(String targa, int capacitaSerbatoio) {
		this.targa = targa;
		this.serbatoio = new Serbatoio();
		this.serbatoio.setCapacita(capacitaSerbatoio);
	}
	private Automobile() {
			
		}
	
	/**
	 * @param targa 
	 */
	public void setTarga(String targa) {
		this.targa = targa;
	}
	
	/**
	 * @return targa
	 */
	public String getTarga() {
		return targa;
	}
	/**
	 * @param serbatoio 
	 */
	public void setSerbatoio(Serbatoio serbatoio) {
		this.serbatoio = serbatoio;
	}
	
	/**
	 * @return serbatoio
	 */
	public Serbatoio getSerbatoio() {
		return serbatoio;
	}
}
