package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dao.CategoriesExtensionDao;
import com.ecommerce.dao.CommonDao;
import com.ecommerce.model.Categories;

public class CategoriesService {

	CommonDao dao;
	
	CategoriesExtensionDao categoriesExtensionDao;

	public CommonDao getDao() {
		return dao;
	}

	public void setDao(CommonDao dao) {
		this.dao = dao;
	}

	public CategoriesExtensionDao getCategoriesExtensionDao() {
		return categoriesExtensionDao;
	}

	public void setCategoriesExtensionDao(
			CategoriesExtensionDao categoriesExtensionDao) {
		this.categoriesExtensionDao = categoriesExtensionDao;
	}

	public List<Categories> getAllCategories() {
		return (List<Categories>) dao.getAllEntity();
	}

	public Categories getCategories(Integer id) {
		return (Categories) dao.getEntity(id);
	}

	public int update(Categories category) {
		return dao.update(category);
	}

	public Integer insert(Categories category) {
		return dao.insert(category);
	}

	public int delete(Categories category) {
		return dao.delete(category);
	}

	public List<Categories> getCategoriesDynamic(Categories category) {
		return (List<Categories>) dao.getEntityDynamic(category);
	}
	
	public List<Categories> getNavCategoriesList(){
		return (List<Categories>) categoriesExtensionDao.getNavCategoriesList();
	}
	
	public List<Categories> getCategoryWiseSubcategoryList(Categories category){
		return (List<Categories>) categoriesExtensionDao.getCategoryWiseSubcategoryList(category);
	}
}