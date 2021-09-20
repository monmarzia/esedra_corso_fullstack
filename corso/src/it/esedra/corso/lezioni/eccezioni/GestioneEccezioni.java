package it.esedra.corso.lezioni.eccezioni;

public class GestioneEccezioni {

	public static void main(String[] args) {

		int a = 10;
		int b = 0;

		
		try {
			int c = a / b;
			System.out.println(c);
		} catch (NullPointerException | ArithmeticException ae) {
			// e.printStackTrace();
			System.out.println("[ECCEZIONE] " + ae.getMessage());
		} catch (Exception ioe) {
			// e.printStackTrace();
			System.out.println("[ECCEZIONE] Divisione per zero");
		} finally {
			System.out.println("Ho eseguito la divisione");
		}

		EsempioEccezione es = new EsempioEccezione();
		
		
		try {
			es.rilancioEccezione(); //rilancia  una eccezione
		} catch (MyException e) {
			System.out.println("gestisco rilancio eccezione con MyException");
		} 
		
		//es.metodoEccezione();

		System.out.println("Chiudo");
	}

}
