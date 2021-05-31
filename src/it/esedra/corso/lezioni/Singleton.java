package it.esedra.corso.lezioni;

public class Singleton {

  private static Singleton instance;

  private String test;

  private Singleton() {
    test = "Ora corrente: " + System.currentTimeMillis();
  }

  public String getTest() {
    return test;
  }

  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }

}
