package com.ecommerce.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ecommerce.model.Admin;
import com.ecommerce.model.Users;

public class UsersExtensionDao {
	private SessionFactory sessionFactory;
	
	public UsersExtensionDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Users getUserByEmail(String email) {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			Users users = (Users) session.createQuery("from Users WHERE email=:userEmail").setParameter("userEmail", email).uniqueResult();
			return users;
		} finally {
			transaction.commit();
			session.close();
		}
	}
	
	public boolean isEmailExists(String email) {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			Users users = (Users) session.createQuery("from Users WHERE email=:userEmail").setParameter("userEmail", email).uniqueResult();
			if(users==null){
				Admin admin = (Admin) session.createQuery("from Admin WHERE email=:adminEmail").setParameter("adminEmail", email).uniqueResult();
				if(admin==null){
					return false;
				}else {
					return true;
				}
			}else {
				return true;
			}
		} finally {
			transaction.commit();
			session.close();
		}
	}
}
