package it.esedra.corso.esercitazioneB.matteocirri;

public class Distributore {
	
	public void rifornimento (Automobile automobile) throws CapacitaSuperata {
			if (automobile.getSerbatoio().getCapacita() < automobile.getSerbatoio().getCarica()) {
				throw new CapacitaSuperata();
			}
			System.out.println(automobile.getSerbatoio().getCarica());
	}

	public static void main(String[] args) {
		Automobile auto1 = new Automobile("aaa", 5);
		Automobile auto2 = new Automobile("bbb", 21);
		Automobile auto3 = new Automobile("ccc", 7);
		Automobile auto4 = new Automobile("ddd", 4);
		Automobile auto5 = new Automobile("eee", 11);
		Distributore distributore = new Distributore();
		try {
			distributore.rifornimento(auto1);
		}
		catch (CapacitaSuperata exc) {
			System.out.println(exc.toString());
		}
	}
}
