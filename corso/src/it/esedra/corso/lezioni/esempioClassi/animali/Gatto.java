package it.esedra.corso.lezioni.esempioClassi.animali;

public class Gatto {
      private String nome;

      public Gatto(String nome) {
        this.nome = nome;
        saluta();
      }
      public void saluta() {
        System.out.println("Miao, il mio nome è " + nome);
      }

      public void setNome(String nomeInput) {
        nome = nomeInput;
      }
}
