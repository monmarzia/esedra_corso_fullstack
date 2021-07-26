package it.esedra.corso.lezioni.esercizi;

import java.util.Scanner;
/**
 * Converte un input numerico in metri
 */
public class ConversionePolliciMetri {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in); //ottiene i data in input
    System.out.println("Inserisci valore in pollici:");
    double pollici = input.nextDouble();
    System.out.println("Il valore in metri è " + calcolaMetri(pollici));
  }
 /**
  * Converte i pollici in metri
  * @param double pollici
  */
 public static double calcolaMetri(double pollici) {
    return pollici*0.0254;
 }

}
