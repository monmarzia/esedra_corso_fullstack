package it.esedra.corso.lezioni.oop;

public class Data  {

  private int giorno;
  private int mese = 0;
  private int anno;

  /** creo un metodo SETTER */
  public void setGiorno(int giorno) {
    if (mese == 0) {
      System.out.println("Inserire il mese prima");
      return;
    }
    if (giorno > 0 && giorno <= 31 && mese != 4) {
      this.giorno = giorno;
    } else if (giorno > 0 && giorno <= 30 && mese == 4) {
      this.giorno = giorno;
    } else {
      System.out.println("Giorno non valido");
    }
  }

  public void setMese(int m) {
    if (m > 0 && m <= 12) {
      mese = m;
    } else {
      System.out.println("Mese non valido");
    }
  }

  public void setAnno(int a) {
    anno = a;
  }

  public String getDataCompleta() {
    return Integer.toString(giorno) +
      '/' + Integer.toString(mese) +
      '/' + Integer.toString(anno);
  }
}
