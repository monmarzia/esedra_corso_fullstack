package it.esedra.corso.mvc;

public class Model {

	
	public static String previsioni(String citta) {
		
		if (citta.equals("Firenze")) {
			return "Sole";
		} else if (citta.equals("Prato")) {
			return "Piove";
		} else if (citta.equals("Genova")) {
			return "Neve";
		}
		return "Non pervenute";
	}
}
