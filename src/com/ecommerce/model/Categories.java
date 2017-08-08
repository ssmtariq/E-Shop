package com.ecommerce.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Categories implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3126342959260030351L;
	private Integer categoryId;
	private String categoryName;
	private Categories parent;
	private String imageName;
	private Timestamp createdOn;
	private Timestamp updatedOn;

	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Categories getParent() {
		return parent;
	}
	public void setParent(Categories parent) {
		this.parent = parent;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
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
	
	public Categories() {
		super();
	}
	public Categories(int categoryId ) {
		super();
		this.categoryId = categoryId;
	}
	public Categories(Integer categoryId, String categoryName,
			Categories parent, String imageName, Timestamp createdOn,
			Timestamp updatedOn) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.parent = parent;
		this.imageName = imageName;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}
}
