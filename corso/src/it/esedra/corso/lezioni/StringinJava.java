package it.esedra.corso.lezioni;


public class StringinJava {


  public static void main (String[] args) {

      System.out.println('c' + 'i' + 'a' + 'o');

      String c = new String("ciao");

      String a = "ciao";

      System.out.println(c.charAt(3));
      System.out.println(c.indexOf("i"));
      System.out.println(c.length());

      System.out.println("-------");
      System.out.println(c.toUpperCase());
      c = c.toUpperCase();
      System.out.println(c);

      /*
       * differenza tra immutabilità e costanti
       */
      final String d = new String("'bau'");
      // d = d.toUpperCase();
      System.out.println(d);

      final String f = new String("\"bau\"");
      System.out.println(f);

      String g = null;
      System.out.println(g);

  }

}
