package it.esedra.corso.francescorossi;

public class App {
	private ListaSpesa[] lista;
	

	public App() {
		lista = new ListaSpesa[10];
	}
	public void aggiungiElemento(ListaSpesa listaElemento) {
		
		for(int i = 0; i < lista.length; i++) {
			if (lista[i] == null) {
				lista[i] = listaElemento;	
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

}
