package it.esedra.corso.esercitazioneB.thomasmarchese;


public class Automobile {
	
	private String targa ;	
	private Serbatoio serbatoio;
	 
	

	public Automobile(String targa, int capacitaSerbatoio) {
		
		this.targa = targa ;
		serbatoio = new Serbatoio();
		serbatoio.setCapacita(capacitaSerbatoio);
		
	}
	
	private Automobile() {
		//vuoto
	}
	
	
	public Serbatoio getSerbatoio() {
		return serbatoio;
	}
	
	public String getTarga() {
		return this.targa;
	}
	
	public void setTarga(String targa) {
		this.targa  = targa;
	}
	
    
		
	
}


