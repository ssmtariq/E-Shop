package com.ecommerce.form;

import java.sql.Timestamp;

import org.apache.struts.validator.ValidatorForm;

public class PaymentsForm extends ValidatorForm{
	private Integer paymentId;
	private String orderId;
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
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
	
}
