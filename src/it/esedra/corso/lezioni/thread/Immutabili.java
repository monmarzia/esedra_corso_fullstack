package it.esedra.corso.lezioni.thread;

public class Immutabili {

	private String test = new String("test");
	public static void main(String[] args) {
		
		String nome = "Roberto";
		String nomeMaiuscolo = nome.toUpperCase();
		System.out.println(nome);
		System.out.println(nomeMaiuscolo);
		

	}
	
	public String getTest() {
		return String.valueOf(test);
	}
}
