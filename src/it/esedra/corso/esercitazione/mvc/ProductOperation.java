package it.esedra.corso.esercitazione.mvc;

import java.math.BigInteger;

public class ProductOperation implements Operation<Product>{

	@Override
	public void save(Product t) throws OperationException {
		// TODO Auto-generated method stub
		
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
	public void process(String[] params) throws OperationException {
		
		String type = params[0];
		if (!type.equals("product")) {
			throw new OperationException("type is invalid");
		}
		String action = params[1];
		String id = params[2];
		String name = params[3];
		String price = params[4];	
		
	}
	
}
