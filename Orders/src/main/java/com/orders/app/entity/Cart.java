package com.orders.app.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Cart {
	
	private Integer productId;
	private String productName;
	private String productImage;
	private String productCategorie;
	private double productPrice;
	private Integer productQ;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductCategorie() {
		return productCategorie;
	}
	public void setProductCategorie(String productCategorie) {
		this.productCategorie = productCategorie;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getProductQ() {
		return productQ;
	}
	public void setProductQ(Integer productQ) {
		this.productQ = productQ;
	}
}
