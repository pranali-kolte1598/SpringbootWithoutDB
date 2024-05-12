package com.jbk.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jbk.dao.ProductDao;
import com.jbk.daoimpl.Productdaoimpl;
import com.jbk.model.Product;
import com.jbk.service.ProductService;
@Service
@Scope("prototype")
public class ProductServiceimpl implements ProductService {

	@Autowired
	ProductDao dao;
	
	
	
	public ProductServiceimpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addProduct(Product product) {
		
		

		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
		product.setProductid(Long.parseLong(timeStamp));

		System.out.println(timeStamp);

		int status = dao.addProduct(product);
		return status;
	}

	@Override
	public Object getProductById(long productId) {

		return dao.getProductById(productId);

	}

	@Override
	public int deleteProductById(long productId) {

		
		int status = 0;
		Object object = getProductById(productId);

		if (object instanceof Product) {
			status = dao.deleteProductById((Product) object);
		} else if (object instanceof String) {
			String msg = (String) object;
			if ("Something Went Wrong".equals(msg)) {
				status = 4;
			} else {
				status = 2;
			}
		}

		return status;
	}

	@Override
	public int updateProduct(Product product) {
		
		int status = 0;
		Object object = getProductById(product.getProductid());

		if (object instanceof Product) {
			status = dao.updateProductById(product);
		} else if (object instanceof String) {
			String msg = (String) object;
			if ("Something Went Wrong".equals(msg)) {
				status = 4;
			} else {
				status = 2;
			}
		}

		return status;
	}

	@Override
	public Product getMaxPriceProduct() {
		
		return dao.getMaxPriceProduct();
	}

}



