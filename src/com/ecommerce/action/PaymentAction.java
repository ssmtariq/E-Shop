package com.ecommerce.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.ecommerce.form.PaymentsForm;
import com.ecommerce.model.Payments;
import com.ecommerce.service.OrdersService;
import com.ecommerce.service.PaymentsService;
import com.ecommerce.util.ApplicationConstants;
import com.ecommerce.util.SessionManagementUtil;

public class PaymentAction extends DispatchAction{
	private PaymentsService paymentsService;
	private OrdersService ordersService;
	
	public void setPaymentsService(PaymentsService paymentsService) {
		this.paymentsService = paymentsService;
	}

	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

	public ActionForward save(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		PaymentsForm paymentsForm = (PaymentsForm) actionForm;
		Payments  payments = new Payments();
		SessionManagementUtil sessionManagementUtil = new SessionManagementUtil(request);
		payments.setCreatedOn(new Timestamp(System.currentTimeMillis()));
		payments.setUpdatedOn(paymentsForm.getCreatedOn());
		payments.setAmount(sessionManagementUtil.getAmount(ApplicationConstants.SESSION_CURRENT_ORDER_AMOUNT));
		//BeanUtils.copyProperties(payments, paymentsForm);
		payments.setOrder(sessionManagementUtil.getOrder(ApplicationConstants.SESSION_CURRENT_ORDER));
		payments.setStatus(ApplicationConstants.PAYMENT_COMPLETE);
		payments.setMethod(ApplicationConstants.PAYMENT_METHOD_IPN);
		payments.setTranSactionId(""+payments.getOrder().getOrderId());
		Integer paymentId =null;
		try{
			paymentId = paymentsService.insert(payments);
			payments = paymentsService.getPayments(paymentId);
			sessionManagementUtil.setAmount(ApplicationConstants.SESSION_CURRENT_ORDER_AMOUNT, null);
			sessionManagementUtil.setOrder(ApplicationConstants.SESSION_CURRENT_ORDER, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(paymentId!=null){
			System.out.println("success");
			request.setAttribute("message", "Payments Created Successfully!");
			return (actionMapping.findForward("success"));
		} else {
			return (actionMapping.findForward("failure"));
		}
	}
}
