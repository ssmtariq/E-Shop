package com.ecommerce.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.ecommerce.form.LoginForm;
import com.ecommerce.form.UsersForm;
import com.ecommerce.model.Admin;
import com.ecommerce.model.Users;
import com.ecommerce.service.AdminService;
import com.ecommerce.service.CountriesService;
import com.ecommerce.service.UsersService;
import com.ecommerce.util.AESencryptionUtil;
import com.ecommerce.util.ApplicationConstants;
import com.ecommerce.util.SessionManagementUtil;

public class UserAccessController extends DispatchAction{
	private UsersService usersService;
	private AdminService adminService;

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public ActionForward verifySignIn(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		LoginForm loginForm = (LoginForm) actionForm;
		Users users = null;
		users = usersService.getUserByEmail(loginForm.getEmail());
		Admin admin = null;
		if(users==null){
			admin = adminService.getAdminByEmail(loginForm.getEmail());
		}
		if(users!=null){
			if(users.getStatus()!=ApplicationConstants.USER_ACTIVE){
				request.setAttribute("message", "userInactive");
				return actionMapping.findForward("failure");
			}
			String userPassword = AESencryptionUtil.decrypt(users.getPassword());
			if(userPassword.equals(loginForm.getPassword())){
				SessionManagementUtil sessionManagementUtil = new SessionManagementUtil(request);
				sessionManagementUtil.setSignInStatus(ApplicationConstants.SESSION_SIGN_IN_STATUS, true);
				sessionManagementUtil.setUser(ApplicationConstants.SESSION_CURRENT_USER, users);
				request.setAttribute(ApplicationConstants.SESSION_CURRENT_USER, sessionManagementUtil.getUser(ApplicationConstants.SESSION_CURRENT_USER));
				request.setAttribute(ApplicationConstants.SESSION_SIGN_IN_STATUS, sessionManagementUtil.getSignInStatus(ApplicationConstants.SESSION_SIGN_IN_STATUS));
				sessionManagementUtil.setUserType(ApplicationConstants.SESSION_USER_TYPE, ApplicationConstants.USER_TYPE_GENERAL);
				request.setAttribute(ApplicationConstants.SESSION_USER_TYPE, ApplicationConstants.USER_TYPE_GENERAL);
				if(request.getParameter("createOrder")!=null){
					return actionMapping.findForward("checkStatusPlaceOrder");
				}
				return actionMapping.findForward("success");
			}
		}
		if(admin!=null){
			if(admin.getStatus()!=ApplicationConstants.USER_ACTIVE){
				request.setAttribute("message", "userInactive");
				return actionMapping.findForward("failure");
			}
			String adminPassword = AESencryptionUtil.decrypt(admin.getPassword());
			if(adminPassword.equals(loginForm.getPassword())){
				SessionManagementUtil sessionManagementUtil = new SessionManagementUtil(request);
				sessionManagementUtil.setSignInStatus(ApplicationConstants.SESSION_SIGN_IN_STATUS, true);
				sessionManagementUtil.setAdmin(ApplicationConstants.SESSION_CURRENT_ADMIN, admin);
				request.setAttribute(ApplicationConstants.SESSION_CURRENT_ADMIN, sessionManagementUtil.getAdmin(ApplicationConstants.SESSION_CURRENT_ADMIN));
				request.setAttribute(ApplicationConstants.SESSION_SIGN_IN_STATUS, sessionManagementUtil.getSignInStatus(ApplicationConstants.SESSION_SIGN_IN_STATUS));
				if(admin.getType()==0){
					request.setAttribute(ApplicationConstants.SESSION_USER_TYPE, ApplicationConstants.USER_TYPE_ADMIN);
					sessionManagementUtil.setUserType(ApplicationConstants.SESSION_USER_TYPE, ApplicationConstants.USER_TYPE_ADMIN);
				}
				if(admin.getType()==1){
					request.setAttribute(ApplicationConstants.SESSION_USER_TYPE, ApplicationConstants.USER_TYPE_SUPER_ADMIN);
					sessionManagementUtil.setUserType(ApplicationConstants.SESSION_USER_TYPE, ApplicationConstants.USER_TYPE_SUPER_ADMIN);
				}
				if(request.getParameter("createOrder")!=null){
					return actionMapping.findForward("checkStatusPlaceOrder");
				}
				return actionMapping.findForward("success");
			}
		}
		request.setAttribute("message", "again");
		return actionMapping.findForward("failure");
	}
	
}
