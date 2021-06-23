package it.esedra.corso.esercitazioneB.monicamarziani;

public class Serbatoio {
	private int capacita;
	private int carica = 0;
	
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
		this.carica += 10;
		if (this.carica > this.capacita) {
			System.out.println("L\'Auto ha un serbatoio di " + this.capacita + " litri");
			throw new CapacitaSuperata();
		}
	}
	
	
}
