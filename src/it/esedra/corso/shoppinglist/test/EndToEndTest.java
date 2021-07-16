package it.esedra.corso.shoppinglist.test;

public class EndToEndTest {
	public static void main(String args[]) {
		
		System.out.println("In seguito verranno lanciati tutti i test attualmente realizzati");
		
		AddUserTest test1 = new AddUserTest();
		AddShoppingListTest test2 = new AddShoppingListTest();
		
		test1.main(null);
		test2.main(null);
		
	}
}
