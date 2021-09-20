package it.esedra.corso.lezioni.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StreamSnippets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OggettoModificabile o = new OggettoModificabile("Il nuovo Java");
		OggettoModificabile o2 = new OggettoModificabile("Il nuovo PHP");
		System.out.println(isTitolo(o, "Java"));
		// o.setTitolo("SQL");
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

		// setTitolo(a, "Test"); //Immodificabile
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

		Consumer<String> print = (stringa) -> System.out.println(stringa);

		print.accept("ciao");

		OptionalDouble opDouble = null;

//		Double uT = opDouble.orElse(0);
//		System.out.println("Value in OptionalDouble = "
//                + opDouble.orElse(0));
		
		
		StreamSnippets ssn = new StreamSnippets();
		Book ab = new Book();
		ab.setPrice(null);
		Book b = new Book();
		b.setPrice(10.0);
		List<Book> bookList = new ArrayList<Book>();
		bookList.add(ab);
		bookList.add(b);
		ssn.calculateAveragePriceSolution(bookList);
//		ssn.calculateAveragePriceSolutionB(bookList);
	}

	public Map<String, List<Book>> groupByTitle(List<Book> bookList) {
		Map<String, List<Book>> resultMap = new HashMap<>();
		for (int i = 0; i < bookList.size(); i++) {
			Book book = bookList.get(i);
			List<Book> bookSubList = resultMap.getOrDefault(book.getTitle(), new ArrayList<Book>());
			bookSubList.add(book);
			resultMap.put(book.getTitle(), bookSubList);
		}
		return resultMap;
	}

	public Map<String, List<Book>> groupByTitleSolution(List<Book> bookList) {
		return bookList.stream().collect(Collectors.groupingBy(Book::getTitle));
	}

	public Double calculateAveragePrice(List<Book> bookList) {
		Double sum = Double.valueOf(0);
		int count = 0;
		for (int i = 0; i < bookList.size(); i++) {
			Book book = bookList.get(i);
			sum += book.getPrice();
			count++;
		}
		return (Double) sum / count;
	}

	
	public Double calculateAveragePriceSolutionB(List<Book> bookList) {
		return bookList.stream().mapToDouble(Book::getPrice).average().getAsDouble();
	}
	
	public Double calculateAveragePriceSolution(List<Book> bookList) {
		return bookList.stream().mapToDouble(book -> book.getPrice() == null ? 0 : book.getPrice()).average().getAsDouble();
	}

	public Double calculateAverageStream(List<Book> bookList) {
		return bookList.stream().mapToDouble(Book::getPrice).average().orElse(0);
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
		return oc.stream().map(s -> {
			s.setTitolo(value);
			return s;
		}).collect(Collectors.toList());
	}

	public static Collection<SingleMethod> setTitoloImmutabile(Collection<SingleMethod> oc, String value) {
		return oc.stream().map(s -> {
			return new Snippet(value);
		}).collect(Collectors.toList());
	}

}
