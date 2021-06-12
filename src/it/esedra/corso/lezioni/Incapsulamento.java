package it.esedra.corso.lezioni;

import it.esedra.corso.lezioni.oop.Data;
import it.esedra.corso.lezioni.oop.PuntoFisso;

//import it.esedra.corso.lezioni.oop.Data;
//import it.esedra.corso.lezioni.oop.PuntoFisso;
//import it.esedra.corso.lezioni.oop.Punto;
//import it.esedra.corso.lezioni.Singleton;
//import static java.lang.Math.*;



public class Incapsulamento  {

  private static int a = 0;

  public static void main(String[] args) {

    double d = Math.sqrt(3);
    int mese = 5;
    int anno = 2020;
    int giorno = 30;


    Data data  = new Data();

//    Data data = new Data();


//    data.setMese(mese);
//    data.setGiorno(giorno);
//    data.setAnno(anno);
//
//    String returnedData = data.getDataCompleta();
    String compareData = Integer.toString(giorno) +
      '/' + Integer.toString(mese) +
      '/' + Integer.toString(anno);
//    if (returnedData.equals(compareData)) {
      System.out.println("OK passed");
//    } else {
      System.out.println("FAIL error");
//    }



    PuntoFisso pu = new PuntoFisso(3, 5);
    System.out.println(pu.getX());


//    Punto punto = new Punto(7, 8);
//    System.out.println(punto.x());

    //creo una istanza di Incapsulamento e viene eseguito
    //l'Inizializzatore di istanza
    new Incapsulamento();
  }

  static {
    System.out.println(a);
  }

  {
    System.out.println("Inizializzatore di istanza");
  }

}
