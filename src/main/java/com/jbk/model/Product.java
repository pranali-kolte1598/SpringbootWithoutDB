package com.jbk.model;

import org.springframework.stereotype.Component;

@Component
public class Product {

	private long productid;
	private String productnm;;
	private long supplierid;
	private long  categaryid ;
	private int productqty;
	private double productprice;
	private int deliverycharges;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(long productid, String productnm, long supplierid, long categaryid, int productqty,
			double productprice, int deliverycharges) {
		super();
		this.productid = productid;
		this.productnm = productnm;
		this.supplierid = supplierid;
		this.categaryid = categaryid;
		this.productqty = productqty;
		this.productprice = productprice;
		this.deliverycharges = deliverycharges;
	}
	public long getProductid() {
		return productid;
	}
	public void setProductid(long productid) {
		this.productid = productid;
	}
	public String getProductnm() {
		return productnm;
	}
	public void setProductnm(String productnm) {
		this.productnm = productnm;
	}
	public long getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(long supplierid) {
		this.supplierid = supplierid;
	}
	public long getCategaryid() {
		return categaryid;
	}
	public void setCategaryid(long categaryid) {
		this.categaryid = categaryid;
	}
	public int getProductqty() {
		return productqty;
	}
	public void setProductqty(int productqty) {
		this.productqty = productqty;
	}
	public double getProductprice() {
		return productprice;
	}
	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}
	public int getDeliverycharges() {
		return deliverycharges;
	}
	public void setDeliverycharges(int deliverycharges) {
		this.deliverycharges = deliverycharges;
	}
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productnm=" + productnm + ", supplierid=" + supplierid
				+ ", categaryid=" + categaryid + ", productqty=" + productqty + ", productprice=" + productprice
				+ ", deliverycharges=" + deliverycharges + "]";
	}
	
	
}
