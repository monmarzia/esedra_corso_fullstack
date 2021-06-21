package it.esedra.corso.lezioni.eccezioni;

public class EsempioEccezione {

	public void rilancioEccezione() throws MyException {
		
		try {
			int h = 10;
			int j = 0;
			int k = h/j;
			System.out.println(k);
		} catch (ArithmeticException e) {
			System.out.println("gestisco" + e.getMessage());
			throw new MyException(e.getMessage());
		}
	}
	public void metodoEccezione() {
			throw new MyArithmeticException();
	}
}
