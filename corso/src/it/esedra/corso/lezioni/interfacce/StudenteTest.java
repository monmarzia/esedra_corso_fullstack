package it.esedra.corso.lezioni.interfacce;
import it.esedra.corso.lezioni.ereditarieta.Studente;

public class StudenteTest {

  public static void main (String[] args) {
    Studente studente1 = new Studente(1234);
    Stampabile.coloriDisponibili();
    studente1.stampa();
    studente1.setScheda(6, 7);
    studente1.stampaValutazione();
  }
}
