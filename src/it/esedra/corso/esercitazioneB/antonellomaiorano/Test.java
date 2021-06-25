package it.esedra.corso.esercitazioneB.antonellomaiorano;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws Exception {
		
		Scanner n = new Scanner(System.in);
		System.out.println("Inserisci un numero");
		try {
			int a = n.nextInt();
			System.out.println("Il numero è: " + a);
		} catch (Exception e) {
			System.out.println("Non è un numero");
			
		} finally {
			System.out.println("Programma completato");
		}
	}
}
