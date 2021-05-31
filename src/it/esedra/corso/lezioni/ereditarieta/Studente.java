package it.esedra.corso.lezioni.ereditarieta;

public class Studente extends Persona {

  private int matricola;

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
    super.setOccupazione("Studente");
    System.out.println("Occupazione: " + this.getOccupazione());
  }




}
