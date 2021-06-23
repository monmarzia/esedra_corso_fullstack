package it.esedra.corso.esercitazioneB.monicamarziani;

public class CapacitaSuperata extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CapacitaSuperata() {
		super("Capacità serbatoio superata");
	}
	
	@Override
	public String toString() {
		return getMessage() + ": Capacita serbatoio superata!";
	}
}
