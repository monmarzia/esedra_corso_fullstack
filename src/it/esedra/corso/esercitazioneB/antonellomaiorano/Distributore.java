package it.esedra.corso.esercitazioneB.antonellomaiorano;

public class Distributore {
	
	public void rifornimento(Automobile automobile)  throws CapacitaSuperata{
		
		if(automobile.getCarica()> automobile.getCapacit‡()) {
			try {		
				automobile.setCarica(10);
				System.out.println(automobile.getCarica());
			} catch (Capacit‡Superata e) {
				System.out.println("Divisione per zero");
			}
		}
	}

}
