package it.esedra.corso.esercitazione.mvc;

public class Controller {
	public static void main(String[] args) {
		Controller controller = new Controller();
		
	}
	/*
	 * param : type,action,id,name,price
	 * action : save, get, delete, find
	 */
	public void handler(String param) throws Exception {
		String[] splitParams = param.split(",");
		String type = splitParams[0];
		
		switch (type) {
			case "product" :
				new ProductOperation().process(splitParams);
				break;
			default :
				throw new Exception("unknown type");
		}
	}
	
}
