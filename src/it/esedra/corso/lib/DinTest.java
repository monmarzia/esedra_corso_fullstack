package it.esedra.corso.lib;

public class DinTest {
  public static void main(String[] args) {
    String[] input = {"uno", "due", "tre", "quattro", "cinque"};
    String[] inputCopy = {"uno", "due", "tre", "quattro", "cinque"};
    DinArray dinArray = new DinArray();
    String newString = "sei";
    String results;
    input = dinArray.add(input, newString);
    results = testAdd(input, inputCopy, newString);
    printTestResult(results, "public String[] add(String[] input, String newString)");
    String[] inputCopy2 = new String[0];
    input = dinArray.add(null, newString);
    results = testAdd(input, inputCopy2, newString);
    printTestResult(results, "public String[] add(String[] input, String newString)");
  }

  private static void printTestResult(String msg, String testName) {
    if(msg != null) {
      System.err.println(DinArray.class.getName() + " Test name: " + testName);
      System.err.println(msg);
    } else {
      System.out.println(DinArray.class.getName() + " Test name: " + testName);
      System.out.println("Test ok.");
    }
  }

  public static String testAdd(String[] input, String[] inputCopy, String newString) {
    int inputLength = inputCopy.length;

    if(input == null) {
      return "input è null";
    }
    if(input.length != (inputCopy.length + 1)) {
      return "input.length non è aggiornato: input.length = " + input.length + " , inputCopy.length = " + inputCopy.length;
    }
    for(int i = 0; i < input.length - 1; i++) {
      if(input[i] == null || !input[i].equals(inputCopy[i])){
        return "I valori non corrispondono ";
      }
    }
    if(!input[input.length-1].equals(newString)) {
      return "La stringa non corrisponde";
    }
    return null;
  }
}
