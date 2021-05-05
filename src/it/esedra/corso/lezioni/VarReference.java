package it.esedra.corso.lezioni;


public class VarReference {


  public static void main (String[] args) {

    double unNumero = 5.0;
    //assegnazine per valore
    double unAltroNumero = unNumero; //assegno il valore di unNumero;

    System.out.println("unNumero: " + unNumero);
    System.out.println("unAltroNumero: " + unAltroNumero);

    unAltroNumero = 6.1;
    System.out.println("Assegno a unAltroNumero il valore 6.1");
    System.out.println("unNumero: " + unNumero);
    System.out.println("unAltroNumero: " + unAltroNumero);

    System.out.println("----------------");

    String[] unaString = new String[1];
    unaString[0] = "test";
    String[] unAltraString = unaString; //passo il valore

    System.out.println("unaString: " + unaString[0]);
    System.out.println("unAltraString: " + unAltraString[0]);


    System.out.println("Assegno a unAltraString il valore buonasera");
    unAltraString[0] = "buonasera";

    System.out.println("unaString: " + unaString[0]);
    System.out.println("unAltraString: " + unAltraString[0]);

    System.out.println("----------------");
    System.out.println("Cosa succede se creo un nuovo riferimento x unAltraString?");


    unAltraString = new String[1];
    unAltraString[0] = "Java";

    System.out.println("unaString: " + unaString[0]);
    System.out.println("unAltraString: " + unAltraString[0]);


  }


}
