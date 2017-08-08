package com.ecommerce.form;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

public class ProductsForm extends ValidatorForm{
	private Integer productId;
	private String productName;
	private String quantity;
	private String originalPrice;
	private String discountPrice;
	private boolean featuredItem;			// Use constant here
	private FormFile productImage;			//Used for ProductImage Model 
	private String imageCaption;			//Used for ProductImage Model 
	private String description;		//Use Rich Text box for input 
	private Integer availability;		//1-Available, 2-Future_Product, 3-Not_For_Sale
	private String categoryId;
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
		byte[] b1;
		try {
			b1 = productName.getBytes("ISO-8859-1");
			productName = new String(b1, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.productName = productName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
	}
	public String getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(String discountPrice) {
		this.discountPrice = discountPrice;
	}
	public boolean isFeaturedItem() {
		return featuredItem;
	}
	public void setFeaturedItem(boolean featuredItem) {
		this.featuredItem = featuredItem;
	}
	public FormFile getProductImage() {
		return productImage;
	}
	public void setProductImage(FormFile productImage) {
		this.productImage = productImage;
	}
	public String getImageCaption() {
		return imageCaption;
	}
	public void setImageCaption(String imageCaption) {
		byte[] b1;
		try {
			b1 = imageCaption.getBytes("ISO-8859-1");
			imageCaption = new String(b1, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.imageCaption = imageCaption;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		byte[] b1;
		try {
			b1 = description.getBytes("ISO-8859-1");
			description = new String(b1, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.description = description;
	}
	public Integer getAvailability() {
		return availability;
	}
	public void setAvailability(Integer availability) {
		this.availability = availability;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
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
