package it.esedra.corso.esercitazioneB.thomasmarchese;


public class Automobile {
	
	private String targa ;
	
	Serbatoio serbatoio = new Serbatoio();
	

	public Automobile(String targa, int capacitaSerbatoio) {
		
		this.targa = targa ;
		serbatoio.setCapacita(capacitaSerbatoio);
		
	}
	
	private Automobile() {
		//vuoto
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		
		
		
		
	}

	
	
	
}


