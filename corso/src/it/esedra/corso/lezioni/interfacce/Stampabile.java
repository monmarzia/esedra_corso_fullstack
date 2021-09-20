package it.esedra.corso.lezioni.interfacce;

public interface Stampabile {
  void stampa();

  static void coloriDisponibili(){
    System.out.println("Verde");
    System.out.println("Bianco e nero");
  }
}
