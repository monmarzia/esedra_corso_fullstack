package it.esedra.corso.lezioni.ereditarieta;
import it.esedra.corso.lezioni.interfacce.Occupazione;

public abstract class Persona  {

  private String nome;
  private Occupazione occupazione;

  public Persona() {
    nome = "Nessun nome";
  }

  public Persona(String nome) {
    this.nome = nome;
  }

  public void setOccupazione(Occupazione occupazione) {
    this.occupazione = occupazione;
  }
  public Occupazione getOccupazione() {
    return this.occupazione;
  }

  public void setNome(String nomeNuovo) {
    this.nome = nomeNuovo;
  }

  public String getNome() {
    return this.nome;
  }

  public void stampaAnagrafica() {
    System.out.println("Nome: " + this.nome);
  }

  public abstract void stampaOccupazione();

}
