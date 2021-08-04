package it.esedra.corso.esercitazione.mvc;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ProductOperation implements Operation<Product>{

	@Override
	public void save(Product t) throws OperationException {
		
		
	}

	@Override
	public void get(BigInteger id) throws OperationException {
		// TODO Auto-generated method stub
		
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
