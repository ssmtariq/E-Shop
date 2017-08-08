package com.ecommerce.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Products implements Serializable{
	private Integer productId;
	private String productName;
	private Integer quantity;
	private double originalPrice;
	private double discountPrice;
	private Integer featured;			// Use constant here
	private String description;		//Use Rich Text box for input 
	private Integer availability;		//1-Available, 2-Future_Product, 3-Not_For_Sale
	private Categories category;
	private Timestamp createdOn;
	private Timestamp updatedOn;
	
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
	public Integer getFeatured() {
		return featured;
	}
	public void setFeatured(Integer featured) {
		this.featured = featured;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getAvailability() {
		return availability;
	}
	public void setAvailability(Integer availability) {
		this.availability = availability;
	}
	public Categories getCategory() {
		return category;
	}
	public void setCategory(Categories category) {
		this.category = category;
	}
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	public Timestamp getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	public Products(){
		super();
	}
	public Products(int productId){
		super();
		this.productId = productId;
	}
	public Products(int productId, String productName, int quantity,
			double originalPrice, double discountPrice, int featured,
			String description, int availability, Categories category,
			Timestamp createdOn, Timestamp updatedOn) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.originalPrice = originalPrice;
		this.discountPrice = discountPrice;
		this.featured = featured;
		this.description = description;
		this.availability = availability;
		this.category = category;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}
	
}
