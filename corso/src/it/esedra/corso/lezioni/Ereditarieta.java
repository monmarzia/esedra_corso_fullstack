package it.esedra.corso.lezioni;
import it.esedra.corso.lezioni.ereditarieta.Studente;
import it.esedra.corso.lezioni.ereditarieta.Persona;
public class Ereditarieta {


  public static void main(String[] args) {
      Studente studente = new Studente(123);
      System.out.println(studente.getNome());
      System.out.println(studente.getMatricola());
      studente.stampaAnagrafica();
      studente.stampaOccupazione();
  }

}
