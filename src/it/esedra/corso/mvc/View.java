package it.esedra.corso.mvc;

public class View {

	public String createHTML(String citta, String previsione) {

		String html = "<html><body><h1>Previsione a " + citta + " per domani</h1><p>Domani farà : " + previsione
				+ "<p></body></html>";
		
		return html;
	}
}
