package it.esedra.corso.lezioni.thread;
public class IdealEconomy {
  public static void main(String args[]) {
    WareHouse wareHouse = new WareHouse();
    new Producer(wareHouse);
    new Consumer(wareHouse);
  }
}