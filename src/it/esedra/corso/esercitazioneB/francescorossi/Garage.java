package it.esedra.corso.esercitazioneB.francescorossi;

import java.util.ArrayList;

public class Garage {
	
	public static void main(String[] args) {
		ArrayList<String> veicoli = new ArrayList<String>();
		veicoli.add("auto");
		veicoli.add("moto");
		veicoli.add("camion");
		
		for(String tipiVeicolo : veicoli) {
			System.out.println (tipiVeicolo);
		}
	}
	
}
