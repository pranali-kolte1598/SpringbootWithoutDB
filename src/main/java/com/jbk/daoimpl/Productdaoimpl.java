package com.jbk.daoimpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jbk.dao.ProductDao;
import com.jbk.model.Product;
@Repository
public class Productdaoimpl implements ProductDao {

		List<Product> list = new ArrayList<>();

		public Productdaoimpl() {
			list.add(new Product(101, "aa", 1, 1, 1000, 10, 10));
			list.add(new Product(102, "bb", 1, 1, 1000, 5, 10));
			list.add(new Product(103, "cc", 1, 1, 1500, 15, 15));
			list.add(new Product(104, "dd", 1, 1, 700, 150, 15));
		}

		@Override
		public int addProduct(Product product) {
			
			try {
				boolean isExists = false;
				for (Product dbProduct : list) {
					if (dbProduct.getProductnm().equalsIgnoreCase(product.getProductnm())) {
						isExists = true;
					}
				}
				if (isExists == false) {
					list.add(product);

					return 1;
				} else {
					return 2;
				}

			} catch (Exception e) {
				e.printStackTrace();
				return 3;
			}

		}

		@Override
		public Object getProductById(long productId) { // productId 5 // 1,2,3,4,5,6,7,8,9

			try {
				for (Product product : list) {

					if (product.getProductid() == productId) {
						return product;
					}
					// int a = 10 / 0;

				}
			} catch (Exception e) {
				e.printStackTrace();
				return "Something Went Wrong";
			}

			return "Product Not Found";

		}

		@Override
		public int deleteProductById(Product product) {
			int status = 0;
			try {

				list.remove(product);
				status = 1;

			} catch (Exception e) {
				e.printStackTrace();
				status = 3;
			}

			return status;
		}

		@Override
		public int updateProductById(Product product) {
			int status = 0;
			try {
				Object dbProduct = getProductById(product.getProductid());

				int index = list.indexOf(dbProduct);

				System.out.println(index);

				list.set(index, product);
				status = 1;

			} catch (Exception e) {
				e.printStackTrace();
				status = 3;
			}
			return status;
		}

		@Override
		public Product getMaxPriceProduct() {

			Product product = null;
			double maxPrice = 0;
			try {
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return product;
		}

	
}
