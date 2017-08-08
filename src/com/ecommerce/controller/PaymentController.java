package com.ecommerce.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.ecommerce.model.Categories;
import com.ecommerce.model.Orders;
import com.ecommerce.model.Payments;
import com.ecommerce.model.ShoppingCart;
import com.ecommerce.service.CategoriesService;
import com.ecommerce.service.MenuService;
import com.ecommerce.service.OrdersService;
import com.ecommerce.service.PaymentsService;
import com.ecommerce.util.ApplicationConstants;
import com.ecommerce.util.SessionManagementUtil;

public class PaymentController extends DispatchAction{
	private PaymentsService paymentsService;
	private OrdersService ordersService;
	private CategoriesService categoriesService;
	private MenuService menuService;

	public void setPaymentsService(PaymentsService paymentsService) {
		this.paymentsService = paymentsService;
	}

	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

	public void setCategoriesService(CategoriesService categoriesService) {
		this.categoriesService = categoriesService;
	}
	
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	
	public ActionForward create(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		SessionManagementUtil sessionManagementUtil = new SessionManagementUtil(request);
		ArrayList<ShoppingCart> shoppingCartList = sessionManagementUtil.getItemList(ApplicationConstants.SHOPPING_CART_ITEMS);
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
		request.setAttribute("shoppingCartList", shoppingCartList);
		request.setAttribute("currentAction", (request.getRequestURL()+"?method=create"));
		return actionMapping.findForward("success");
	}
	

	public ActionForward list(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		SessionManagementUtil sessionManagementUtil = new SessionManagementUtil(request);
		List<Payments> paymentsList = new ArrayList<Payments>();
		if(sessionManagementUtil.getUser(ApplicationConstants.SESSION_CURRENT_USER)!=null){
			List<Orders> orderList = ordersService.getOrdersDynamic(sessionManagementUtil.getUser(ApplicationConstants.SESSION_CURRENT_USER));
			if(orderList.size()>0){
				for(int i=0; i<orderList.size(); i++){
					paymentsList.addAll(paymentsService.getPaymentsDynamic(orderList.get(i)));
				}
			}
		}
		if(sessionManagementUtil.getAdmin(ApplicationConstants.SESSION_CURRENT_ADMIN)!=null){
			paymentsList = paymentsService.getAllPayments();
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
		request.setAttribute("paymentsList", paymentsList);
		request.setAttribute("message", request.getParameter("message"));
		request.setAttribute("currentAction", (request.getRequestURL()+"?method=list"));
		return actionMapping.findForward("paymentList");
	}
}
