import java.lang.Comparable;

public class Lavoratore implements Comparable{
  private String nome;
  private int livello;
  private int stipendio;

  public int compareTo(Object o) {
    Lavoratore lav = (Lavoratore) o;
    if (this.getStipendio() > lav.getStipendio())
      return 1;
    else if (this.getStipendio() < lav.getStipendio())
      return -1;
    else
      return 0;
  }

  public String getNome() {
    return this.nome;
  }

  public int getLivello() {
    return this.livello;
  }

  public int getStipendio() {
    return this.stipendio;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setLivello(int livello) {
    this.livello = livello;
  }

  public void setStipendio(int stipendio) {
    this.stipendio = stipendio;
  }

  public void stampaStipendio() {
    System.out.println(this.getNome() + " guadagna " + this.getStipendio());
  }
}
