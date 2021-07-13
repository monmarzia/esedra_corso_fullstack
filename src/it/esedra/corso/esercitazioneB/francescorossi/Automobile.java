package it.esedra.corso.esercitazioneB.francescorossi;

public class Automobile {
	
	private String Targa;
	private String Matricola;
	public String getTarga() {
		return Targa;
	}
	public void setTarga(String targa) {
		Targa = targa;
	}
	public class Serbatoio extends Automobile {
		public Class getSerbatoio() {
			return Serbatoio;
		}
		public void setSerbatoio(Class serbatoio) {
			Serbatoio = serbatoio;
		}
		private Class Serbatoio;
	}
	
	

}
