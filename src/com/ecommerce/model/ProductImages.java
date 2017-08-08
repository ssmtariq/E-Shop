package com.ecommerce.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class ProductImages implements Serializable{
	private Integer productImageId;
	private Products product;
	private String caption;
	private String imageName;
	private String originalName;
	private Timestamp createdOn;
	private Timestamp updatedOn;

	public Integer getProductImageId() {
		return productImageId;
	}
	public void setProductImageId(Integer productImageId) {
		this.productImageId = productImageId;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
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
	
	public ProductImages() {
		super();
	}
	public ProductImages(Integer productImageId) {
		super();
		this.productImageId = productImageId;
	}
	public ProductImages(Integer productImageId, Products product,
			String caption, String imageName, String originalName,
			Timestamp createdOn, Timestamp updatedOn) {
		super();
		this.productImageId = productImageId;
		this.product = product;
		this.caption = caption;
		this.imageName = imageName;
		this.originalName = originalName;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}
}
