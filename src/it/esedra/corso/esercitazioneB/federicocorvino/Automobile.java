package it.esedra.corso.esercitazioneB.federicocorvino;

public class Automobile {
	private String targa;
	private Serbatoio serbatoio;
	
	public Automobile(String targa, Serbatoio serbatoio) {
		this.targa = targa;
		this.serbatoio = serbatoio;
	}
		
	public String getTarga() {
		return targa;
	}
	
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public Serbatoio getSerbatoio() {
		return serbatoio;
	}
	public void setSerbatoio(Serbatoio serbatoio) {
		this.serbatoio = serbatoio;
	}

}
