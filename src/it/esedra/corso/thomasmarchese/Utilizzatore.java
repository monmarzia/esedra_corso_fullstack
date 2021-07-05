package it.esedra.corso.thomasmarchese;

public class Utilizzatore {

	public static void main(String[] args) {

		Prova test = new Prova("thomas","marchese","1994","174",78); // sfrutta il costruttore classico , siamo tenuti ad utilizzare l'ordine della firma
		Prova test2 = new ProvaBuilder().setAltezza("185").setAnnoNascita("1993").setNome("boh").setPeso(88).setCognome("bianchi").build(); //è come usare un costruttore ma con i parametri in ordine che ci pare a noi
		System.out.println(test.getNome());
		System.out.println(test2.getNome());

	}

}
