package it.esedra.corso.lezioni;


public class WrapperClasses {


  public static void main (String[] args) {

      double dub = 44.2;
      Double dubWrap = new Double(dub);

      String quarantaq = "41.2";
      dubWrap = Double.parseDouble(quarantaq);

      /* autoboxing e autounboxing */
      int number = 100;
      Integer intObj = number; //autoboxing

      number = 200; //non si riperquote su intObj
      intObj = 300; //questo non si riperquote su number

      int num = 100;
      Integer IObj = number;

      int num2 = IObj; //autounboxing


  }


}
