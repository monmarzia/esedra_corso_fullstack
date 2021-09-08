package it.esedra.corso.esercitazioneB.matteocirri;

public class Operazioni {
	synchronized void print (String msg, int a, int b) {
		int c = 0;
		System.out.print("[");
		if(msg == "Moltiplicazione") {
			c = a * b;
		} else if (msg == "Divisione") {
			c = a / b;
		} else if (msg == "Somma") {
			c = a + b;
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print(c);
		System.out.println("]");	
	}
}
