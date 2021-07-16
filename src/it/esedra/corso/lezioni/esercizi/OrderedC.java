package it.esedra.corso.lezioni.esercizi;

import java.util.Scanner;

public class OrderedC {
  public final static int MAX_PARAMS = 1;
  public static String[] strs = new String[MAX_PARAMS];
  public static String[] numrs = new String[MAX_PARAMS];
  public static String[] inputS = new String[MAX_PARAMS];
  public static int elem = 0;

  public static void main(String[] args) {
    String userInput[] = new String[0];
    if (args.length <= MAX_PARAMS - 1) {
      while ((MAX_PARAMS - args.length - elem) > 0) {
        System.out.println("Insteserire ancora " + (MAX_PARAMS - args.length - elem) + " elementi");
        userInput = getUserInput();
        store(userInput);
      }
    }
    dividi(args, inputS);
    ordinaNumeri();
    ordinaStringhe();
    System.out.print("Lista di numeri: ");
    for (int i = 0; i < MAX_PARAMS; i++) {
      if (numrs[i] != null){
        System.out.print(numrs[i] + " ");
      }
    }
    System.out.println(" ");
    System.out.println("Lista di stringhe:");
    for (int i = 0; i < MAX_PARAMS; i++) {
      if (strs[i] != null ) {
        System.out.println(strs[i]);
      }
    }
  }

  public static void store(String vett[]) {
    for (int i = 0; i < vett.length; i++)  {
      if (elem == MAX_PARAMS)
        break;
      if (vett[i] != null) {
        inputS[elem++] = vett[i];
      }
    }
  }

  public static void dividi(String vettore[], String input[]) {
    int conta = 0;
    for (int i = 0; i < vettore.length; i++){
      if (conta == MAX_PARAMS)
        break;
      if (isNumeric(vettore[i])){
        numrs[conta++] = vettore[i];
      }
      else {
        strs[conta++] = vettore[i];
      }
    }
    for (int i = 0; i < input.length; i++) {
      if (conta == MAX_PARAMS)
        break;
      if (input[i] == null)
        continue;
      if (isNumeric(input[i])) {
        numrs[conta++] = input[i];
      }
      else {
        strs[conta++] = input[i];
      }
    }
  }

  public static void ordinaNumeri() {
    String temp;
  	for (int i = 0; i < MAX_PARAMS - 1; i++){
      if (numrs[i] == null)
        continue;
      for (int j = i + 1; j < MAX_PARAMS; j++) {
        if (numrs[j] == null)
          continue;
      	if (numrs[i].compareTo(numrs[j]) > 0) {
          temp = numrs[j];
          numrs[j] = numrs[i];
          numrs[i] = temp;
       }
      }
    }
  }

  public static void ordinaStringhe() {
    String temp;
  	for (int i = 0; i < MAX_PARAMS - 1; i++){
      if (strs[i] == null)
        continue;
      for (int j = i + 1; j < MAX_PARAMS; j++){
        if (strs[j] == null)
          continue;
      	if (strs[i].compareTo( strs[j]) > 0) {
          temp = strs[j];
          strs[j] = strs[i];
          strs[i] = temp;
       }
      }
    }
  }

   public static String[] getUserInput() {
   	Scanner n = new Scanner(System.in);
    System.out.println("Inserisci stringhe e numeri da ordinare: ");
    String b = n.nextLine();
    return b.split(" ");
   }

  public static boolean isNumeric(String str) {
    try {
      Double.parseDouble(str);
      return true;
    } catch(NumberFormatException e){
      return false;
      }
	}
}
