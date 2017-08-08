package com.ecommerce.form;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

public class CategoriesForm extends ValidatorForm{
	private Integer categoryId;
	private String categoryName;
	private String parentId;
	private Timestamp createdOn;
	private Timestamp updatedOn;
	private FormFile categoryImage;
	
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
		byte[] b1;
		try {
			b1 = categoryName.getBytes("ISO-8859-1");
			categoryName = new String(b1, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.categoryName = categoryName;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
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
	public FormFile getCategoryImage() {
		return categoryImage;
	}
	public void setCategoryImage(FormFile categoryImage) {
		this.categoryImage = categoryImage;
	}
}
