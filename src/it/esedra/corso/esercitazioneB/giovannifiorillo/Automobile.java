package it.esedra.corso.esercitazioneB.giovannifiorillo;

public class Automobile {
	public String targa ; 
	private Serbatoio serbatoio;
	private Automobile(String targa, int capacitaSerbatoio) {
	
}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}
}