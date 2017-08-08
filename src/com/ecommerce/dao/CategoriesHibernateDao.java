package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ecommerce.model.Categories;
import com.ecommerce.model.Products;

public class CategoriesHibernateDao implements CommonDao {
	private SessionFactory sessionFactory;
	
	public CategoriesHibernateDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Integer insert(Object object) {
		Categories category = (Categories) object;
		Transaction transaction = null;
		Session session = null;
		Integer i = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			i = (Integer) session.save(category);
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
		Categories categories = (Categories) object;
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(categories);
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
		Categories categories = (Categories) object;
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			session.delete(categories);
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
	public Object getEntity(Integer id) {
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

	@Override
	public List<?> getAllEntity() {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			List list = null;
			if(session.createQuery("from Categories")!=null){
				list = session.createQuery("from Categories Order By createdOn desc").list();
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			transaction.commit();
			session.close();
		}
		return null;
	}

	@Override
	public List<?> getEntityDynamic(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
