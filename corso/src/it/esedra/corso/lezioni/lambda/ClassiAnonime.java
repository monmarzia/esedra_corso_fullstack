package it.esedra.corso.lezioni.lambda;

public class ClassiAnonime {

	public static void main(String[] args) {
		var testObject = new Object() {
			void test(String test) {
				System.out.println(test);
			}
		};
		testObject.test("prova");
	}
	
	ClasseEsistente ce = new ClasseEsistente() {
		@Override
		public void metodo() {
			// TODO Auto-generated method stub

		}
	};
	

}

