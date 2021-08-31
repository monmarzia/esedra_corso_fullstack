package it.esedra.corso.lezioni.lambda;

public class Lambda {
	public static void main(String[] args) {

		new Thread(() ->  System.out.println("Java 8 programmazione funzionale")).start();
		
		
		Runnable r = () ->  System.out.println("Java 8 programmazione funzionale");
		
		
		

	}
	
	/**
	 * SINTASSI LAMBDA
	 * 
	 * 
	 * ( [LISTA PARAMETRI] ) -> {  BLOCCO DI CODICE  }
	 * 
	 * 
	 */
}
