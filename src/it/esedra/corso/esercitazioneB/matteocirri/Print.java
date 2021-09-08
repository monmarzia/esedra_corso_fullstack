package it.esedra.corso.esercitazioneB.matteocirri;

import java.util.function.IntFunction;

public class Print {
	 public static String stampaStringa (int n) {
		 return Integer.toString(n);
	 }

	 public static void main (String[] args) {

		 IntFunction<String> print = Print::stampaStringa;

		 print.apply(5);
	 }
}