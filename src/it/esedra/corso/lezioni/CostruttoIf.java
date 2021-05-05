package it.esedra.corso.lezioni;


public class CostruttoIf  {

  public static void main(String[] args) {

    if (args.length == 0) {
      System.out.println("Non hai specificato nessun parametro");
      return;
    }
    if (args[0].equals("blu")) {
      System.out.println("blu è un colore");
      return;
    }
    if (args[0].equals("gatto")) {
      System.out.println("gatto è un animale");
      return;
    }
    System.out.println("Non conosco questa parola");
  }

}
