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
import com.ecommerce.service.CategoriesService;
import com.ecommerce.service.MenuService;
import com.ecommerce.util.ApplicationConstants;
import com.ecommerce.util.SessionManagementUtil;

public class DashboardController extends DispatchAction{
	private CategoriesService categoriesService;
	private MenuService menuService;

	public void setCategoriesService(CategoriesService categoriesService) {
		this.categoriesService = categoriesService;
	}
	
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public ActionForward show(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		List<Categories> categoriesList = new ArrayList<Categories>();
		if(categoriesService.getAllCategories().size()>0){
			categoriesList = categoriesService.getAllCategories();
		}
		SessionManagementUtil sessionManagementUtil = new SessionManagementUtil(request);
		request.setAttribute(ApplicationConstants.SESSION_USER_TYPE, sessionManagementUtil.getUserType(ApplicationConstants.SESSION_USER_TYPE));
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
		request.setAttribute("categoriesList", categoriesList);
		return actionMapping.findForward("success");
	}
}
