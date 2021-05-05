package it.esedra.corso.lezioni;
import it.esedra.corso.esempioClassi.persone.Persona;

public class Operatori  {

  public static void main(String[] args) {

      int a = 1;
      int b = 1;
      int c = 2;
      System.out.println("a = b? " + (a == b));
      System.out.println("a = c? " + (a == c));
      System.out.println("a != b? " + (a != b));
      System.out.println("a > c? " + (a > c));
      System.out.println("a < c? " + (a < c));
      System.out.println("a >= b? " + (a >= b));
      System.out.println("a >= c? " + (a >= c));
      System.out.println("a <= c? " + (a <= c));

      boolean b1 = false;
      boolean b2 = b1 == (false);
      System.out.println("false == false " + b2);


      //provo con gli oggetti
      Persona persona1 = new Persona("Roberto", "Baldi", 1928);
      Persona persona2 = new Persona("Roberto", "Baldi", 1928);
      System.out.println(" persona1 == persona1 ? " + (persona1 == persona2));

      boolean x = !true;  //FONDAMENTALE
      System.out.println(" il valore di x è: " + x);

      boolean and1 = true & false;
      boolean and2 = true & true;
      System.out.println(" il valore di and1 è: " + and1);
      System.out.println(" il valore di and2 è: " + and2);


      boolean or1 = true | false;
      boolean or2 = false | false;
      System.out.println(" il valore di or1 è: " + or1);
      System.out.println(" il valore di or2 è: " + or2);

      boolean xor1 = true ^ false;
      boolean xor2 = true ^ true;
      System.out.println(" il valore di xor1 è: " + xor1);
      System.out.println(" il valore di xor2 è: " + xor2);

      //SHORT CIRCUIT
      boolean flag = ( ( a == 1) && (c/a > 1)  );//FONDAMENTALE
      System.out.println(" il valore di flag è: " + flag);

      boolean flag2 = ( ( a == 0) || (c/a > 2)  );//FONDAMENTALE
      System.out.println(" il valore di flag2 è: " + flag2);

  }
}
