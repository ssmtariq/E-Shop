package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dao.CommonDao;
import com.ecommerce.model.OrderedProducts;
import com.ecommerce.model.Orders;

public class OrderedProductsService {
	CommonDao dao;

	public CommonDao getDao() {
		return dao;
	}

	public void setDao(CommonDao dao) {
		this.dao = dao;
	}

	public Integer update(OrderedProducts orderedProducts) {
		return dao.update(orderedProducts);
	}

	public Integer insert(OrderedProducts orderedProducts) {
		return dao.insert(orderedProducts);
	}

	public Integer delete(OrderedProducts orderedProducts) {
		return dao.delete(orderedProducts);
	}

	public OrderedProducts getOrderedProducts(Integer id) {
		return (OrderedProducts) dao.getEntity(id);
	}
	
	public List<OrderedProducts> getAllOrderedProducts() {
		return (List<OrderedProducts>) dao.getAllEntity();
	}

	public List<OrderedProducts> getOrderedProductsDynamic(Orders orders) {
		return (List<OrderedProducts>) dao.getEntityDynamic(orders);
	}
}
