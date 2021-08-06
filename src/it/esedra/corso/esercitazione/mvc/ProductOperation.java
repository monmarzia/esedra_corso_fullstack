package it.esedra.corso.esercitazione.mvc;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ProductOperation implements Operation<Product>{

	@Override
	public void save(Product product) throws OperationException {
		ProductDao productdao = new ProductDao();
		try {
			productdao.save(product);
		} catch (DaoException e) {
			throw new OperationException(e.getMessage());
			
		}
		
	}

	@Override
	public void get(BigInteger id) throws OperationException {
		
		
	}

	@Override
	public void delete(BigInteger id) throws OperationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void find(Product t) throws OperationException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Product bind(String[] params) throws OperationException {
		Product product = new Product();
		product.setName(params[3]);
		product.setId(new BigInteger(params[2]));
		product.setPrice(new BigDecimal(params[4]));
		return product;
	}
	
	@Override
	public void validate(String[] params) throws ValidateException{	
		
		//type,action,id,name,price
		/*
		 * verifica che la cella 1 non sia null o vuota
		 * parte dalla seconda cella dato che la 1a è stata precedentemente verificata
		 */
			if(params[1] == null || params[1].equals("")) {
				throw new ValidateException("params[" + 1 + "] cannot be null or empty ");
			}
				

		
		/* 
		 * prova a sfruttare il costruttore di BigInteger(String) con la cella che dovrebbe contenere l'id
		 * se genera una eccezione allora significa che non riesce a parsare , sicuramente non è un id giusto
		 */		
		try { 
			new BigInteger(params[2]);  
		} catch (Exception e) {
			throw new ValidateException("params[" + 2 + "] is not a BigInteger ");
		}
		
		/* 
		 * prova a sfruttare il costruttore di BigDecimal(String) con la cella che dovrebbe contenere il prezzo 
		 * se genera una eccezione allora significa che non riesce a parsare , sicuramente non è un prezzo giusto
		 */	
		try {
			new BigDecimal(params[4]);   
		} catch (Exception e) {
			throw new ValidateException("params[" + 4 + "] is not a BigDecimal ");
		}
		
	}  
	
	@Override
	public void process(String[] params) throws OperationException {
		
		String type = params[0];
		if (!type.equals("product")) {
			throw new OperationException("type is invalid");
		}
		String action = params[1];
		processHandler(action, bind(params));
	}
	
	@Override
	public void processHandler(String action, Product product) throws OperationException {
		switch (action) {
			case "save" :
				save(product);
				break;
			case "get" :
				get(product.getId());
				break;
			case "delete" :
				delete(product.getId());
				break;
			case "find" :
				find(product);
				break;
			default :
				throw new OperationException("unknown action");
		}
	}
	
	
}
