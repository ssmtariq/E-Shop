package com.ecommerce.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Payments implements Serializable{
	private Integer paymentId;
	private Orders order;
	private double amount;
	private String tranSactionId;	//IPN or Credit Card. Could be multiple for one order
	private Integer status;
	private String method;			//IPN or Credit Card. 
	private Timestamp createdOn;
	private Timestamp updatedOn;
	
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTranSactionId() {
		return tranSactionId;
	}
	public void setTranSactionId(String tranSactionId) {
		this.tranSactionId = tranSactionId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
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
	
	public Payments() {
		super();
	}
	public Payments(Integer paymentId) {
		super();
		this.paymentId = paymentId;
	}
	public Payments(Integer paymentId, Orders order, double amount,
			String tranSactionId, Integer status, String method,
			Timestamp createdOn, Timestamp updatedOn) {
		super();
		this.paymentId = paymentId;
		this.order = order;
		this.amount = amount;
		this.tranSactionId = tranSactionId;
		this.status = status;
		this.method = method;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}
}
