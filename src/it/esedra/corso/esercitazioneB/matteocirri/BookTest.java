package it.esedra.corso.esercitazioneB.matteocirri;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookTest {

	public static void main(String[] args) {

		BookTest bookTest = new BookTest();

		List<Book> listaBook = new ArrayList<>();

		Book libro1 = new Book("Titolo1", null);
		Book libro2 = new Book(null, (double) 30);
		Book libro3 = null;
		Book libro4 = new Book("Titolo1", (double) 40);
		Book libro5 = new Book("Titolo2", (double) 50);
		Book libro6 = new Book("Titolo2", (double) 60);

		listaBook.add(libro1);
		listaBook.add(libro2);
		listaBook.add(libro3);
		listaBook.add(libro4);
		listaBook.add(libro5);
		listaBook.add(libro6);

		Map<String, List<Book>> mapBook = bookTest.groupByTitle(listaBook);
		System.out.println(mapBook);

		Double averagePrice = bookTest.calculateAveragePrice(listaBook);
		System.out.println(averagePrice);

	}

	public Map<String, List<Book>> groupByTitle(List<Book> bookList) {
		return bookList.stream().flatMap(s -> Stream.ofNullable(s)).filter(b -> !(b.getTitle() == null))
				.collect(Collectors.groupingBy(Book::getTitle));
	}

	public Double calculateAveragePrice(List<Book> bookList) {
		return bookList.stream().flatMap(s -> Stream.ofNullable(s)).filter(b -> !(b.getPrice() == null))
				.mapToDouble(Book::getPrice).average().orElse(0);
	}

}
