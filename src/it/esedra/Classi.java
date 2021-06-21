package it.esedra;

import it.esedra.corso.lezioni.ereditarieta.Persona;

public class Classi {

	// final trasforma la variabile inuna costante immodificabile
	public final int ANNO_CORRENTE = 2021;

	/**
	 * Uso questo metodo per inizializzare la mia applicazione
	 */
	public static void main(String[] args) {
		Classi classi = new Classi();
		classi.esegui();
	}

	/**
	 * Uso questo metodo per eseguira la mia applicazione
	 */
	public void esegui() {

		// creo una istanza di persona
//      Persona persona = new Persona(); //variabile locale

		// SINTASSI
		// Nomeoggetto.nomevariabile;
		// il "." è sinonimo di APPARTIENE
//      persona.cognome = "Baldi"; //varibili di istanza
//      persona.setNome("Marco");
//      persona.annoDiNascita = 1974;

		// SINTASSI
		// Nomeoggetto.nomemetodo();
//      persona.saluta(); //metodi di instanza

//      persona.setNome("Roberto");

//      System.out.println(persona.getNomeCompleto());

//      int eta = persona.calcolaEta(ANNO_CORRENTE);
//      System.out.println(eta);
//
//      presentaPersona(persona, ANNO_CORRENTE);

		// creo una istanza di persona

//      Persona persona1 = new Persona();

//      persona1.cognome = "Rossi"; //varibili di istanza
//      persona1.setNome("Mario");
//      persona1.annoDiNascita = 1990;

//      Persona persona2 = new Persona();

//      persona2.cognome = "Bianchi"; //varibili di istanza
//      persona2.setNome("Giuseppe");
//      persona2.annoDiNascita = 1962;

//      Persona persona3 = new Persona();

//      persona3.cognome = "Verdi"; //varibili di istanza
//      persona3.setNome("Franco");
//      persona3.annoDiNascita = 1955;

		System.out.println("----");
		Persona[] persone = new Persona[4];
//      persone[0] = persona;
//      persone[1] = persona1;
//      persone[2] = persona2;
//      persone[3] = persona3;

		for (int i = 0; i < persone.length; i++) {
			presentaPersona(persone[i], ANNO_CORRENTE);
		}

		System.out.print("----");
		System.out.print("\n");
		// System.lineSeparator();
		System.out.print("----");
		System.out.print("\n");

	}

	public void presentaPersona(Persona persona, int annoAttuale) {
		// System.out.println(persona1);
//    System.out.println("La persona si chiama: " + persona.getNome() + " " + persona.cognome );

//    System.out.println("Di anni: " + persona.calcolaEta(annoAttuale));

	}

}

public class Lavoratore {
	private String nome;
	private Integer livello;
	private Integer stipendiomensile;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public int getLivello() {
		return livello;
	}

	public int getStipendiomensile() {
		return stipendiomensile;
	}

	public void setLivello(int livello) {
		this.livello = livello;
	}

	public void setStipendiomensile(int stipendiomensile) {
		this.stipendiomensile = stipendiomensile;
	}

	public void stampaStipendio() {
		System.out.println("Lo stipendio mensile di + " + this.nome + " è di " + this.stipendiomensile);
	}

}

public class LavoratoriConStraordinari extends Lavoratore {

	private Integer oreStraordinario;

	public static final double retribuzioneOraria = 10.0;

	public void stampaStraordinari() {
		System.out.println("Le ore di straordinario sono: " + this.oreStraordinario);
	}

	@Override
	public void stampaStipendio() {
		double retribuzioneTotale = (getStipendiomensile() + (this.oreStraordinario + LavoratoriConStraordinari.retribuzioneOraria));	
		System.out.println("La retribuzione mensile (compresi gli straordinari) è : " +  retribuzioneTotale);
		
	}
}
