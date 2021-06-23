package it.esedra.corso.esercitazioneB.monicamarziani;

public class TestRifornimento {

	public static void main(String[] args) {
		Automobile miaAuto = new Automobile("MM516XX", new Serbatoio(55));
		Distributore shell = new Distributore();
		
		try {
			shell.rifornimento(miaAuto);
			shell.rifornimento(miaAuto);
			shell.rifornimento(miaAuto);
			shell.rifornimento(miaAuto);
			shell.rifornimento(miaAuto);
			shell.rifornimento(miaAuto);
		} catch (CapacitaSuperata e) {
			System.out.println(e.toString());
		}

	}

}
