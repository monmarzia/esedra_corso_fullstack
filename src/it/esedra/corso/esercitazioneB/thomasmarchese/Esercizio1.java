package it.esedra.corso.esercitazioneB.thomasmarchese;
import java.util.Scanner;
import java.util.Random;


public class Esercizio1 {

	public static void main(String[] args) {
		
			
		Scanner input = new Scanner(System.in);
		Random rand = new Random();		
		
		int casuale = rand.nextInt(4); // numero fra 0 e 3		
		int numero = input.nextInt(); // numero da tastiera
		try {
			System.out.println(dividi(numero,casuale));
		} catch(Exception e) {
			System.out.println(" Impossibile dividere per 0 ");
		}
		
		
		
		
	}

	
	public static int dividi(int numeratore , int denominatore) {
		return numeratore/denominatore;
	}
	
}


