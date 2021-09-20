package it.esedra.corso.lezioni;
import java.util.Date;
import it.esedra.corso.lezioni.polimorfismo.Viaggiatore;
import it.esedra.corso.lezioni.polimorfismo.Automobile;
import it.esedra.corso.lezioni.polimorfismo.Aereo;
import it.esedra.corso.lezioni.polimorfismo.TorreDiControllo;
import it.esedra.corso.lezioni.polimorfismo.Veicolo;

public class Polimorfismo {

  public static void main(String[] args) {

    Object obj = new Date();
    String descrizione = obj.toString();

    System.out.println(descrizione);


    Viaggiatore claudio = new Viaggiatore();

    Automobile fiat500 = new Automobile();
    claudio.viaggia(fiat500);


    TorreDiControllo tdc = new TorreDiControllo();
    Aereo boing737 = new Aereo();
    tdc.autorizzaAtterraggio(boing737);

    Object arr[] = { new TorreDiControllo(), "Hello!", new Date()};

    Veicolo boing747  = new Aereo();
    Veicolo fiat600  = new Automobile();

    if (boing747 instanceof Aereo) {
      Aereo areoBoing747 = (Aereo) boing747; //CAST
      System.out.println("boing747 è un Aereo");
    }

    if (fiat600 instanceof Aereo) {
      System.out.println("fiat600 è un Aereo");
    } else {
      System.out.println("fiat600 non è un Aereo");
    }

  }


}
