package it.esedra.corso.esercitazioneB.monicamarziani;

public class CapacitaSuperata extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CapacitaSuperata() {
		
	}
	
	@Override
	public String toString() {
		return "Capacita serbatoio superata!";
	}
}
