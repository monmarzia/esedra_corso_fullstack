package it.esedra.corso.lezioni.polimorfismo;

public class Viaggiatore {


  public void viaggia(Automobile a) {
    a.accelera();
  }

  public void viaggia(Aereo a) {
    a.accelera();
  }

  public void viaggia(Nave n) {
    n.accelera();
  }

  public void viaggia(Veicolo v) {
    v.accelera(); //invoca il metodo virtuale
  }

}
