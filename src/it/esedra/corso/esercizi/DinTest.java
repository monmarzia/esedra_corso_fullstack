public class DinTest {
  public static void main(String[] args) {
    DinArray dinArray = new DinArray();
    String[] input = {"uno", "due", "tre", "quattro", "cinque"};
    String[] inputCopy = {};
    String nuovoElem = "sei";
    input = dinArray.add(null, nuovoElem);
    testAdd(input, inputCopy, nuovoElem);
    String[] inputCopy2 = {"uno", "due", "tre", "quattro", "cinque"};
    input = dinArray.add(input, nuovoElem);
    testAdd(input, inputCopy2, nuovoElem);
  }



  public static void testAdd(String[] input, String[] inputCopy, String nuovoElem) {
    int inputLength = input.length;
    if(input == null) {
      System.out.println("Errore: array null");
      return;
    }
    if(inputLength + 1 != inputCopy.length) {
      System.out.println("Errore: dimensione errata");
      return;
    }
    for(int i = 0; i < input.length - 1; i++) {
      if(input[i] == null || !input[i].equals(inputCopy[i])) {
        System.out.println("Errore: il valore non corrisponde");
        return;
      }
    }
    if(input[input.length -1] != nuovoElem) {
      System.out.println("Errore: nuovo elemento errato");
      return;
    }
  }
