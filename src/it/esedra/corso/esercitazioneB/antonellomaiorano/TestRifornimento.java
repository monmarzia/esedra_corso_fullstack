package it.esedra.corso.esercitazioneB.antonellomaiorano;

public class TestRifornimento {
	public static void main(String[] args) {
		Automobile auto1 = new Automobile("sd", 5);
		Automobile auto2 = new Automobile("asfsa", 21);
		Automobile auto3 = new Automobile("asfsf", 7);
		Automobile auto4 = new Automobile("asfga", 4);
		Automobile auto5 = new Automobile("asfafaef", 11);
		Distributore q8 = new Distributore();
		
		//Automobile[] auto = {auto1, auto2, auto3 , auto4, auto5};
		
		//for(int i = 0; i < auto.length; i++) {
		try {	
//			q8.rifornimento(auto[i]);
			q8.rifornimento(auto1);
			q8.rifornimento(auto2);
			q8.rifornimento(auto3);
			q8.rifornimento(auto4);
			q8.rifornimento(auto5);
		} catch (CapacitaSuperata e) {
			System.out.println(e.toString() + " L'auto ha la targa: " + auto1.getTarga());
		}
	}
}

