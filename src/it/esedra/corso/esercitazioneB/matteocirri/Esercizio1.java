package it.esedra.corso.esercitazioneB.matteocirri;

import java.util.Scanner;

public class Esercizio1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = (int) ((Math.random() * (3 - 0)) + 0);
		try {
			int c = a / b;
			System.out.println(c);
		} catch (ArithmeticException exc) {
			System.out.println("Divisione per zero");
		}
	}
}
