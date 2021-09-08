package it.esedra.corso.esercitazioneB.matteocirri;

public class Caller implements Runnable {
	private String msg;
	private Operazioni target;
	int a, b;
	public Caller(Operazioni t, String s, int a, int b) {
		target = t;
		msg = s;
		this.a = a;
		this.b = b;
		new Thread(this).start();
	}
	
	public void run() {
		target.print(msg, a, b);
	}
}
