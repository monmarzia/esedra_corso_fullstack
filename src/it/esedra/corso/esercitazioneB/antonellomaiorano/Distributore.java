package it.esedra.corso.esercitazioneB.antonellomaiorano;

public class Distributore {
	
	public void rifornimento(Automobile automobile)  throws CapacitaSuperata{
		if (automobile.getSerbatoio().getCarica() > automobile.getSerbatoio().getCapacita()) {
			throw new CapacitaSuperata();
		}
		System.out.println("Ho effettuato una carica di: " + automobile.getSerbatoio().getCarica());	
	}
}
