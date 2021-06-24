package it.esedra.corso.esercitazioneB.thomasmarchese;


public class Distributore {
	
	private static final int caricaStandard = 10;
	
	
	public static Automobile rifornimento(Automobile automobile) {
	
		try {
			
			if(automobile.getSerbatoio().getCarica()+caricaStandard > automobile.getSerbatoio().getCapacita() ) // se la carica + 10l è maggiore della sua capacita
				throw new CapacitaSuperata("la capacità del serbatoio dell'auto targata \"" + automobile.getTarga() + "\" è stata superata");
			
			automobile.getSerbatoio().setCarica(automobile.getSerbatoio().getCarica() + caricaStandard);	// ggiunge 10 litri a quelli già presenti
				
		} catch(Exception e) {
			System.out.println(e.getMessage()+", il suo serbatoio sarà quindi riempito fino al massimo della sua capacità ");
			automobile.getSerbatoio().setCarica(automobile.getSerbatoio().getCapacita());// altrimenti carica fino a che può
		} finally {
			System.out.println("il serbatoio dell'auto targata \""+automobile.getTarga()+"\" ora contiene : "+automobile.getSerbatoio().getCarica()+" litri");
		}
		
		return automobile;
	}
	

	public static void main(String[] args) {
		
		Automobile[] auto = new Automobile[5];
				
		Automobile auto1 = new Automobile("dskl",5);
		Automobile auto2 = new Automobile("dwahb",21);
		Automobile auto3 = new Automobile("lokw",7);
		Automobile auto4 = new Automobile("fmwek",4);
		Automobile auto5 = new Automobile("reka",11);
		
		auto[0] = auto1;
		auto[1] = auto2;
		auto[2] = auto3;
		auto[3] = auto4;
		auto[4] = auto5;
		
		for(int i = 0 ; i<auto.length;i++) {
			
			rifornimento(auto[i]);			
			
		}
		
		
		
	}


	
}


