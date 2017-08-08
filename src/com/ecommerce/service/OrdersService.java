package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dao.CommonDao;
import com.ecommerce.model.Orders;
import com.ecommerce.model.Users;

public class OrdersService {
	CommonDao dao;

	public CommonDao getDao() {
		return dao;
	}

	public void setDao(CommonDao dao) {
		this.dao = dao;
	}

	public Integer update(Orders orders) {
		return dao.update(orders);
	}

	public Integer insert(Orders orders) {
		return dao.insert(orders);
	}

	public Integer delete(Orders orders) {
		return dao.delete(orders);
	}

	public Orders getOrders(Integer id) {
		return (Orders) dao.getEntity(id);
	}
	
	public List<Orders> getAllOrders() {
		return (List<Orders>) dao.getAllEntity();
	}

	public List<Orders> getOrdersDynamic(Users users) {
		return (List<Orders>) dao.getEntityDynamic(users);
	}
}
