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
		auto[0].serbatoio.setCapacita(5);
		auto[1].serbatoio.setCapacita(21);
		auto[2].serbatoio.setCapacita(7);
		auto[3].serbatoio.setCapacita(4);
		auto[4].serbatoio.setCapacita(11);
		
		System.out.println("serbatoio 1a : "+auto[0].serbatoio.getCarica());
		System.out.println("serbatoio 2a : "+auto[1].serbatoio.getCarica());
		System.out.println("serbatoio 3a : "+auto[2].serbatoio.getCarica());
		System.out.println("serbatoio 4a : "+auto[3].serbatoio.getCarica());
		System.out.println("serbatoio 5a : "+auto[4].serbatoio.getCarica());
	
		
	}

	
	
	
}


