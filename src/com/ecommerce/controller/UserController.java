package com.ecommerce.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.ecommerce.form.AdminForm;
import com.ecommerce.form.UsersForm;
import com.ecommerce.model.Admin;
import com.ecommerce.model.Categories;
import com.ecommerce.model.Countries;
import com.ecommerce.model.Products;
import com.ecommerce.model.Users;
import com.ecommerce.service.AdminService;
import com.ecommerce.service.CountriesService;
import com.ecommerce.service.MenuService;
import com.ecommerce.service.UsersService;
import com.ecommerce.util.AESencryptionUtil;
import com.ecommerce.util.ApplicationConstants;
import com.ecommerce.util.SessionManagementUtil;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class UserController extends DispatchAction{
	private AdminService adminService;
	private UsersService usersService;
	private CountriesService countriesService;
	private MenuService menuService;

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public void setCountriesService(CountriesService countriesService) {
		this.countriesService = countriesService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public ActionForward signIn(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
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
		request.setAttribute("currentAction", (request.getRequestURL()+"?method=signIn"));
		if(request.getParameter("message")!=null){
			request.setAttribute("message", request.getParameter("message"));
		}
		if(request.getParameter("createOrder")!=null){
			request.setAttribute("createOrder", request.getParameter("createOrder"));
		}
		return actionMapping.findForward("signIn");
	}

	public ActionForward signOut(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		SessionManagementUtil sessionManagementUtil = new SessionManagementUtil(request);
		sessionManagementUtil.setSignInStatus("signInStatus", false);
		sessionManagementUtil.setUser(ApplicationConstants.SESSION_CURRENT_USER, null);
		sessionManagementUtil.setAdmin(ApplicationConstants.SESSION_CURRENT_ADMIN, null);
		request.setAttribute(ApplicationConstants.SESSION_CURRENT_USER, sessionManagementUtil.getUser(ApplicationConstants.SESSION_CURRENT_USER));
		request.setAttribute(ApplicationConstants.SESSION_CURRENT_ADMIN, sessionManagementUtil.getUser(ApplicationConstants.SESSION_CURRENT_ADMIN));
		request.setAttribute(ApplicationConstants.SESSION_SIGN_IN_STATUS, sessionManagementUtil.getSignInStatus(ApplicationConstants.SESSION_SIGN_IN_STATUS));
		request.setAttribute("message", "signOut");
		return actionMapping.findForward("signOut");
	}
	
	public ActionForward signUp(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		UsersForm usersForm = (UsersForm) actionForm;
		request.setAttribute("usersForm", usersForm);
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
		request.setAttribute("currentAction", (request.getRequestURL()+"?method=signUp"));
		return actionMapping.findForward("signUp");
	}
	
	
	public ActionForward createAdmin(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
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
		request.setAttribute("currentAction", (request.getRequestURL()+"?method=createAdmin"));
		return actionMapping.findForward("createAdmin");
	}
	
	public ActionForward confirmation(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
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
		request.setAttribute("currentAction", (request.getRequestURL()+"?method=confirmRegistration"));
		String cK = AESencryptionUtil.decrypt((String) request.getParameter("cK"));
		System.out.println(cK);
		Users users = usersService.getUserByEmail(cK);
		if(users!=null && users.getStatus()==ApplicationConstants.USER_INACTIVE){
			users.setStatus(ApplicationConstants.USER_ACTIVE);
			usersService.update(users);
			return actionMapping.findForward("confirmationSuccess");
		}else {
			Admin admin = adminService.getAdminByEmail(cK);
			if(admin!=null && admin.getStatus()==ApplicationConstants.USER_INACTIVE){
				admin.setStatus(ApplicationConstants.USER_ACTIVE);
				adminService.update(admin);
				return actionMapping.findForward("confirmationSuccess");
			}else {
				return actionMapping.findForward("confirmationFailure");
			}
		}
	}

	public ActionForward accessRecovery(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
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
		request.setAttribute("currentAction", (request.getRequestURL()+"?method=accessRecovery"));
		return actionMapping.findForward("accessRecovery");
	}
	
	public ActionForward isEmailExists(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.setContentType("text/html");
		response.setHeader("cache-control", "no-cache");
		request.setCharacterEncoding("UTF-8");
		boolean isExists = usersService.isEmailExists(request.getParameter("email"));
		request.setAttribute("isExists", isExists);
		PrintWriter printWriter = response.getWriter();
		String jsonInString = new Gson().toJson(isExists);
		printWriter.print(jsonInString);
		return null;
	}

	public ActionForward adminList(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		List<Admin> adminList = (adminService.getAllAdmin().size()>0)? (adminService.getAllAdmin()) : null;
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
		request.setAttribute("adminList", adminList);
		request.setAttribute("message", request.getParameter("message"));
		request.setAttribute("currentAction", (request.getRequestURL()+"?method=adminList"));
		return actionMapping.findForward("adminList");
	}
	

	public ActionForward deleteAdmin(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		Admin  admin= adminService.getAdmin(Integer.parseInt(request.getParameter("adminId")));
		Integer adminId=0;
		try{
			adminId=adminService.delete(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(adminId!=null){
			request.setAttribute("message", "Admin Deleted Successfully!");
		    return (actionMapping.findForward("deleteAdminSuccess"));
	    } else {
	    	 return (actionMapping.findForward("deleteFailed"));
	    }
	}
}
