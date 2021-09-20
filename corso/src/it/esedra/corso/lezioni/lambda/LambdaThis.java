package it.esedra.corso.lezioni.lambda;

public class LambdaThis {

	private String stringa = "variabile di istanza della classe";
	public void metodoContenenteLambda() {
		
		String stringa = "variabile locale del metodo contenente";
		
		new Thread(() -> System.out.println(this.stringa)).start();
		new Thread(() -> System.out.println(stringa)).start();
	}


	public static void main(String[] args) {
		
		LambdaThis lambdaThis = new LambdaThis();
		lambdaThis.metodoContenenteLambda();
				
	}
}
