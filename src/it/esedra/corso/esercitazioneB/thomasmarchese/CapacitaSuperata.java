package it.esedra.corso.esercitazioneB.thomasmarchese;

public class CapacitaSuperata extends Exception {
	
		private static String msg = "[ECCEZIONE] Custom checked";
		
		public CapacitaSuperata() {
			super(msg);
		}
		public CapacitaSuperata(String msg) {
			super(msg);
		}
		
		public String getMsg() {
			return msg;
		}
}
