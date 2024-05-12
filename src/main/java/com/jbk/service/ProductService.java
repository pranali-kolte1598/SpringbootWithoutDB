package com.jbk.service;

import com.jbk.model.Product;

public interface ProductService {

	
	
	public int addProduct(Product product);
	
	public Object getProductById(long productId);
	
	
	public int deleteProductById(long productId);
	
	public int updateProduct(Product product);
	
	public Product getMaxPriceProduct();
	
	
	
}
