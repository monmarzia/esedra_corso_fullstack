package it.esedra.corso.esercitazioneB.matteocirri;

public class Distributore {

	public static void rifornimento(Automobile automobile) throws CapacitaSuperata {
		if (automobile.getSerbatoio().getCapacita() < automobile.getSerbatoio().getCarica()) {
			throw new CapacitaSuperata(automobile);
		}
		System.out.println(automobile.getSerbatoio().getCarica());
	}

	public static void main(String[] args) {
		Automobile auto1 = new Automobile("aaa", 5);
		Automobile auto2 = new Automobile("bbb", 21);
		Automobile auto3 = new Automobile("ccc", 7);
		Automobile auto4 = new Automobile("ddd", 4);
		Automobile auto5 = new Automobile("eee", 11);
		Automobile[] automobili = new Automobile[5];
		automobili[0] = auto1;
		automobili[1] = auto2;
		automobili[2] = auto3;
		automobili[3] = auto4;
		automobili[4] = auto5;
		for (int i = 0; i < automobili.length; i++) {
			try {
				Distributore.rifornimento(automobili[i]);
			} catch (CapacitaSuperata e) {
				e.printStackTrace();
			}
		}
	}
}