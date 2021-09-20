package it.esedra.corso.lezioni.collections;

import java.util.ArrayList;

public class Lezione {

	public static void main(String[] args) {
		
			ArrayList<String> strings = new ArrayList<String>();
			strings.add("orologio");
			strings.add("finestra");
			strings.add("tastiera");
			
			System.out.println(strings.get(1));
			
			for(String tmpString : strings) {
				System.out.println(tmpString);
			}
			ArrayList string2 = new ArrayList();
			string2.add("orologio");
			string2.add("finestra");
			string2.add("tastiera");
			
			
			for(Object tmpString : string2) {
				System.out.println((String)tmpString);
			}
	}

}
