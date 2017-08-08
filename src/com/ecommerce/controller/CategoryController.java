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

public class CategoryController extends DispatchAction{
	private CategoriesService categoriesService;
	private MenuService menuService;

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
		request.setAttribute("currentAction", (request.getRequestURL()+"?method=create"));
		return actionMapping.findForward("success");
	}

	public ActionForward list(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		List<Categories> categoriesList = (categoriesService.getAllCategories().size()>0)? (categoriesService.getAllCategories()) : null;
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
		request.setAttribute("message", request.getParameter("message"));
		request.setAttribute("currentAction", (request.getRequestURL()+"?method=list"));
		return actionMapping.findForward("categoryList");
	}
	
	public ActionForward edit(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		List<Categories> categoriesList = categoriesService.getAllCategories();
		Categories categories = categoriesService.getCategories(Integer.parseInt(request.getParameter("categoryId")));
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
		request.setAttribute("categories", categories);
		request.setAttribute("currentAction", (request.getRequestURL()+"?method=edit&categoryId="+categories.getCategoryId()));
		return actionMapping.findForward("editCategories");
	}	
	
	public ActionForward delete(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		Categories  categories= categoriesService.getCategories(Integer.parseInt(request.getParameter("categoryId")));
		Integer categoryId=0;
		try{
			categoryId=categoriesService.delete(categories);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(categoryId!=null){
			request.setAttribute("message", "Category Deleted Successfully!");
		    return (actionMapping.findForward("deleteSuccess"));
	    } else {
	    	 return (actionMapping.findForward("deleteFailed"));
	    }
	}

}
