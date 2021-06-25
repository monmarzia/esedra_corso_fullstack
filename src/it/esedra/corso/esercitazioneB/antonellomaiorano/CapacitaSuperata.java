package it.esedra.corso.esercitazioneB.antonellomaiorano;

public class CapacitaSuperata extends Exception{

	private static String msg = "[ECCEZIONE] capacita superata";
	
	public CapacitaSuperata () {
		super(msg);
	}
	
	@Override
	
	public String toString() {
		return "Capacita serbatoio superata!";
	}
}
