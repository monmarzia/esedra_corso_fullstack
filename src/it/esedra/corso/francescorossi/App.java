package it.esedra.corso.francescorossi;

import java.io.File;
import java.io.PrintWriter;

public class App {
	private ListaSpesa[] lista;

	public App() {
		lista = new ListaSpesa[10];
	}

	public void aggiungiElemento(ListaSpesa listaElemento) {

		for (int i = 0; i < lista.length; i++) {
			if (lista[i] == null) {
				lista[i] = listaElemento;
				break;
			}
		}
	}

	public static void main(String[] args) {
		
		
		App app = new App();
		
		

		ListaSpesa listaA = new ListaSpesaBuilder().setProdotto("uova").setQuantita(2).setUnitaMisura("Kg")
				.setNomeLista("Marco").build();
		
		ListaSpesa listaB = new ListaSpesaBuilder().setProdotto("Pane").setQuantita(1).setUnitaMisura("Kg")
				.setNomeLista("Paolo").build();

		app.aggiungiElemento(listaA);		
		app.aggiungiElemento(listaB);
		app.store();
	}

	
	public void store() {
		
		try {
			
			
			String file = getClass().getProtectionDomain().getCodeSource().getLocation().getPath()+System.getProperty("path.separator")+"lista.csv";
			PrintWriter writer = new PrintWriter(new File("lista.csv"));
			StringBuilder builder = new StringBuilder();
			for(ListaSpesa listaTemp : lista) {
				if(listaTemp == null)
					continue;
				builder.append(listaTemp.getProdotto());
				builder.append(",");
				builder.append(listaTemp.getQuantita());
				builder.append(",");
				builder.append(listaTemp.getUnitaMisura());
				builder.append(",");
				builder.append(listaTemp.getNomeLista());
				builder.append(System.getProperty("line.separator"));
				
			}
			
			writer.write(builder.toString());
			writer.flush();
			writer.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
}
