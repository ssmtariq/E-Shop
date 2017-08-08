package com.ecommerce.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.ecommerce.model.Categories;
import com.ecommerce.model.Countries;
import com.ecommerce.model.OrderedProducts;
import com.ecommerce.model.Orders;
import com.ecommerce.model.Products;
import com.ecommerce.service.CategoriesService;
import com.ecommerce.service.CountriesService;
import com.ecommerce.service.MenuService;
import com.ecommerce.service.OrderedProductsService;
import com.ecommerce.service.OrdersService;
import com.ecommerce.service.ProductsService;
import com.ecommerce.util.ApplicationConstants;
import com.ecommerce.util.SessionManagementUtil;

public class OrderController extends DispatchAction{
	private OrdersService ordersService;
	private OrderedProductsService orderedProductsService;
	private ProductsService productsService;
	private CountriesService countriesService;
	private CategoriesService categoriesService;
	private MenuService menuService;

	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}
	public void setOrderedProductsService(
			OrderedProductsService orderedProductsService) {
		this.orderedProductsService = orderedProductsService;
	}
	public void setProductsService(ProductsService productsService) {
		this.productsService = productsService;
	}
	public void setCountriesService(CountriesService countriesService) {
		this.countriesService = countriesService;
	}
	public void setCategoriesService(CategoriesService categoriesService) {
		this.categoriesService = categoriesService;
	}
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	public ActionForward create(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		List<Categories> categoriesList = new ArrayList<Categories>();
		if(categoriesService.getAllCategories().size()>0){
			categoriesList = categoriesService.getAllCategories();
		}
		SessionManagementUtil sessionManagementUtil = new SessionManagementUtil(request);
		if(sessionManagementUtil.getSignInStatus(ApplicationConstants.SESSION_SIGN_IN_STATUS)){
			if(sessionManagementUtil.getUser(ApplicationConstants.SESSION_CURRENT_USER)!=null){
				request.setAttribute(ApplicationConstants.SESSION_CURRENT_USER, sessionManagementUtil.getUser(ApplicationConstants.SESSION_CURRENT_USER));
			}else if(sessionManagementUtil.getAdmin(ApplicationConstants.SESSION_CURRENT_ADMIN)!=null){
				request.setAttribute(ApplicationConstants.SESSION_CURRENT_ADMIN, sessionManagementUtil.getAdmin(ApplicationConstants.SESSION_CURRENT_ADMIN));
			}
		}else {
			request.setAttribute("message", "pleaseSignIn");
			request.setAttribute("createOrder", "createOrder");
			return actionMapping.findForward("pleaseSignIn");
		}
		List<Countries> countriesList = (countriesService.getAllCountries().size()>0)? (countriesService.getAllCountries()) : null;
		/**************************************Load Shopping Cart Start************************************************/
		HashMap<String, String> cartHashMap = new HashMap<String, String>();
		cartHashMap = menuService.getCartSummary(request);
		request.setAttribute("numberOfItems", cartHashMap.get("numberOfItems"));
		request.setAttribute("totalPrice", cartHashMap.get("totalPrice"));
		/**************************************Load Shopping Cart End************************************************/
		HashMap<String, Object> menuMap = menuService.getMenu();
		request.setAttribute("navParentCategoriesList", menuMap.get("navParentCategoriesList"));
		request.setAttribute("moreCategoriesList", menuMap.get("noChildCategoriesList"));
		request.setAttribute("categoryWiseSubcategoryMap", menuMap.get("categoryWiseSubcategoryMap"));
		request.setAttribute("countriesList", countriesList);
		request.setAttribute("categoriesList", categoriesList);
		request.setAttribute("currentAction", (request.getRequestURL()+"?method=create"));
		return actionMapping.findForward("success");
	}

	public ActionForward list(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		SessionManagementUtil sessionManagementUtil = new SessionManagementUtil(request);
		List<Orders> ordersList = new ArrayList<Orders>();
		List<OrderedProducts> orderedProductsList = new ArrayList<OrderedProducts>();
		List<Products> productsList = new ArrayList<Products>();
		if(sessionManagementUtil.getUser(ApplicationConstants.SESSION_CURRENT_USER)!=null){
			ordersList = ordersService.getOrdersDynamic(sessionManagementUtil.getUser(ApplicationConstants.SESSION_CURRENT_USER));
		}else {
			ordersList = ordersService.getAllOrders();
		}
		if(ordersList.size()>0){
			for(int i=0; i<ordersList.size(); i++){
				orderedProductsList = orderedProductsService.getOrderedProductsDynamic(ordersList.get(i));
			}
		}
		if(orderedProductsList.size()>0){
			for(int i=0; i<orderedProductsList.size(); i++){
				Products products = new Products();
				products = productsService.getProducts(orderedProductsList.get(i).getProduct().getProductId());
				productsList.add(products);
			}
		}
		List<Map<String, String>> mapList = new ArrayList<Map<String,String>>();
		if(ordersList.size()>0){
			for(int i=0; i<ordersList.size(); i++){
				for(int j=0; j<orderedProductsList.size(); j++){
					HashMap<String, String> itemHashMap = new HashMap<String, String>();
					itemHashMap.put("productName", productsList.get(j).getProductName());
					itemHashMap.put("unitPrice", ""+orderedProductsList.get(j).getUnitPrice());
					itemHashMap.put("quantity", ""+orderedProductsList.get(j).getQuantity());
					itemHashMap.put("taxVat", ""+ordersList.get(i).getTaxVat());
					itemHashMap.put("shippingCost", ""+ordersList.get(i).getShippingCost());
					itemHashMap.put("orderId", ""+ordersList.get(i).getOrderId());
					itemHashMap.put("createdOn", ""+Date.from(ordersList.get(i).getCreatedOn().toInstant()));
					mapList.add(itemHashMap);
				}
			}
		}
		/**************************************Load Shopping Cart Start************************************************/
		HashMap<String, String> cartHashMap = new HashMap<String, String>();
		cartHashMap = menuService.getCartSummary(request);
		request.setAttribute("numberOfItems", cartHashMap.get("numberOfItems"));
		request.setAttribute("totalPrice", cartHashMap.get("totalPrice"));
		/**************************************Load Shopping Cart End************************************************/
		HashMap<String, Object> menuMap = menuService.getMenu();
		request.setAttribute("navParentCategoriesList", menuMap.get("navParentCategoriesList"));
		request.setAttribute("moreCategoriesList", menuMap.get("noChildCategoriesList"));
		request.setAttribute("categoryWiseSubcategoryMap", menuMap.get("categoryWiseSubcategoryMap"));
		request.setAttribute("mapList", mapList);
		request.setAttribute("message", request.getParameter("message"));
		request.setAttribute("currentAction", (request.getRequestURL()+"?method=list"));
		return actionMapping.findForward("list");
	}
	
	public ActionForward delete(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		Orders  orders= ordersService.getOrders(Integer.parseInt(request.getParameter("orderId")));
		Integer orderId=0;
		try{
			orderId=ordersService.delete(orders);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(orderId!=null){
			request.setAttribute("message", "Order Deleted Successfully!");
		    return (actionMapping.findForward("deleteSuccess"));
	    } else {
	    	 return (actionMapping.findForward("deleteFailed"));
	    }
	}

}
