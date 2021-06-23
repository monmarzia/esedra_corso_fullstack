package it.esedra.corso.esercitazioneB.monicamarziani;

import java.util.Scanner;

public class Esercizio1 {

	public static void main(String[] args){
		System.out.println("Inserisci un numero per la divisione: ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int div = (int) (Math.random() * 3);
		
		try {
			System.out.println("Divido " + num + " per " + div);
			int res = num/div;
			System.out.println(res);
		} catch (ArithmeticException e) {
			System.out.println("Errore nella divisione " + e.getMessage());
		} finally {
			System.out.println("Operazione terminata");
		}
		
	}

}
