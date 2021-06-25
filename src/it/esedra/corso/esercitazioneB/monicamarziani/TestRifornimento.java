package it.esedra.corso.esercitazioneB.monicamarziani;

public class TestRifornimento {

	public static void main(String[] args) {
		Automobile miaAuto1 = new Automobile("MM516XX", new Serbatoio(5));
		Automobile miaAuto2 = new Automobile("MM517XX", new Serbatoio(21));
		Automobile miaAuto3 = new Automobile("MM518XX", new Serbatoio(7));
		Automobile miaAuto4 = new Automobile("MM519XX", new Serbatoio(4));
		Automobile miaAuto5 = new Automobile("MM520XX", new Serbatoio(11));
		Distributore shell = new Distributore();

		try {
//			shell.rifornimento(miaAuto1);
			shell.rifornimento(miaAuto2);
//			shell.rifornimento(miaAuto3);
//			shell.rifornimento(miaAuto4);
//			shell.rifornimento(miaAuto5);
		} catch (CapacitaSuperata e) {
			System.out.println(e.toString());
		}

	}

}
