package it.esedra.corso.esercitazioneB.matteocirri.esercitazione7luglio;

import java.util.ArrayList;

public class Garage {
	private ArrayList<Veicoli> veicoli;	

	public static void main(String[] args) {
		Garage garage = new Garage(); 
		garage.veicoli.add(new Moto("Ducati"));
		garage.veicoli.add(new Auto("Audi"));
		garage.veicoli.add(new Camion("//"));
		
		for(Veicoli v : garage.veicoli) { 
			System.out.println(v.getMarca());
		}
	}
}
