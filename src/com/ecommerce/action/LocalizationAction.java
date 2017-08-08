package com.ecommerce.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class LocalizationAction extends DispatchAction{
	public ActionForward japanese(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) throws Exception {
		System.out.println(request.getParameter("currentAction"));
		request.getSession().setAttribute(Globals.LOCALE_KEY, Locale.JAPANESE);
		request.setAttribute("currentAction", request.getParameter("currentAction"));
		return mapping.findForward("success");
	}

	public ActionForward english(ActionMapping mapping,ActionForm form,
		HttpServletRequest request,HttpServletResponse response) throws Exception {
		System.out.println(request.getParameter("currentAction"));
		request.getSession().setAttribute(Globals.LOCALE_KEY, Locale.ENGLISH);
		request.setAttribute("currentAction", request.getParameter("currentAction"));
		return mapping.findForward("success");
	}
}
