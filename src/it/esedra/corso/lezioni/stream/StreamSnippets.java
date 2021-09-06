package it.esedra.corso.lezioni.stream;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamSnippets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OggettoModificabile o = new OggettoModificabile("Il nuovo Java");
		OggettoModificabile o2 = new OggettoModificabile("Il nuovo PHP");
		System.out.println(isTitolo(o, "Java"));
	//	o.setTitolo("SQL");
		System.out.println(isTitolo(o, "Java"));
//		o.setTitolo(null);
//		System.out.println(isTitolo(o, "Java"));
//		o = null;
		System.out.println(isTitolo(o, "Java"));
		Snippet s = new Snippet("Il nuovo SQL");
		System.out.println(isTitolo(s, "SQL"));
		
		Snippet a = new Snippet("Javascript la guida");

		
		Collection<SingleMethod> singleCollention = new HashSet<SingleMethod>();
		singleCollention.add(o);
		singleCollention.add(s);
		singleCollention.add(a);		
		printTitolo(singleCollention, "Java");
		
		//setTitolo(a, "Test"); //Immodificabile
		System.out.println("--------------");
		
		Collection<OggettoModificabile> modCollention = new HashSet<OggettoModificabile>();
		modCollention.add(o);
		modCollention.add(o2);		

		setTitolo(modCollention, "Test cambio titolo");

		printTitolo(modCollention);
		System.out.println("Titolo oggetto 1: " + o.getTitolo());
		
		Collection<SingleMethod> mutata = setTitoloImmutabile(singleCollention, "Java");
		printTitoloImmutabile(singleCollention);
		System.out.println("Mutata");
		printTitoloImmutabile(mutata);
		
		System.out.println("Titolo Snippet s: " + s.getTitolo());
	}

	public static boolean isTitolo(SingleMethod o, String value) {
		return Optional.ofNullable(o).map(SingleMethod::getTitolo).filter(t -> t.contains(value)).isPresent();
	}
	
	public static void printTitolo(Collection<SingleMethod> o, String value) {
		o.stream().filter(t -> t.getTitolo().contains(value)).forEach(os -> System.out.println(os.getTitolo()));
	}
	
	public static void printTitolo(Collection<OggettoModificabile> o) {
		o.stream().forEach(os -> System.out.println(os.getTitolo()));
	}
	
	public static void printTitoloImmutabile(Collection<SingleMethod> o) {
		o.stream().forEach(os -> System.out.println(os.getTitolo()));
	}
	
	public static Collection<OggettoModificabile> setTitolo(Collection<OggettoModificabile> oc, String value) {
		return oc.stream().map(s -> { s.setTitolo(value); return s; }).collect(Collectors.toList());
	}

	public static Collection<SingleMethod> setTitoloImmutabile(Collection<SingleMethod> oc, String value) {
		return oc.stream().map(s -> { return new Snippet(value); }).collect(Collectors.toList());
	}
	
}
