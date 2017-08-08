package com.ecommerce.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ecommerce.model.Categories;
import com.ecommerce.model.ProductImages;
import com.ecommerce.model.Products;
import com.ecommerce.util.ApplicationConstants;

public class ProductsExtensionDao {
	private SessionFactory sessionFactory;
	
	public ProductsExtensionDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Products> getLatestProductsList() {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			List list = session.createQuery("from Products WHERE availability =:productAvailability order by createdOn desc").setParameter("productAvailability", ApplicationConstants.PRODUCT_AVAILABLE).list();
			return list;
		} finally {
			transaction.commit();
			session.close();
		}
	}
	
	public List<Products> getFeaturedProductsList() {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			List list = null;
			list = session.createQuery("from Products WHERE featured =:featuredItem order by createdOn desc").setParameter("featuredItem", ApplicationConstants.PRODUCT_IS_FEATURED).list();
			return list;
		} finally {
			transaction.commit();
			session.close();
		}
	}
	
	public List<Products> getUpcomingProductsList() {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			List list = session.createQuery("from Products WHERE availability =:productAvailability order by createdOn desc").setParameter("productAvailability", ApplicationConstants.PRODUCT_COMING_SOON).list();
			return list;
		} finally {
			transaction.commit();
			session.close();
		}
	}
	
	public List<Products> getCategoryWiseProductList(Categories categories) {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			List list = session.createQuery("from Products WHERE category =:productCategory order by createdOn desc").setParameter("productCategory", categories).list();
			return list;
		} finally {
			transaction.commit();
			session.close();
		}
	}
	
	public List<Products> getSearchResults(String searchCriteria) {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			String sql = "SELECT * FROM PRODUCTS WHERE upper(product_name) LIKE upper(:searchCriteria)";
			Query query = session.createSQLQuery(sql).addEntity(Products.class).setParameter("searchCriteria", "%"+searchCriteria+"%");
			List list = query.list();
			return list;
		} finally {
			transaction.commit();
			session.close();
		}
	}
	
	public List<Products> getTopSaleProductsList() {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			String sql = "select p.id, p.product_name, p.quantity, p.original_price, p.discount_price  from products p where p.id in (select id from (select p.id,  count(op.id) count from products p, ordered_products op where p.id = op.product_id group by p.id order by count desc) )";
			Query query = session.createSQLQuery(sql);
			List list = query.list();
			return list;
		} finally {
			transaction.commit();
			session.close();
		}
	}
	
	public List<BigDecimal> getTopSaleProductsIdList() {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			String sql = "select p.id from products p where p.id in (select id from (select p.id,  count(op.id) count from products p, ordered_products op where p.id = op.product_id group by p.id order by count desc) )";
			Query query = session.createSQLQuery(sql);
			List list = query.list();
			return list;
		} finally {
			transaction.commit();
			session.close();
		}
	}
	
	public List<ProductImages> getProductImagesListByProduct(Products products) {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			List list = session.createQuery("from ProductImages WHERE product=:products").setParameter("products", products).list();
			return list;
		} finally {
			transaction.commit();
			session.close();
		}
	}
}
