package com.ecommerce.service;

import java.math.BigDecimal;
import java.util.List;

import com.ecommerce.dao.CommonDao;
import com.ecommerce.dao.ProductsExtensionDao;
import com.ecommerce.model.Categories;
import com.ecommerce.model.ProductImages;
import com.ecommerce.model.Products;

public class ProductsService {
	CommonDao dao;
	ProductsExtensionDao productsExtensionDao;

	public CommonDao getDao() {
		return dao;
	}

	public void setDao(CommonDao dao) {
		this.dao = dao;
	}

	public ProductsExtensionDao getProductsExtensionDao() {
		return productsExtensionDao;
	}

	public void setProductsExtensionDao(ProductsExtensionDao productsExtensionDao) {
		this.productsExtensionDao = productsExtensionDao;
	}

	public int update(Products product) {
		return dao.update(product);
	}

	public Integer insert(Products product) {
		return dao.insert(product);
	}

	public int delete(Products product) {
		return dao.delete(product);
	}

	public Products getProducts(Integer id) {
		return (Products) dao.getEntity(id);
	}
	
	public List<Products> getAllProducts() {
		return (List<Products>) dao.getAllEntity();
	}

	public List<Products> getProductsDynamic(Products product) {
		return (List<Products>) dao.getEntityDynamic(product);
	}
	
	/*Extension Methods*/
	public List<Products> getLatestProductsList() {
		return (List<Products>) productsExtensionDao.getLatestProductsList();
	}
	public List<Products> getFeaturedProductsList() {
		return (List<Products>) productsExtensionDao.getFeaturedProductsList();
	}
	public List<Products> getUpcomingProductsList() {
		return (List<Products>) productsExtensionDao.getUpcomingProductsList();
	}
	public List<Products> getCategoryWiseProductList(Categories categories) {
		return (List<Products>) productsExtensionDao.getCategoryWiseProductList(categories);
	}
	public List<Products> getSearchResults(String searchCriteria) {
		return (List<Products>) productsExtensionDao.getSearchResults(searchCriteria);
	}
	public List<Products> getTopSaleProductsList() {
		return (List<Products>) productsExtensionDao.getTopSaleProductsList();
	}
	public List<BigDecimal> getTopSaleProductsIdList() {
		return (List<BigDecimal>) productsExtensionDao.getTopSaleProductsIdList();
	}
	public List<ProductImages> getProductImagesListByProduct(Products products) {
		return (List<ProductImages>) productsExtensionDao.getProductImagesListByProduct(products);
	}
}
