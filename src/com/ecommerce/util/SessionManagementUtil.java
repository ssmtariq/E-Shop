package com.ecommerce.util;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.criterion.Order;

import com.ecommerce.model.Admin;
import com.ecommerce.model.Orders;
import com.ecommerce.model.ShoppingCart;
import com.ecommerce.model.Users;

public class SessionManagementUtil {
	private static HttpSession httpSession;

	public static HttpSession getHttpSession() {
		return httpSession;
	}
	public static void setHttpSession(HttpSession httpSession) {
		SessionManagementUtil.httpSession = httpSession;
	}

	public SessionManagementUtil(HttpServletRequest httpServletRequest) {
		SessionManagementUtil.setHttpSession(httpServletRequest.getSession());
	}
	
	public   ArrayList<ShoppingCart> getItemList(String attributeName) {
		return (ArrayList<ShoppingCart>) httpSession.getAttribute(attributeName);
	}
	
	public  boolean setItemList(String attributeName, ArrayList<ShoppingCart> shoppingCartList) {
		httpSession.setAttribute(attributeName, shoppingCartList);
		if (getItemList(attributeName)!=null){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean getSignInStatus(String attributeName) {
		if(httpSession.getAttribute(attributeName)==null){
			return false;
		}else{
			return true;
		}
	}
	
	public void setSignInStatus(String attributeName, boolean signInStatus) {
		httpSession.setAttribute(attributeName, signInStatus);
	}
	
	public Users getUser(String attributeName) {
		return (Users)httpSession.getAttribute(attributeName);
	}
	
	public void setUser(String attributeName, Users users) {
		httpSession.setAttribute(attributeName, users);
	}
	
	public Admin getAdmin(String attributeName) {
		return (Admin)httpSession.getAttribute(attributeName);
	}
	
	public void setAdmin(String attributeName, Admin admin) {
		httpSession.setAttribute(attributeName, admin);
	}
	
	public Integer getUserType(String attributeName) {
		return (Integer)httpSession.getAttribute(attributeName);
	}
	
	public void setUserType(String attributeName, Integer userType) {
		httpSession.setAttribute(attributeName, userType);
	}
	
	public Orders getOrder(String attributeName) {
		return (Orders)httpSession.getAttribute(attributeName);
	}
	
	public void setOrder(String attributeName, Orders orders) {
		httpSession.setAttribute(attributeName, orders);
	}
	
	public Double getAmount(String attributeName) {
		return (Double)httpSession.getAttribute(attributeName);
	}
	
	public void setAmount(String attributeName, Double amount) {
		httpSession.setAttribute(attributeName, amount);
	}
	
}
