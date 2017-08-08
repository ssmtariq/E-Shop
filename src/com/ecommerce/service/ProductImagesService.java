package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dao.CommonDao;
import com.ecommerce.model.ProductImages;

public class ProductImagesService {
	CommonDao dao;

	public CommonDao getDao() {
		return dao;
	}

	public void setDao(CommonDao dao) {
		this.dao = dao;
	}

	public Integer insert(ProductImages productImages) {
		return dao.insert(productImages);
	}

	public int update(ProductImages productImages) {
		return dao.update(productImages);
	}

	public Integer delete(ProductImages productImages) {
		return dao.delete(productImages);
	}

	public ProductImages getProductImages(Integer id) {
		return (ProductImages) dao.getEntity(id);
	}
	
	public List<ProductImages> getAllProductImages() {
		return (List<ProductImages>) dao.getAllEntity();
	}

	public List<ProductImages> getProductImagesDynamic(ProductImages productImages) {
		return (List<ProductImages>) dao.getEntityDynamic(productImages);
	}
}
