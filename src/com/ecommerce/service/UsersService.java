package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dao.CommonDao;
import com.ecommerce.dao.UsersExtensionDao;
import com.ecommerce.dao.UsersHibernateDao;
import com.ecommerce.model.Countries;
import com.ecommerce.model.Users;

public class UsersService {
	CommonDao dao;
	UsersExtensionDao usersExtensionDao;
	
	public CommonDao getDao() {
		return dao;
	}

	public void setDao(CommonDao dao) {
		this.dao = dao;
	}

	public UsersExtensionDao getUsersExtensionDao() {
		return usersExtensionDao;
	}

	public void setUsersExtensionDao(UsersExtensionDao usersExtensionDao) {
		this.usersExtensionDao = usersExtensionDao;
	}

	public List<Users> getAllUsers() {
		return (List<Users>) dao.getAllEntity();
	}

	public Users getUsers(Integer id) {
		return (Users)dao.getEntity(id);
	}

	public int update(Users user) {
		return dao.update(user);
	}

	public Integer insert(Users user) {
		return dao.insert(user);
	}

	public int delete(Users user) {
		return dao.delete(user);
	}

	public List<Users> getUsersDynamic(Users user) {
		return (List<Users>) dao.getEntityDynamic(user);
	}
	
	public Users getUserByEmail(String email) {
		return usersExtensionDao.getUserByEmail(email);
	}
	
	public boolean isEmailExists(String email) {
		return usersExtensionDao.isEmailExists(email);
	}
}
