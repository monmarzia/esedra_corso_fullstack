package it.esedra.corso.lezioni.esercizi;
import java.util.*;

public class OrderedOld  {


  public static void main(String[] args) {

	      /* creo una mia array di stringhe da ordinare */
	      String[] strs = new String[5];
    	  /* creo una mia array di numeri da ordinare */
    	  double[] numrs = new double[5];

        /* creo una mia array di FUTURI double da ordinare */
        String[] furureNumrs = new String[5];

     	  /* Controllo che args sia di 5 */
    	  int argsLenght = args.length;
    	  /* Se args è 0 oppure < 5 allora chiamo getUserInput() */
    	  String[] userInput = new String[0];


    	  if (argsLenght < 5) {
          System.out.println("Devo avere almeno 5 parametri da processare. Inserisci ora " + (5 - argsLenght) + " paramentri");
  		    userInput = getUserInput();
    	  }
        if ((userInput.length + argsLenght) < 5 ) {
          System.out.println("Devo avere almeno 5 parametri da processare. Ripeti l'input inserendo " + (5 - argsLenght) + " paramentri");
        }
        //controllo ancora una volta se è sbagliato esco
        if ((userInput.length + argsLenght) < 5 ) {
          System.err.println("Numero di paramentri errato, esco.");
        }
    	  if (argsLenght > 0 && argsLenght == 5) {
            /* indice 0 */
            int i = 0;
            String[] cell = analyzeCell(args[i]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
            /* indice 1 */
            i++;
            cell = analyzeCell(args[i]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
            /* indice 2 */
            i++;
            cell = analyzeCell(args[i]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
            /* indice 3 */
            i++;
            cell = analyzeCell(args[i]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
            /* indice 4 */
            i++;
            cell = analyzeCell(args[i]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
    	  }
        if (argsLenght > 0 && argsLenght == 4) {
            /* indice 0 */
            int i = 0;
            String[] cell = analyzeCell(args[i]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
            /* indice 1 */
            i++;
            cell = analyzeCell(args[i]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
            /* indice 2 */
            i++;
            cell = analyzeCell(args[i]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
            /* indice 3 */
            i++;
            cell = analyzeCell(args[i]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
            /* indice 4 */
            cell = analyzeCell(userInput[0]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
        }
        if (argsLenght > 0 && argsLenght == 3) {
            /* indice 0 */
            int i = 0;
            String[] cell = analyzeCell(args[i]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
            /* indice 1 */
            i++;
            cell = analyzeCell(args[i]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
            /* indice 2 */
            i++;
            cell = analyzeCell(args[i]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
            /* indice 3 */
            int ui = 0;
            i++;
            cell = analyzeCell(userInput[ui]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
            /* indice 4 */
            ui++;
            i++;
            cell = analyzeCell(userInput[ui]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
        }
        if (argsLenght > 0 && argsLenght == 2) {
            /* indice 0 */
            int i = 0;
            String[] cell = analyzeCell(args[i]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
            /* indice 1 */
            i++;
            cell = analyzeCell(args[i]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
            /* indice 2 */
            int ui = 0;
            i++;
            cell = analyzeCell(userInput[ui]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
            /* indice 3 */
            ui++;
            i++;
            cell = analyzeCell(userInput[ui]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
            /* indice 4 */
            ui++;
            i++;
            cell = analyzeCell(userInput[ui]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
        }
        if (argsLenght > 0 && argsLenght == 1) {
            /* indice 0 */
            int i = 0;
            String[] cell = analyzeCell(args[i]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
            /* indice 1 */
            i++;
            int ui = 0;
            cell = analyzeCell(userInput[ui]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
            /* indice 2 */
            i++;
            ui++;
            cell = analyzeCell(userInput[ui]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
            /* indice 3 */
            i++;
            ui++;
            cell = analyzeCell(userInput[ui]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
            /* indice 4 */
            i++;
            ui++;
            cell = analyzeCell(userInput[ui]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
        }
        if (argsLenght == 0) {
            /* indice 0 */
            int ui = 0;
            int i = 0;
            String[] cell = analyzeCell(userInput[ui]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
            /* indice 1 */
            i++;
            ui++;
            cell = analyzeCell(userInput[ui]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
            /* indice 2 */
            i++;
            ui++;
            cell = analyzeCell(userInput[ui]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
            /* indice 3 */
            i++;
            ui++;
            cell = analyzeCell(userInput[ui]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
            /* indice 4 */
            i++;
            ui++;
            cell = analyzeCell(userInput[ui]);
            strs[i] = cell[0];
            furureNumrs[i] = cell[1];
        }


        System.out.print(Arrays.toString(strs));
        System.out.print(Arrays.toString(furureNumrs));
  }

  public static String[] analyzeCell(String arg) {
      String[] retData = new String[2];
      if (!isNumeric(arg)) {
         retData[0] = arg;
      }
      if (isNumeric(arg)) {
         retData[1] = arg;
      }
      return retData;

  }


  public static boolean isNumeric(String str) {
    try {
      Double.parseDouble(str);
      return true;
    } catch(NumberFormatException e){
      return false;
    }
	}


  private static String[] getUserInput() {
  			Scanner n = new Scanner(System.in);
        System.out.println("Inserisci stringhe e numeri da ordinare: ");
        String b = n.nextLine();
        return b.split(" ");
  }
}
