package com.ecommerce.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Attributes implements Serializable{
	private Integer attributeId;
	private String type;
	private String attributeName;
	private Timestamp createdOn;
	private Timestamp updatedOn;
	
	public Integer getAttributeId() {
		return attributeId;
	}
	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
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
	
	public Attributes() {
		super();
	}
	
	public Attributes(Integer attributeId) {
		super();
		this.attributeId = attributeId;
	}
	
	public Attributes(Integer attributeId, String type, String attributeName,
			Timestamp createdOn, Timestamp updatedOn) {
		super();
		this.attributeId = attributeId;
		this.type = type;
		this.attributeName = attributeName;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}
}
