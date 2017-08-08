package com.ecommerce.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.ecommerce.form.AdminForm;
import com.ecommerce.model.Admin;
import com.ecommerce.service.AdminService;
import com.ecommerce.util.AESencryptionUtil;
import com.ecommerce.util.ApplicationConstants;
import com.ecommerce.util.SendEmailUtil;

public class AdminAction extends DispatchAction{
	private AdminService adminService;
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}


	public ActionForward saveAdmin(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		AdminForm adminForm = (AdminForm) actionForm;
		Admin  admin = new Admin();
		adminForm.setCreatedOn(new Timestamp(System.currentTimeMillis()));
		adminForm.setUpdatedOn(adminForm.getCreatedOn());
		BeanUtils.copyProperties(admin, adminForm);
		admin.setStatus(ApplicationConstants.USER_INACTIVE);
		admin.setPassword(AESencryptionUtil.encrypt(admin.getPassword()));
		String confirmationId = AESencryptionUtil.encrypt(""+admin.getAdminId());
		String confirmationKey = AESencryptionUtil.encrypt(admin.getEmail());
		try{
			adminService.insert(admin);
			admin=adminService.getAdmin(admin.getAdminId());
			if(admin!=null){
				String url = "http://"
						+ApplicationConstants.APPLICATION_HOSTNAME
						+":"+ApplicationConstants.APPLICATION_PORT
						+request.getContextPath()
						+"/user.do?method=confirmation&cK="+confirmationKey+"&cI="+confirmationId;
				SendEmailUtil.sendEmail(
						ApplicationConstants.EMAIL_USERNAME, 
						ApplicationConstants.EMAIL_PASSWORD, 
						admin.getEmail(), 
						ApplicationConstants.REGISTRATION_EMAIL_SUBJECT, 
						ApplicationConstants.REGISTRATION_EMAIL_BODY,
						url
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(admin!=null){
			System.out.println("success");
			request.setAttribute("message", "Admin Created Successfully!");
			return (actionMapping.findForward("success"));
		} else {
			return (actionMapping.findForward("failure"));
		}
	}
}
