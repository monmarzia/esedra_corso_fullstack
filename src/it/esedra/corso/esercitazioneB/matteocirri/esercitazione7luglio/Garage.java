package it.esedra.corso.esercitazioneB.matteocirri.esercitazione7luglio;

import java.util.ArrayList;

public class Garage<T> {
	private ArrayList<T> veicoli;	

	public static void main(String[] args) {
		Garage<Veicoli> garage = new Garage<Veicoli>(); 
		garage.veicoli.add(new Moto("Ducati"));
		garage.veicoli.add(new Auto("Audi"));
		garage.veicoli.add(new Camion("//"));
		
		for(Veicoli v : garage.veicoli) { 
			System.out.println(v.getMarca());
		}
	}
}
