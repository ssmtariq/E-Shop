package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.ecommerce.model.Orders;
import com.ecommerce.model.Users;
import com.ecommerce.util.SessionManagementUtil;

public class OrdersHibernateDao implements CommonDao {
	private SessionFactory sessionFactory;
	
	public OrdersHibernateDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Integer insert(Object object) {
		Orders order = (Orders) object;
		Transaction transaction = null;
		Session session = null;
		Integer i = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			i = (Integer) session.save(order);
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
		Orders order = (Orders) object;
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(order);
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
		Orders order = (Orders) object;
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			session.delete(order);
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
	public Orders getEntity(Integer id) {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			return (Orders) session.get(Orders.class, id);
		} finally {

			transaction.commit();
			session.close();
		}
	}

	@Override
	public List<Orders> getAllEntity() {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			List list = session.createQuery("from Orders").list();
			return list;
		} finally {
			transaction.commit();
			session.close();
		}
	}

	@Override
	public List<Orders> getEntityDynamic(Object object) {
		Users users = (Users) object;
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Orders.class);

		try {
			List list = session.createQuery("from Orders WHERE user=:currentUser ORDER BY createdOn desc").setParameter("currentUser", users).list();
			return list;
		} finally {
			transaction.commit();
			session.close();
		}
	}


}
