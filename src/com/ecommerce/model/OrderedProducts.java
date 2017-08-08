package com.ecommerce.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class OrderedProducts  implements Serializable{
	private Integer orderedProductId;
	private Orders order;
	private Products product;
	private double unitPrice;	//If discountPrice exists it will be unitPrice, otherwise originalPrice
	private String color;
	private String size;
	private Integer	quantity;
	private Timestamp createdOn;
	private Timestamp updatedOn;
	
	public Integer getOrderedProductId() {
		return orderedProductId;
	}
	public void setOrderedProductId(Integer orderedProductId) {
		this.orderedProductId = orderedProductId;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
	
	public OrderedProducts() {
		super();
	}
	
	public OrderedProducts(Integer orderedProductId) {
		super();
		this.orderedProductId = orderedProductId;
	}
	
	public OrderedProducts(Integer orderedProductId, Orders order,
			Products product, double unitPrice, String color, String size,
			Integer quantity, Timestamp createdOn, Timestamp updatedOn) {
		super();
		this.orderedProductId = orderedProductId;
		this.order = order;
		this.product = product;
		this.unitPrice = unitPrice;
		this.color = color;
		this.size = size;
		this.quantity = quantity;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}
}
