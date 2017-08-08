package com.ecommerce.action;

import java.sql.Timestamp;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.ecommerce.form.UsersForm;
import com.ecommerce.model.Countries;
import com.ecommerce.model.Users;
import com.ecommerce.service.MenuService;
import com.ecommerce.service.UsersService;
import com.ecommerce.util.AESencryptionUtil;
import com.ecommerce.util.ApplicationConstants;
import com.ecommerce.util.SendEmailUtil;

public class UserAction extends DispatchAction{
	private UsersService usersService;
		
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public ActionForward saveUser(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		UsersForm usersForm = (UsersForm) actionForm;
		Users  user = new Users();
		usersForm.setCreatedOn(new Timestamp(System.currentTimeMillis()));
		usersForm.setUpdatedOn(usersForm.getCreatedOn());
		BeanUtils.copyProperties(user, usersForm);
		usersForm = null;
		user.setStatus(ApplicationConstants.USER_INACTIVE);
		user.setPassword(AESencryptionUtil.encrypt(user.getPassword()));
		user.setBillingCountry(new Countries(Integer.parseInt(request.getParameter("billingCountryId"))));
		user.setShippingCountry(new Countries(Integer.parseInt(request.getParameter("shippingCountryId"))));
		String confirmationId = AESencryptionUtil.encrypt(""+user.getUserId());
		String confirmationKey = AESencryptionUtil.encrypt(user.getEmail());
		try{
			usersService.insert(user);
			user=usersService.getUsers(user.getUserId());
			if(user!=null){
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
						ApplicationConstants.REGISTRATION_EMAIL_BODY,
						url
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(user!=null){
			System.out.println("success");
			return (actionMapping.findForward("success"));
		} else {
			return (actionMapping.findForward("failure"));
		}
	}
}
