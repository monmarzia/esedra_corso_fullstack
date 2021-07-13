package it.esedra.corso.mvc;

import java.net.URI;
import java.net.URISyntaxException;

import it.esedra.corso.mvc.model.Model;

public class Controller {

	public static void main(String[] args) {

		// http://miosito.it/previsioni-tempo/Firenze
		URI[] uriarray = new URI[3];
		try {
			uriarray[0] = new URI("http://miosito.it/previsioni-tempo/Prato?param=6");
			uriarray[1] = new URI("http://miosito.it/previsioni-tempo/Siena?param=6");
			uriarray[2] = new URI("http://miosito.it/previsioni-tempo/Grosseto?param=6");

			for (URI variabiletemporanea : uriarray) {

				String[] segments = variabiletemporanea.getPath().split("/");
				String pagina = segments[1];
				String citta = segments[2];
				Controller controller = new Controller();
				if (pagina.equals("previsioni-tempo")) {
					controller.getPrevisioniTempo(citta);
				}
				
				System.out.println("test branch");
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Actrion previsione del tempo
	 * 
	 * @param citta
	 */
	public void getPrevisioniTempo(String citta) {

		Model model = new Model();
		Previsione previsioneDomani = model.previsioni(citta);

		View view = new View();
		String html = view.createHTML(citta, previsioneDomani);

		System.out.println(html);
	}

}
