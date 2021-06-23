package it.esedra.corso.esercitazioneB.antonellomaiorano;

public class CapacitaSuperata extends Exception{

	private static String msg = "[ECCEZIONE] capacità superata";
	
	public CapacitaSuperata () {
		super(msg);
	}
	public CapacitaSuperata(String msg) {
		super(msg);
	}
}
