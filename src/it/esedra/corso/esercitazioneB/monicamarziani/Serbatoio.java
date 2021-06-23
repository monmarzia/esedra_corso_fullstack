package it.esedra.corso.esercitazioneB.monicamarziani;

public class Serbatoio {
	private int capacita;
	static private int carica = 10;
	
	public Serbatoio(int capacita) {
		this.capacita = capacita;
	}
	/**
	 * @return the capacita
	 */
	public int getCapacita() {
		return capacita;
	}
	/**
	 * @param capacita the capacita to set
	 */
	public void setCapacita(int capacita) {
		this.capacita = capacita;
	}
	/**
	 * @return the carica
	 */
	public int getCarica() {
		return carica;
	}
	/**
	 * @param carica the carica to set
	 */
	public void setCarica() throws CapacitaSuperata{
		Serbatoio.carica += 10;
		if (Serbatoio.carica > this.capacita) {
			throw new CapacitaSuperata();
		}
	}
	
	
}
