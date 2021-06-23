package it.esedra.corso.esercitazioneB.antonellomaiorano;
import java.util.*;

public class Esercizio1 {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner numero = new Scanner(System.in);
		int x = numero.nextInt();
		int y = random.nextInt(3);
		try {		
			int z = x/y;
			System.out.println(z);
		} catch (ArithmeticException e) {
			System.out.println("Divisione per zero");
		}
	}

}
