package it.esedra.corso.esercitazioneB.matteocirri.esercitazione9luglio;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class HashMapTest {

	public static void main(String[] args) {
		HashMapTest test = new HashMapTest();
		MapFunction<Integer, String> fun = new MapFunction<>();
		HashMap<Integer, String> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		int key;
		String val;
		System.out.println("Immettere la chiave");
		key = sc.nextInt();
		System.out.println("Immettere in valore");
		val = sc.next();
		fun.aggiungiElem(map, key, val);
		HashMap<Integer, String> map2 = new HashMap<>();
		map2 = fun.copiaMap(map);
		System.out.println(map.get(key));
		System.out.println(map2.get(key));
		fun.rimuoviMap(map);
		System.out.println(map.get(key));
	}
}
