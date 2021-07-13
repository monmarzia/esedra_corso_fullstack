package it.esedra.corso.esempioClassi.persone;

public class Persona {
    private  String nome;
    private String cognome;
    private int annoDiNascita;

    public static final int NUMERO_GAMBE = 2;  //variabile di classe

    /*
     Commento su + righe
    */
    public Persona() {
    }

    //firma o signature del metodo sono l'indentificatore e i suoi parametri
    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public Persona(String nome, String cognome, int annoDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.annoDiNascita = annoDiNascita;
    }

    public void cammina() {
      int lunghezzaPasso = 1;
      System.out.println("Ciao, il mio nome è " + nome + " " + cognome);
    }

    public void saluta() {
      int tonoVoce = 3;
      System.out.println("Ciao, il mio nome è " + nome + " " + cognome);
    }

    public void stampaAnagrafica() {
      System.out.println("----Anagrafica-----");
      System.out.println("Nome completo: " + nome + " " + cognome);
      System.out.println("Anno di nascita: " + annoDiNascita + "Ciao");
    }


    public String getNome() {
      return nome;
    }

   public String getNomeCompleto() {
      return nome + " " + cognome;
    }

    public int calcolaEta(int annoAttuale) {
        return annoAttuale - annoDiNascita;
    }

}
