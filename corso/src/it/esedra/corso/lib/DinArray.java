package it.esedra.corso.lib;

public class DinArray {
  public String[] add(String[] input, String newString) {
    // Verifica se input è null e nel caso inizializza a dimensione 1
    input = (input == null)? new String[1] : input;
    // Verificare se l'array ha una cella disponibile e
    for(int i = 0; i < input.length; i++) {
      // aggiungere il valore alla prima cella null
      if(input[i] == null) {
        input[i] = newString;
        return input;
      }
    }
    // Se non ha una cella disponibile crea una nuova array di
    // dimensione +1, aggiunge il nuovo valore e restituisco la nuova array
    String[] newArray = new String[input.length + 1];
    newArray[input.length] = newString;

    for(int i = 0; i < input.length; i++) {
      newArray[i] = input[i];
    }
    return newArray;
  }
}
