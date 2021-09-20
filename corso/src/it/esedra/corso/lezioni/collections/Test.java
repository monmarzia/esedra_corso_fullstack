package it.esedra.corso.lezioni.collections;
import java.lang.Comparable; 

public class Test implements Comparable<Test> {
	public static void main(String args[]) {
	}
	private String test;
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	
	@Override 
	public boolean equals (Object obj) {
		return ((Test)obj).getTest().equals(test); 
		
	}
	
	@Override
	public int hashCode() {
		return test.hashCode(); 
	}
	
	@Override
	public int compareTo(Test o) {
		return o.getTest().compareTo(test); 

	}
}
