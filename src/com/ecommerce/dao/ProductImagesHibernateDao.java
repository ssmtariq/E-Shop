package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.ecommerce.model.ProductImages;
import com.ecommerce.model.Products;

public class ProductImagesHibernateDao implements CommonDao{
	private SessionFactory sessionFactory;
	
	public ProductImagesHibernateDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Integer insert(Object object) {
		ProductImages productImages = (ProductImages) object;
		Transaction transaction = null;
		Session session = null;
		Integer i = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			i = (Integer) session.save(productImages);
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
		ProductImages productImages = (ProductImages) object;
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(productImages);
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
		ProductImages productImages = (ProductImages) object;
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			session.delete(productImages);
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
	public ProductImages getEntity(Integer id) {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			return (ProductImages) session.get(ProductImages.class, id);
		} finally {

			transaction.commit();
			session.close();
		}
	}

	@Override
	public List<ProductImages> getAllEntity() {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			List list = session.createQuery("from ProductImages").list();
			return list;
		} finally {
			transaction.commit();
			session.close();
		}
	}

	@Override
	public List<ProductImages> getEntityDynamic(Object object) {
		ProductImages productImages = (ProductImages) object;
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Products.class);

		if (productImages.getProduct().getProductName() != null && (!productImages.getProduct().getProductName().isEmpty()))
			criteria.add(Restrictions.ge("productName", productImages.getProduct().getProductName()));

		try {
			return criteria.addOrder(Property.forName("id").desc()).setMaxResults(10).list();
		} finally {
			transaction.commit();
			session.close();
		}
	}
}
