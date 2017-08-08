package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.ecommerce.model.Orders;
import com.ecommerce.model.Payments;
import com.ecommerce.model.Products;

public class PaymentsHibernateDao implements CommonDao {
	private SessionFactory sessionFactory;
	
	public PaymentsHibernateDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Integer insert(Object object) {
		Payments payments = (Payments) object;
		Transaction transaction = null;
		Session session = null;
		Integer i = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			i = (Integer) session.save(payments);
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
		Payments payments = (Payments) object;
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(payments);
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
		Payments payments = (Payments) object;
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			session.delete(payments);
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
	public Payments getEntity(Integer id) {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			return (Payments) session.get(Payments.class, id);
		} finally {

			transaction.commit();
			session.close();
		}
	}

	@Override
	public List<Payments> getAllEntity() {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			List list = session.createQuery("from Payments ORDER BY createdOn desc").list();
			return list;
		} finally {
			transaction.commit();
			session.close();
		}
	}

	@Override
	public List<Payments> getEntityDynamic(Object object) {
		Orders orders = (Orders) object;
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Products.class);

		try {
			List list = session.createQuery("from Payments WHERE order=:userOrder ORDER BY createdOn desc").setParameter("userOrder", orders).list();
			return list;
		} finally {
			transaction.commit();
			session.close();
		}
	}
}
