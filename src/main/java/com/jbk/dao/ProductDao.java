package com.jbk.dao;

import com.jbk.model.Product;

public interface ProductDao {
	public int addProduct(Product product);

	public Object getProductById(long productId);

	public int deleteProductById(Product product);

	public int updateProductById(Product object);

	public Product getMaxPriceProduct();
}


