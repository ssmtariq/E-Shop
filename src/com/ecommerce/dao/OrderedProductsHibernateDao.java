package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.ecommerce.model.OrderedProducts;
import com.ecommerce.model.Orders;
import com.ecommerce.model.Products;

public class OrderedProductsHibernateDao implements CommonDao{
	private SessionFactory sessionFactory;
	
	public OrderedProductsHibernateDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Integer insert(Object object) {
		OrderedProducts orderedProducts = (OrderedProducts) object;
		Transaction transaction = null;
		Session session = null;
		Integer i = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			i = (Integer) session.save(orderedProducts);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
		return i;
	}

	@Override
	public int update(Object object) {
		OrderedProducts orderedProducts = (OrderedProducts) object;
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(orderedProducts);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
		return 0;
	}

	@Override
	public int delete(Object object) {
		OrderedProducts orderedProducts = (OrderedProducts) object;
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			session.delete(orderedProducts);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
		return 0;
	}

	@Override
	public OrderedProducts getEntity(Integer id) {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			return (OrderedProducts) session.get(OrderedProducts.class, id);
		} finally {

			transaction.commit();
			session.close();
		}
	}

	@Override
	public List<OrderedProducts> getAllEntity() {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			List list = session.createQuery("from OrderedProducts ORDER BY createdOn desc").list();
			return list;
		} finally {
			transaction.commit();
			session.close();
		}
	}

	@Override
	public List<OrderedProducts> getEntityDynamic(Object object) {
		Orders orders = (Orders) object;
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Products.class);

		try {
			List list = session.createQuery("from OrderedProducts WHERE order=:currentOrder ORDER BY createdOn desc").setParameter("currentOrder", orders).list();
			return list;
		} finally {
			transaction.commit();
			session.close();
		}
	}
}
