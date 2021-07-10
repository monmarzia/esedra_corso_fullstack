package it.esedra.corso.mvc;

public class View {

	public String createHTML(String citta, Previsione previsione) {
		
		String temperatura;
	
		if(previsione.getTemperatura() == null) {
			temperatura = "non pervenuta";	
		} else {		
			temperatura = previsione.getTemperatura().toString();
		}
			

		String html = "<html><body><h1>Previsione a " + citta 
				+ " per domani</h1><p>Domani far&agrave; : " + previsione.getTempo()
				+ " e temperatura  "+ temperatura
				+ "<p></body></html>";
		
		return html;
	}
}
