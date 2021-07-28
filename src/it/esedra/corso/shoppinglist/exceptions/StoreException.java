package it.esedra.corso.shoppinglist.exceptions;

public class StoreException extends Exception {
	
		private static String msg = "[STORE EXCEPTION]";
		
		public StoreException() {
			super(msg);
		}
		public StoreException(String msg) {
			super(StoreException.msg + " " + msg);
		}
}
