package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.ecommerce.model.Categories;

public class CategoriesExtensionDao {
	private SessionFactory sessionFactory;
	
	public CategoriesExtensionDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Categories getCategory(String id) {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			return (Categories) session.get(Categories.class, id);
		} finally {
			transaction.commit();
			session.close();
		}
	}
	
	public String insert(Object object) {
		Categories category = (Categories) object;
		Transaction transaction = null;
		Session session = null;
		String i = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			i = (String) session.save(category);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
		return i;
	}
	
	public List<Categories> getNavCategoriesList() {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			List list = session.createQuery("from Categories WHERE parent IS NULL").list();
			return list;
		} finally {
			transaction.commit();
			session.close();
		}
	}
	
	public List<Categories> getCategoryWiseSubcategoryList(Categories categories) {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			List list = session.createQuery("from Categories WHERE parent = "+categories.getCategoryId()).list();
			return list;
		} finally {
			transaction.commit();
			session.close();
		}
	}
}
