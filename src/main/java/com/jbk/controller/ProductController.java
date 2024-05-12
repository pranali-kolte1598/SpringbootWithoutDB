package com.jbk.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.exception.ResourceAlreadyExitsException;
import com.jbk.exception.ResourceNotExitsException;
import com.jbk.model.Product;
import com.jbk.service.ProductService;
import com.jbk.serviceimpl.ProductServiceimpl;


@RestController
public class ProductController {

	
		
		@Autowired
		ProductService service;
		
		@Autowired
		ProductService service2;

		@PostMapping("/add-product")
		public String addProduct(@RequestBody @Valid Product product) {
			System.out.println("in controller add product");
			int status = service.addProduct(product);// to complete left side automaticallt // alt + Shift + L
			if (status == 1) {
				return "Added Successfully";
			} else if (status == 2) {

				throw new ResourceAlreadyExitsException("Product Already Exists , Id = " + product.getProductid());
			} else {
				return "something went wrong";
			}

		}

		@GetMapping("/get-product-by-id/{productId}")
		public Object getProductById(@PathVariable long productId) {
			
			System.out.println(service);
			System.out.println(service2);

			return service.getProductById(productId);

		}

		@DeleteMapping("/delete-product-by-id")
		public String deleteProductById(@RequestParam("productId") long productId) {

			int status = service.deleteProductById(productId);

			switch (status) {
			case 1:
				return "Deleted Successfully !";

			case 2:
				throw new ResourceNotExitsException("Product Not Exists To Delete ID = " + productId);

			case 3:
				return "something went wrong during delete product, Id = " + productId;

			case 4:
				return "something went wrong during get product to delete, Id = " + productId;

			}
			return null;

		}

		@PutMapping("/update-product")
		public String updateProduct(@RequestBody Product product) {

			int status = service.updateProduct(product);

			switch (status) {
			case 1:
				return "Updated Successfully !";

			case 2:
				return "Product Not Exists To Update ID = " + product.getProductid();

			case 3:
				return "something went wrong during update product, Id = " + product.getProductid();

			case 4:
				return "something went wrong during get product to update, Id = " + product.getProductid();

			}
			return null;

		}
		
		@GetMapping("max-price-product")
		public Object getMaxPriceProduct() {
			Product maxPriceProduct = service.getMaxPriceProduct();
			if(maxPriceProduct!=null) {
				return maxPriceProduct;
			}else {
				return "List is empty";
			}
			
			
		}
	
	
		
	
}
