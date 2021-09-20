package it.esedra.corso.lezioni.eccezioni;

public class MyArithmeticException extends ArithmeticException {

	
		private static String msg = "[ECCEZIONE] Divisione per zero";
		
		public MyArithmeticException() {
			super(msg);
		}
		public MyArithmeticException(String msg) {
			super(msg);
		}
}
