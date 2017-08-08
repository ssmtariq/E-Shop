package com.ecommerce.form;

import org.apache.struts.validator.ValidatorForm;

public class LoginForm extends ValidatorForm{
	private String email;				//Required
	private String password;				//Required
	
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
}
