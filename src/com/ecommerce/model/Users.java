package com.ecommerce.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Users implements Serializable{
	private Integer userId;
	private String firstName;			//Required
	private String lastName;
	private String email;				//Required
	private String password;				//Must be Encrypted
	private String mobileNo;				//Required
	private Integer status;					//0-Active, 1-Inactive(Until email verified), 2-Blocked
	private String billingAddress;
	private String billingCity;
	private Countries billingCountry;
	private String billingZipcode;
	private String shippingAddress;
	private String shippingCity;
	private Countries shippingCountry;
	private String shippingZipcode;
	private Timestamp createdOn;
	private Timestamp updatedOn;			//Use db trigger to update timestamp
	
	public Users() { }

	public Users(Integer userId, String firstName, String lastName,
			String email, String password, String mobileNo, Integer status,
			String billingAddress, String billingCity,
			Countries billingCountry, String billingZipcode,
			String shippingAddress, String shippingCity,
			Countries shippingCountry, String shippingZipcode,
			Timestamp createdOn, Timestamp updatedOn) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.status = status;
		this.billingAddress = billingAddress;
		this.billingCity = billingCity;
		this.billingCountry = billingCountry;
		this.billingZipcode = billingZipcode;
		this.shippingAddress = shippingAddress;
		this.shippingCity = shippingCity;
		this.shippingCountry = shippingCountry;
		this.shippingZipcode = shippingZipcode;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Countries getBillingCountry() {
		return billingCountry;
	}

	public void setBillingCountry(Countries billingCountry) {
		this.billingCountry = billingCountry;
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

	public Countries getShippingCountry() {
		return shippingCountry;
	}

	public void setShippingCountry(Countries shippingCountry) {
		this.shippingCountry = shippingCountry;
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

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", mobileNo=" + mobileNo + ", status=" + status
				+ ", billingAddress=" + billingAddress + ", billingCity="
				+ billingCity + ", billingCountry=" + billingCountry
				+ ", billingZipcode=" + billingZipcode + ", shippingAddress="
				+ shippingAddress + ", shippingCity=" + shippingCity
				+ ", shippingCountry=" + shippingCountry + ", shippingZipcode="
				+ shippingZipcode + ", createdOn=" + createdOn + ", updatedOn="
				+ updatedOn + "]";
	}	
}
