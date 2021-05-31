package it.esedra.corso.lezioni;
public class SingletonTest {

  public static void main(String[] args) {

      // Singleton singleton = new Singleton(); NO costruttore privato
      Singleton singleton = Singleton.getInstance();
      System.out.println(singleton.getTest());

      Singleton singleton2 = Singleton.getInstance();
      System.out.println(singleton2.getTest());
  }


}
