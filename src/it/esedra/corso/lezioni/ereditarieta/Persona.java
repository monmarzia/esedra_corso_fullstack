package it.esedra.corso.lezioni.ereditarieta;

public abstract class Persona  {

  private String nome;
  private String occupazione;

  public Persona() {
    nome = "Nessun nome";
  }

  public Persona(String nome) {
    this.nome = nome;
  }

  public void setOccupazione(String occupazione) {
    this.occupazione = occupazione;
  }
  public String getOccupazione() {
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
