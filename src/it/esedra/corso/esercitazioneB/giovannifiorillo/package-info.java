package it.esedra.corso.esercitazioneB.giovannifiorillo;

public class Esercizio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

public void Esercizio1();
int x = 2;
int y = 3;
try {
int z = x/y;
	System.out.println(z);
} catch (ArithmetricException exc) {
	System.out.println ("Divisione per zero...");
} catch (Exception exc) {
	exc.printStackTrace();
} finally {
	System.out.println("Operazione terminata");
	
}
