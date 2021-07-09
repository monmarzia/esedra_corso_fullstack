package it.esedra.corso.esercitazioneB.matteocirri.esercitazione9luglio;

import java.util.HashMap;

public class MapFunction<K, V> {
	
	public void aggiungiElem(HashMap<K, V> mapTest, K key, V val) {
		mapTest.put(key,  val);
	}
	
	public HashMap<K, V> copiaMap(HashMap<K, V> map) {
		HashMap<K, V> mapTest = new HashMap<>();
		mapTest = map;
		return mapTest;
	}
	
	public void rimuoviMap(HashMap<K, V> mapTest) {
		mapTest.clear();
	}
	
	
}
