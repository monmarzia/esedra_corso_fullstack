package it.esedra.corso.mvc;

public class Model {

	
	public static Previsione previsioni(String citta) {
		Previsione previsione = new Previsione();
		
		if (citta.equals("Firenze")) {
			previsione.setTempo("piove");
			previsione.setTemperatura(Float.valueOf("20.4"));
			return previsione;
		} else if (citta.equals("Prato")) {
			previsione.setTempo("sole");
			previsione.setTemperatura(Float.valueOf("32.1"));
			return previsione;
		} else if (citta.equals("Genova")) {
			previsione.setTempo("neve");
			previsione.setTemperatura(Float.valueOf("-1.4"));
			return previsione;
		} else {
			previsione.setTempo("non pervenuto");
			previsione.setTemperatura(null);
			return previsione;
		}

	}
}
