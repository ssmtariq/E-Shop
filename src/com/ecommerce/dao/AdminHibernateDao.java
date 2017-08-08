package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.ecommerce.model.Admin;

public class AdminHibernateDao implements CommonDao{
	private SessionFactory sessionFactory;
	
	public AdminHibernateDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Integer insert(Object object) {
		Admin admin = (Admin) object;
		Transaction transaction = null;
		Session session = null;
		Integer i = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			i = (Integer) session.save(admin);
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
		Admin admin = (Admin) object;
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(admin);
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
		Admin admin = (Admin) object;
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			session.delete(admin);
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
	public Admin getEntity(Integer id) {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			return (Admin) session.get(Admin.class, id);
		} finally {

			transaction.commit();
			session.close();
		}
	}

	@Override
	public List<Admin> getAllEntity() {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			List list = session.createQuery("from Admin ORDER BY createdOn desc").list();
			return list;
		} finally {
			transaction.commit();
			session.close();
		}
	}

	@Override
	public List<Admin> getEntityDynamic(Object object) {
		Admin admin = (Admin) object;
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Admin.class);

		if (admin.getName() != null && (!admin.getName().isEmpty()))
			criteria.add(Restrictions.ge("adminName", admin.getName()));

		try {
			return criteria.addOrder(Property.forName("id").desc()).setMaxResults(10).list();
		} finally {
			transaction.commit();
			session.close();
		}
	}
}
