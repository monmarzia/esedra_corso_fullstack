package it.esedra.corso.esercitazioneB.monicamarziani;

import java.util.Scanner;

public class ScanTest {

	@SuppressWarnings("finally")
	public static void main(String[] args) throws Exception{
		System.out.println("Digita qualcosa");
		Scanner scan = new Scanner(System.in);
		int num = 0;
		try {
			num = scan.nextInt();
			System.out.println(num);
		} catch (Exception e) {
			System.out.println("Non hai digitato un intero valido! " + e.getMessage());
		} finally {
			System.out.println("Programma terminato.");
			scan.close();
			return;
		}
	}
}
