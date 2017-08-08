package com.ecommerce.form;

import java.sql.Timestamp;

import org.apache.struts.validator.ValidatorForm;

public class OrdersForm extends ValidatorForm{
	private Integer orderId;
	private Integer userId;
	private double taxVat;
	private double shippingCost;
	private Integer status;
	private Integer quantity;
	private String billingAddress;
	private String billingCity;
	private Integer billingCountryId;
	private String billingZipcode;
	private String shippingAddress;
	private String shippingCity;
	private Integer shippingCountryId;
	private String shippingZipcode;
	private Timestamp createdOn;
	private Timestamp updatedOn;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public double getTaxVat() {
		return taxVat;
	}
	public void setTaxVat(double taxVat) {
		this.taxVat = taxVat;
	}
	public double getShippingCost() {
		return shippingCost;
	}
	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	public String getBillingCity() {
		return billingCity;
	}
	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}
	public Integer getBillingCountryId() {
		return billingCountryId;
	}
	public void setBillingCountryId(Integer billingCountryId) {
		this.billingCountryId = billingCountryId;
	}
	public String getBillingZipcode() {
		return billingZipcode;
	}
	public void setBillingZipcode(String billingZipcode) {
		this.billingZipcode = billingZipcode;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getShippingCity() {
		return shippingCity;
	}
	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}
	public Integer getShippingCountryId() {
		return shippingCountryId;
	}
	public void setShippingCountryId(Integer shippingCountryId) {
		this.shippingCountryId = shippingCountryId;
	}
	public String getShippingZipcode() {
		return shippingZipcode;
	}
	public void setShippingZipcode(String shippingZipcode) {
		this.shippingZipcode = shippingZipcode;
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
