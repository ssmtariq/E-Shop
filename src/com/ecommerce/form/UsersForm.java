package com.ecommerce.form;

import java.sql.Timestamp;

import org.apache.struts.validator.ValidatorForm;

public class UsersForm extends ValidatorForm{
	private int id;
	private String firstName;			//Required
	private String lastName;
	private String email;				//Required
	private String password;				//Must be Encrypted
	private String confirmPassword;				//Must be Encrypted
	private String mobileNo;				//Required
	private int status;					//0-Active, 1-Inactive(Until email verified), 2-Blocked
	private String billingAddress;
	private String billingCity;
	private int billingCountryId;
	private String billingZipcode;
	private String shippingAddress;
	private String shippingCity;
	private int shippingCountryId;
	private String shippingZipcode;
	private Timestamp createdOn;
	private Timestamp updatedOn;			//Use db trigger to update timestamp
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
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
	public int getBillingCountryId() {
		return billingCountryId;
	}
	public void setBillingCountryId(int billingCountryId) {
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
	public int getShippingCountryId() {
		return shippingCountryId;
	}
	public void setShippingCountryId(int shippingCountryId) {
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
