package com.ecommerce.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ecommerce.model.Admin;

public class AdminExtensionDao {
	private SessionFactory sessionFactory;
	
	public AdminExtensionDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Admin getAdminByEmail(String email) {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			Admin admin = (Admin) session.createQuery("from Admin WHERE email=:adminEmail").setParameter("adminEmail", email).uniqueResult();
			return admin;
		} finally {
			transaction.commit();
			session.close();
		}
	}
}
