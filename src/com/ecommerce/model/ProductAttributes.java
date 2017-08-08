package com.ecommerce.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class ProductAttributes implements Serializable{
	private Integer productAttributeId;
	private Products product;
	private Attributes attribute;
	private Timestamp createdOn;
	public Timestamp updatedOn;

	public Integer getProductAttributeId() {
		return productAttributeId;
	}
	public void setProductAttributeId(Integer productAttributeId) {
		this.productAttributeId = productAttributeId;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
	public Attributes getAttribute() {
		return attribute;
	}
	public void setAttribute(Attributes attribute) {
		this.attribute = attribute;
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
	
	public ProductAttributes() {
		super();
	}
	
	public ProductAttributes(Integer productAttributeId) {
		super();
		this.productAttributeId = productAttributeId;
	}
	
	public ProductAttributes(Integer productAttributeId, Products product,
			Attributes attribute, Timestamp createdOn, Timestamp updatedOn) {
		super();
		this.productAttributeId = productAttributeId;
		this.product = product;
		this.attribute = attribute;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}
}
