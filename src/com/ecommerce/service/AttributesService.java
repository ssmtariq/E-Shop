package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dao.CommonDao;
import com.ecommerce.model.Attributes;

public class AttributesService {
CommonDao dao;
	
	public CommonDao getDao() {
		return dao;
	}

	public void setDao(CommonDao dao) {
		this.dao = dao;
	}

	public List<Attributes> getAllAttributes() {
		return (List<Attributes>) dao.getAllEntity();
	}

	public Attributes getAttributes(Integer id) {
		return (Attributes)dao.getEntity(id);
	}

	public int update(Attributes attribute) {
		return dao.update(attribute);
	}

	public Integer insert(Attributes attribute) {
		return dao.insert(attribute);
	}

	public int delete(Attributes attribute) {
		return dao.delete(attribute);
	}

	public List<Attributes> getAttributesDynamic(Attributes attribute) {
		return (List<Attributes>) dao.getEntityDynamic(attribute);
	}
}
