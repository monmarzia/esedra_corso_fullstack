package it.esedra.corso.esercitazioneB.matteocirri;

public class EsercizioThread {

	public static void main(String[] args) {
		Operazioni target = new Operazioni();
		int a = 5;
		int b = 4;
		new Caller(target, "Moltiplicazione", a, b);
		new Caller(target, "Divisione", a, b);
		new Caller(target, "Somma", a, b);
	}

}
