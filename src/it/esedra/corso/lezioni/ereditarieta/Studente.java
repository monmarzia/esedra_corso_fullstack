package it.esedra.corso.lezioni.ereditarieta;

import it.esedra.corso.lezioni.interfacce.Stampabile;
import it.esedra.corso.lezioni.interfacce.Occupazione;
import it.esedra.corso.lezioni.ereditarieta.Valutazione;

public class Studente extends Persona implements Stampabile {

  private int matricola;
  private Valutazione scheda = new Valutazione();

  public Studente() {
    //this.nome = "Test"; NO nome è private
  }

  public Studente(int matricola) {
    super("Studente con matricola"); //SUPER
    this.matricola = matricola;
  }
  public void setMatricola(int matricola) {
    this.matricola = matricola;
  }

  public int getMatricola() {
    return this.matricola;
  }

  public void stampaAnagrafica() {
    super.stampaAnagrafica(); //SUPER
    System.out.println("Matricola: " + this.matricola);
  }

  public void stampaOccupazione() {
    super.setOccupazione(Occupazione.Studente);
    System.out.println("Occupazione: " + this.getOccupazione());
  }

  public void stampa() {
    super.setOccupazione(Occupazione.Studente);
    System.out.println("Nome: " + this.getNome());
    System.out.println("Occupazione: " + this.getOccupazione());
    System.out.println("Matricola: " + this.matricola);
  }

  public void setScheda(int votoMatematica, int votoItaliano) {
      this.scheda.setVotoMatematica(votoMatematica);
      this.scheda.setVotoItaliano(votoItaliano);
  }

  public void stampaValutazione() {
    System.out.println(this.getNome() + " ha ottenuto " + this.scheda.getVotoMatematica() + " in Matematica e " + this.scheda.getVotoItaliano() + " in Italiano");
  }

}
