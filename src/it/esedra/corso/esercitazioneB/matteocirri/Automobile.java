package it.esedra.corso.esercitazioneB.matteocirri;

import it.esedra.corso.esercitazioneB.matteocirri.Serbatoio;

public class Automobile {
	private String targa;
	private Serbatoio serbatoio;
	
	public Automobile(String targa, int capacitaSerbatoio) {
		setTarga(targa);
		serbatoio = new Serbatoio();
		serbatoio.setCapacita(capacitaSerbatoio);
	}
	
	private Automobile() {}

	public String getTarga() {
	    return this.targa;
	}

	public void setTarga(String targa) {
	    this.targa = targa;
	}
	
	public Serbatoio getSerbatoio() {
	    return this.serbatoio;
	}

	public void setSerbatoio(String targa) {
	    this.serbatoio = new Serbatoio();
	}
}
