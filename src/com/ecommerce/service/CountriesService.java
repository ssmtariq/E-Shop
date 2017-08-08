package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dao.CommonDao;
import com.ecommerce.model.Countries;

public class CountriesService {
	CommonDao dao;
	
	public CommonDao getDao() {
		return dao;
	}

	public void setDao(CommonDao dao) {
		this.dao = dao;
	}

	public List<Countries> getAllCountries() {
		return (List<Countries>) dao.getAllEntity();
	}

	public Countries getCountries(Integer id) {
		return (Countries)dao.getEntity(id);
	}

	public int update(Countries country) {
		return dao.update(country);
	}

	public Integer insert(Countries country) {
		return dao.insert(country);
	}

	public int delete(Countries country) {
		return dao.delete(country);
	}

	public List<Countries> getCountriesDynamic(Countries country) {
		return (List<Countries>) dao.getEntityDynamic(country);
	}

}
