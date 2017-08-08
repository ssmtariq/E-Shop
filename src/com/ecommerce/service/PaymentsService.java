package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dao.CommonDao;
import com.ecommerce.model.Orders;
import com.ecommerce.model.Payments;

public class PaymentsService {
	CommonDao dao;

	public CommonDao getDao() {
		return dao;
	}

	public void setDao(CommonDao dao) {
		this.dao = dao;
	}

	public Integer update(Payments payments) {
		return dao.update(payments);
	}

	public Integer insert(Payments payments) {
		return dao.insert(payments);
	}

	public Integer delete(Payments payments) {
		return dao.delete(payments);
	}

	public Payments getPayments(Integer id) {
		return (Payments) dao.getEntity(id);
	}
	
	public List<Payments> getAllPayments() {
		return (List<Payments>) dao.getAllEntity();
	}

	public List<Payments> getPaymentsDynamic(Orders orders) {
		return (List<Payments>) dao.getEntityDynamic(orders);
	}
}
