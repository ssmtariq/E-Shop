package com.ecommerce.model;

import com.sun.jmx.snmp.Timestamp;

public class ProductComments {
	public int id;
	public Products productId;
	public Users userId;
	public String comments;
	public Timestamp createdOn;
	public Timestamp updatedOn;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Products getProductId() {
		return productId;
	}
	public void setProductId(Products productId) {
		this.productId = productId;
	}
	public Users getUserId() {
		return userId;
	}
	public void setUserId(Users userId) {
		this.userId = userId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
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
}
