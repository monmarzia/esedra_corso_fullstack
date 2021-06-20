public class TestLavoratore {
  public static void main(String[] args) {
    LavoratoreConStraordinari lav2 = new LavoratoreConStraordinari();
    lav2.setNome("Carlo");
    lav2.setStipendio(3000);
    lav2.setOre(24);
    lav2.stampaStipendio();
    Lavoratore lav4 = new Lavoratore();
    lav4.setNome("Matteo");
    lav4.setStipendio(2500);
    lav4.stampaStipendio();
    LavoratoreConStraordinari lav3 = new LavoratoreConStraordinari();
    lav3.setNome("Fabio");
    lav3.setStipendio(4000);
    lav3.setOre(14);
    lav3.stampaStipendio();
    Lavoratore lav = new Lavoratore();
    lav.setNome("Aldo");
    lav.setStipendio(2000);
    lav.stampaStipendio();
    Lavoratore[] lavoratori = {lav, lav2, lav3, lav4};
    //OrdinaLavoratori ord = new OrdinaLavoratori();
    //ord.ordinaLavoratori(lavoratori);
    OrdinaLavoratori.ordinaLavoratori(lavoratori);
  }
}
