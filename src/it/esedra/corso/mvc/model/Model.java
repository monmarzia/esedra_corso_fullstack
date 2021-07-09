package it.esedra.corso.mvc.model;

import it.esedra.corso.mvc.Previsione;
import it.esedra.corso.mvc.TempoMeteo;

public class Model {

	
	public static Previsione previsioni(String citta) {
		Previsione previsione = new Previsione();
		
		if (citta.equals("Firenze")) {
			previsione.setTempo(TempoMeteo.SOLE);
			previsione.setTemperatura(Float.valueOf("20.4"));
			return previsione;
		} else if (citta.equals("Prato")) {
			previsione.setTempo(TempoMeteo.SOLE);
			previsione.setTemperatura(Float.valueOf("32.1"));
			return previsione;
		} else if (citta.equals("Genova")) {
			previsione.setTempo(TempoMeteo.NEVE);
			previsione.setTemperatura(Float.valueOf("-1.4"));
			return previsione;
		} else {
			previsione.setTempo(TempoMeteo.NON_PERVENUTO);
			previsione.setTemperatura(null);
			return previsione;
		}

	}
}
