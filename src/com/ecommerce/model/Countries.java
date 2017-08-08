package com.ecommerce.model;

import java.io.Serializable;
import java.sql.Timestamp;


public class Countries implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -604006077383911963L;
	public Integer countryId;
	public String code;
	public String countryName;
	public Timestamp createdOn;
	
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	public Countries() {
		super();
	}
	public Countries(int countryId ) {
		super();
		this.countryId = countryId;
	}
	public Countries(int countryId, String code, String countryName,
			Timestamp createdOn) {
		this.countryId = countryId;
		this.code = code;
		this.countryName = countryName;
		this.createdOn = createdOn;
	}
	@Override
	public String toString() {
		return "Countries [countryId=" + countryId + ", code=" + code
				+ ", countryName=" + countryName + ", createdOn=" + createdOn
				+ "]";
	}	
}
