package it.esedra.corso.lezioni.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Esercizio1 {

	public static void main(String args[]) {
		
		ArrayList<String> strings = new ArrayList<>(); 
		strings.add("Ciao");
		strings.add("sono");
		strings.add("Francesco");
		
		Iterator<String> i = strings.iterator();
		while (i.hasNext()) {
			String string = i.next(); 
			System.out.println(string);
		}
		
		HashSet<String> set = new HashSet<>(); 
		set.add("c");
		set.add("a");
		set.add("b");
		set.add("a"); 
		
		for (String string : set) {
			System.out.println(string); 
			
		}
		Test a = new Test(); 
		Test b = new Test();
		Test c = new Test(); 
		Test d = b;
		
		a.setTest("Francesco");  
		b.setTest("Baroni");
		c.setTest("Francesco");

		
		HashSet<Test> students = new HashSet<>(); 
		students.add(a); 
		students.add(b);
		students.add(c); 
		students.add(a); 
		students.add(d); 
		
		
		for (Test string : students) {
			System.out.println(string);
		}
		
		for (Test string : students) {
			System.out.println(string.getTest());
		
		}
		
		System.out.println(a.equals(c));
		
		SortedSet<Test> cars = new TreeSet<>(new Comparator<Test> () {
			@Override
			public int compare(Test o, Test a) {
				return o.getTest().compareTo(a.getTest()); 

			}
		}); 
		cars.add(a); 
		cars.add(b); 
		cars.add(c); 
		
		for (Test string : cars) {
			System.out.println(string.getTest());
		}
	
		System.out.println(a.compareTo(b));
		
	}
}

	

