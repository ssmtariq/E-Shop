package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ecommerce.model.Countries;

public class CountriesHibernateDao implements CommonDao {
	private SessionFactory sessionFactory;
	
	public CountriesHibernateDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Integer insert(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<?> getAllEntity() {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			List list = session.createQuery("from Countries").list();
			return list;
		} finally {
			transaction.commit();
			session.close();
		}
	}

	@Override
	public List<?> getEntityDynamic(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getEntity(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
