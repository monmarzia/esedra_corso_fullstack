package it.esedra.corso.esercitazioneB.antonellomaiorano;

public class Serbatoio {
	private int capacita;
	public final static int carica = 10;
	/**
	 * @param capacita
	 */
	public void setCapacita(int capacita) {
		this.capacita = capacita;
	}
	/**
	 * @return capacita
	 */
	public int getCapacita() {
		return capacita;
	}
	/**
	 * @return carica
	 */
	public int getCarica() {
		return carica;
	}
}