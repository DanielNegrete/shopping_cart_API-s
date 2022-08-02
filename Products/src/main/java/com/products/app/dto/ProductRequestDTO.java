package com.products.app.dto;

public class ProductRequestDTO {
	
	private String productName;
	private String productImage;
	private String productCategorie;
	private double productPrice;
	
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
}
