package it.esedra.corso.lezioni;
import it.esedra.corso.esempioClassi.persone.Persona;

public class AncoraCicli  {


  public static void main(String[] args) {

    int day = 2;
    String dayString;

    // switch statement
    switch(day)
    {
       // case statements
       // values must be of same type of expression
       case 1 :
          dayString = "Monday";
          break; // break is optional

       case 2 :
          dayString = "Tuesday";
          break; // break is optional

       case 3 :
          dayString = "Wednesday";
          break; // break is optional
       case 5 :
       case 6 :
       default :
          dayString = "invalid day";
          break;
          // Statements

    }

    System.out.println(dayString);

    day = 3;
    // switch statement
    switch(day)
    {
       // case statements
       case 1 -> dayString = "Monday";
       case 2 -> dayString = "Tuesday";
       case 3 -> dayString = "Wednesday";

    }

    System.out.println(dayString);

    /** SWITCH COME ESPRESSIONE */
    day = 1;

    dayString = switch(day) { 
       // case statements
       case 1 -> "Monday";
       case 2 -> "Tuesday";
       case 3 -> "Wednesday";
       default -> "invalid day";
    };

    System.out.println(dayString);
    //Raggrupopo i case
    day = 5;
    dayString = switch(day) {
       // case statements
       case 1 -> "Monday";
       case 2 -> "Tuesday";
       case 3 -> "Wednesday";
       case 4,5,6 -> "Other days";
       default -> "invalid day";
    };

    System.out.println(dayString);

    //USO : YIELD
    day = 6;
    dayString = switch(day) {
       // case statements
       case 1 : yield "Monday";
       case 2 : yield "Tuesday";
       case 3 : yield "Wednesday";
       case 4,5,6 : yield "Other days";
       default : yield "invalid day";
    };

    System.out.println(dayString);

    day = 1;
    dayString = switch(day) {
       // case statements
       case 1 -> {
         String c = "Lunedì";
         yield c;
       }
       case 2 -> "Tuesday";
       case 3 -> "Wednesday";
       case 4,5,6 -> "Other days";
       default -> "invalid day";
    };

    System.out.println(dayString);

    var dayVar = switch(day) {
       // case statements
       case 1 -> {
         String c = "Lunedì con var";
         yield c;
       }
       case 2 -> "Tuesday";
       case 3 -> "Wednesday";
       case 4,5,6 -> "Other days";
       default -> "invalid day";
    };

    System.out.println(dayVar);

    /** FOR MIGLIORATO */
    int[] arr = {1, 2, 3, 4, 5};
    for (int tmp : arr) {
      System.out.println(tmp);
    }
    
  }




}
