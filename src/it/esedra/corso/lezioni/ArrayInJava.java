package it.esedra.corso.lezioni;
import it.esedra.corso.test.persone.Persona;

public class ArrayInJava  {

  public static void main(String[] args) {
      char alfabeto[];

      String[] alfabetoMorse; //dichiarazione
      alfabetoMorse = new String[3]; //creazione

      alfabetoMorse[0] = ".-"; //inizializzazione
      alfabetoMorse[1] = "-...";
      alfabetoMorse[2] = "-.-.";

      //Sintassi alternativa
      String[] tipiDiPizza = {
        "Bianca",
        "Margherita",
        "Marinara",
        "Diavola",
        "Boscaiola"
      };

      System.out.println("Conosco " + tipiDiPizza.length + " tipi di pizza");

      String[][] arrayDiArray = { //sitassi compatta
        {"Roberto", "Baldi"},
        {"Mario", "Rossi", "Prato"},
        {"Giuseppe", "Verdi"}
      };

      System.out.println("Il cognome della seconda persona è : " + arrayDiArray[1][1]);
      System.out.println("Il nome della terza persona è : " + arrayDiArray[2][0]);


      String[][] arrayDiArray2 = new String[2][]; //dichiaro e creo array multidimensionale

      String[] nomeCompleto = new String[2];
      nomeCompleto[0] = "Marco"; //inizializzo
      nomeCompleto[1] = "Bianchi";

      String[] nomeCompleto2 = new String[2];
      nomeCompleto2[0] = "Giovanni";
      nomeCompleto2[1] = "Rossi";

      arrayDiArray2[0] = nomeCompleto;
      arrayDiArray2[1] = nomeCompleto2;

      Persona persona1 = new Persona("Roberto", "Baldi", 1928);
      Persona persona2 = new Persona("Marco", "Rossi", 1955);

      persona1.nome = "Ugo";
      Persona[] persone = new Persona[2];
      persone[0] = persona1;
      persone[1] = persona2;

      stampaAnagrafiche(persone); //passo il mio vettore a personeSalutano
  }

  public static void stampaAnagrafiche(Persona[] persone) {
      persone[0].stampaAnagrafica();
      persone[1].stampaAnagrafica();
  }

}
