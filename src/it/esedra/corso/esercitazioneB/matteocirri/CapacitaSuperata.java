package it.esedra.corso.esercitazioneB.matteocirri;

public class CapacitaSuperata extends Exception{
	
		public CapacitaSuperata() {
			super("Problema con la capacita");
		}
		
		@Override
		public String toString() {
			return getMessage() + ": capacità superata";
		}
		
		public CapacitaSuperata(Automobile automobile) {
			super("Capacità superata per " + automobile.getTarga());
		}
}
