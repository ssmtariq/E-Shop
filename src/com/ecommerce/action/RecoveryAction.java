package com.ecommerce.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.ecommerce.form.RecoveryForm;
import com.ecommerce.model.Users;
import com.ecommerce.service.UsersService;
import com.ecommerce.util.AESencryptionUtil;
import com.ecommerce.util.ApplicationConstants;
import com.ecommerce.util.SendEmailUtil;

public class RecoveryAction extends DispatchAction{
	private UsersService usersService;
		
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	
	public ActionForward recoverAccount(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		RecoveryForm recoveryForm = (RecoveryForm) actionForm;
		Users user = null;
		user = usersService.getUserByEmail(recoveryForm.getEmail());
		if(user!=null && user.getMobileNo().equals(recoveryForm.getMobileNo())){
			try{
				SendEmailUtil.sendEmail(
						ApplicationConstants.EMAIL_USERNAME, 
						ApplicationConstants.EMAIL_PASSWORD, 
						user.getEmail(), 
						ApplicationConstants.RECOVERY_EMAIL_SUBJECT, 
						ApplicationConstants.RECOVERY_EMAIL_BODY,
						AESencryptionUtil.decrypt(user.getPassword())
						);
			} catch (Exception e) {
				e.printStackTrace();
			}
	        System.out.println("success");
		    return (actionMapping.findForward("success"));
	    } else {
	    	 return (actionMapping.findForward("failure"));
	    }
	}

}
