package com.ecommerce.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Orders implements Serializable{
	private Integer orderId;
	private Users user;
	private double taxVat;
	private double shippingCost;
	private Integer status;
	private Timestamp createdOn;
	private Timestamp updatedOn;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
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
	
	public Orders() {
		super();
	}
	public Orders(Integer orderId) {
		super();
		this.orderId = orderId;
	}
	public Orders(Integer orderId, Users user, double taxVat,
			double shippingCost, Integer status, Timestamp createdOn,
			Timestamp updatedOn) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.taxVat = taxVat;
		this.shippingCost = shippingCost;
		this.status = status;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}
}
