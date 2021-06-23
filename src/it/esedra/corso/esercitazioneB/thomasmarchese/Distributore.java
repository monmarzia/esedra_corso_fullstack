package it.esedra.corso.esercitazioneB.thomasmarchese;

import it.esedra.corso.lezioni.eccezioni.MyException;

public class Distributore {
	
	
	public Automobile rifornimento(Automobile automobile) {
	
		try {
			
			automobile.serbatoio.setCarica(10);
			
			if(automobile.serbatoio.getCapacita() < 10)
				throw new CapacitaSuperata("la capacita' è stat superata");
			
		} catch(Exception e) {
			System.out.println(e.getMsg());
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
		
	
		System.out.println("serbatoio 1a : " + auto[0].serbatoio.getCarica());
		System.out.println("serbatoio 2a : " + auto[1].serbatoio.getCarica());
		System.out.println("serbatoio 3a : " + auto[2].serbatoio.getCarica());
		System.out.println("serbatoio 4a : " + auto[3].serbatoio.getCarica());
		System.out.println("serbatoio 5a : " + auto[4].serbatoio.getCarica());
	
		
	}

	
	
	
}


