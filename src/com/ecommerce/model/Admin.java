package com.ecommerce.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Admin implements Serializable{
	private Integer adminId;
	private String name;			//Required
	private String email;				//Required
	private String password;				//Must be Encrypted
	private Integer type;					//0-Active, 1-Inactive(Until email verified), 2-Blocked
	private Integer status;					//0-Active, 1-Inactive(Until email verified), 2-Blocked
	private Timestamp createdOn;
	private Timestamp updatedOn;
	
	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Admin() {
		super();
	}
	
	public Admin(Integer adminId) {
		super();
		this.adminId = adminId;
	}
	
	public Admin(Integer adminId, String name, String email, String password,
			Integer type, Integer status, Timestamp createdOn,
			Timestamp updatedOn) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.type = type;
		this.status = status;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}
	
	
}
