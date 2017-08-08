package com.ecommerce.model;

import java.io.Serializable;

public class ShoppingCart implements Serializable{
	private Integer productId;
	private Integer quantity;
	private String productName;
	private String imageName;
	private double productPrice;
	private double unitPrice;
	private double originalPrice;
	private double discountPrice;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}
	public double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}
	public ShoppingCart() {
		super();
	}
	public ShoppingCart(Integer productId, Integer quantity,
			String productName, String imageName, double productPrice,
			double unitPrice, double originalPrice, double discountPrice) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.productName = productName;
		this.imageName = imageName;
		this.productPrice = productPrice;
		this.unitPrice = unitPrice;
		this.originalPrice = originalPrice;
		this.discountPrice = discountPrice;
	}
}
