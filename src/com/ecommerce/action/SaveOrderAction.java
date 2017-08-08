package com.ecommerce.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.SessionActionMapping;

import com.ecommerce.form.OrdersForm;
import com.ecommerce.model.Admin;
import com.ecommerce.model.Countries;
import com.ecommerce.model.OrderedProducts;
import com.ecommerce.model.Orders;
import com.ecommerce.model.Products;
import com.ecommerce.model.ShoppingCart;
import com.ecommerce.model.Users;
import com.ecommerce.service.CountriesService;
import com.ecommerce.service.OrderedProductsService;
import com.ecommerce.service.OrdersService;
import com.ecommerce.service.ProductsService;
import com.ecommerce.service.UsersService;
import com.ecommerce.util.AESencryptionUtil;
import com.ecommerce.util.ApplicationConstants;
import com.ecommerce.util.SendEmailUtil;
import com.ecommerce.util.SessionManagementUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class SaveOrderAction extends Action{
	private OrdersService ordersService;
	private OrderedProductsService orderedProductsService;
	private UsersService usersService;
	private ProductsService productsService;
	private CountriesService countriesService;
	
	public void setProductsService(ProductsService productsService) {
		this.productsService = productsService;
	}
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}
	public void setOrderedProductsService(
			OrderedProductsService orderedProductsService) {
		this.orderedProductsService = orderedProductsService;
	}
	
	public void setCountriesService(CountriesService countriesService) {
		this.countriesService = countriesService;
	}
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		SessionManagementUtil sessionManagementUtil = new SessionManagementUtil(request);
		OrdersForm ordersForm = (OrdersForm) actionForm;
		Orders  orders = new Orders();
		ordersForm.setCreatedOn(new Timestamp(System.currentTimeMillis()));
		ordersForm.setUpdatedOn(ordersForm.getCreatedOn());
		BeanUtils.copyProperties(orders, ordersForm);
		if(request.getParameter("currentAdminId")!=null){
			return (actionMapping.findForward("failure"));
		}				
		Users user = null;
		if(request.getParameter("currentUserId")!=null){
			user = usersService.getUsers(Integer.parseInt(request.getParameter("currentUserId")));
			user.setBillingCity(ordersForm.getBillingCity());
			user.setBillingAddress(ordersForm.getBillingAddress());
			user.setBillingZipcode(ordersForm.getBillingZipcode());
			user.setShippingCity(ordersForm.getShippingCity());
			user.setShippingAddress(ordersForm.getShippingAddress());
			user.setShippingZipcode(ordersForm.getShippingZipcode());
			/*user.setBillingCountry(countriesService.getCountries(Integer.parseInt(request.getParameter("billingCountryId"))));
			user.setShippingCountry(countriesService.getCountries(Integer.parseInt(request.getParameter("shippingCountryId"))));*/
		}
		orders.setShippingCost(Double.parseDouble(request.getParameter("shippingCost")));
		orders.setUser(user);
		orders.setStatus(ApplicationConstants.ORDER_PENDING);
		List<OrderedProducts> orderedProductList = getOrderedProductList(request);
		Integer orderId = null;
		OrderedProducts orderedProducts = null;
		try{
			usersService.update(user);
			orderId = ordersService.insert(orders);
			sessionManagementUtil.setOrder(ApplicationConstants.SESSION_CURRENT_ORDER, orders);
			for(int i=0; i<orderedProductList.size(); i++){
				orderedProducts = new OrderedProducts();
				orderedProducts = orderedProductList.get(i);
				sessionManagementUtil.setAmount(ApplicationConstants.SESSION_CURRENT_ORDER_AMOUNT, (orderedProducts.getUnitPrice()*orderedProducts.getQuantity()));
				orderedProducts.setOrder(orders);
				orderedProductsService.insert(orderedProducts);
			}
			request.setAttribute("orderId", orderId);
			orders = ordersService.getOrders(orderId);
			System.out.println("userId"+user.getUserId());
			System.out.println("orderId"+orderId);
			/*if(user!=null){
				String url = "http://"
							+ApplicationConstants.APPLICATION_HOSTNAME
							+":"+ApplicationConstants.APPLICATION_PORT
							+request.getContextPath()
							+"/user.do?method=confirmation&cK="+confirmationKey+"&cI="+confirmationId;
				SendEmailUtil.sendEmail(
						ApplicationConstants.EMAIL_USERNAME, 
						ApplicationConstants.EMAIL_PASSWORD, 
						user.getEmail(), 
						ApplicationConstants.REGISTRATION_EMAIL_SUBJECT, 
						url
						);
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(orderId!=null){
	        System.out.println("success");
		    return (actionMapping.findForward("success"));
	    } else {
	    	 return (actionMapping.findForward("failure"));
	    }
	}
	
	public List<OrderedProducts> getOrderedProductList(HttpServletRequest request){
		SessionManagementUtil sessionManagementUtil = new SessionManagementUtil(request);
		ArrayList<ShoppingCart> shoppingCartList = sessionManagementUtil.getItemList(ApplicationConstants.SHOPPING_CART_ITEMS);
		List<OrderedProducts> orderedProductList = new ArrayList<OrderedProducts>();
		for(int i=0; i<shoppingCartList.size(); i++){
			OrderedProducts orderedProducts = new OrderedProducts();
			orderedProducts.setProduct(productsService.getProducts(shoppingCartList.get(i).getProductId()));
			orderedProducts.setUnitPrice(shoppingCartList.get(i).getUnitPrice());
			orderedProducts.setQuantity(shoppingCartList.get(i).getQuantity());
			orderedProducts.setCreatedOn(new Timestamp(System.currentTimeMillis()));
			orderedProducts.setUpdatedOn(orderedProducts.getCreatedOn());
			orderedProductList.add(orderedProducts);
		}
		return orderedProductList;
	}
}
