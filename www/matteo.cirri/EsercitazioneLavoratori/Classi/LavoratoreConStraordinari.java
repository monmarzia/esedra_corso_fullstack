import java.lang.*;

public class LavoratoreConStraordinari extends Lavoratore {
  private int oreStraordinario;
  private static int retribuzioneOraria = 10;

  public int compareTo(Object o) {
    Lavoratore lav = (Lavoratore) o;
    int stipendioLav = lav.getStipendio() + oreStraordinario * retribuzioneOraria;
    int stipendioThis = this.getStipendio() + oreStraordinario * retribuzioneOraria;
    if (stipendioThis >= stipendioLav)
      return 1;
    else
      return -1;
  }

  public void setOre(int oreStraordinario) {
    this.oreStraordinario = oreStraordinario;
  }

  public int getOre() {
    return this.oreStraordinario;
  }

  public int getRetribuzione() {
    return this.retribuzioneOraria;
  }

  public void stampaStraordinari() {
    System.out.println("Le ore di straordinario sono: " + oreStraordinario);
  }

  @Override
  public void stampaStipendio() {
    System.out.println(getNome() + " guadagna " + (getStipendio() + retribuzioneOraria * oreStraordinario));
  }

}
