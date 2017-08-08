package com.ecommerce.form;

import org.apache.struts.validator.ValidatorForm;

public class RecoveryForm extends ValidatorForm{
	private String email;				//Required
	private String mobileNo;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
}
