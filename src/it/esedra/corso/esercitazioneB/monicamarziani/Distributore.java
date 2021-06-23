package it.esedra.corso.esercitazioneB.monicamarziani;

public class Distributore {
	public void rifornimento (Automobile automobile) throws CapacitaSuperata {
		automobile.getSerbatoio().setCarica();
		System.out.println("Serbatoio a " + automobile.getSerbatoio().getCarica());
	}
}
