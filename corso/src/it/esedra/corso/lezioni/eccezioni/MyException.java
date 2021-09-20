package it.esedra.corso.lezioni.eccezioni;

public class MyException extends Exception {
	
		private static String msg = "[ECCEZIONE] Custom checked";
		
		public MyException() {
			super(msg);
		}
		public MyException(String msg) {
			super(msg);
		}
}
