package it.esedra.corso.esercitazioneB.thomasmarchese;

class DataBase {
	private int x ;
	private int y ;
	
	public DataBase(int x, int y) {
		this.x = x;
		this.y = y;
	}

	synchronized void stampa(int risultato, String msg) {
		
		System.out.println(msg + risultato);
	}

	public int getX() {
		return x;	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}	
	
}

class Somma implements Runnable {
	
	private DataBase dati;

	public Somma(DataBase dati) {
		this.dati = dati;
		new Thread(this).start();
	}

	public void run() {
		dati.stampa(dati.getX() + dati.getY(), "Somma : ");
	}
}


class Moltiplicazione implements Runnable {
	
	private DataBase dati;
	
	public Moltiplicazione(DataBase dati) {
		this.dati = dati;
		new Thread(this).start();
	}

	public void run() {
	
		dati.stampa(dati.getX() * dati.getY(), "Moltiplicazione : ");
	}
}

class Divisione implements Runnable {
	
	private DataBase dati;

	public Divisione(DataBase dati) {
		this.dati = dati;
		new Thread(this).start();
	}

	public void run() {
		dati.stampa(dati.getX() / dati.getY(), "Divisione : ");
	}
}


public class Synch {
	public static void main(String args[]) {
		DataBase dati = new DataBase(15,5);
		new Somma(dati);
		new Moltiplicazione(dati);
		new Divisione(dati);
	}
}