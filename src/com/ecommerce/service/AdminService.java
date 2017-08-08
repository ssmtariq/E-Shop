package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dao.AdminExtensionDao;
import com.ecommerce.dao.CommonDao;
import com.ecommerce.dao.UsersExtensionDao;
import com.ecommerce.model.Admin;
import com.ecommerce.model.Users;

public class AdminService {
	CommonDao dao;
	AdminExtensionDao adminExtensionDao;

	public CommonDao getDao() {
		return dao;
	}

	public void setDao(CommonDao dao) {
		this.dao = dao;
	}

	public AdminExtensionDao getAdminExtensionDao() {
		return adminExtensionDao;
	}

	public void setAdminExtensionDao(AdminExtensionDao adminExtensionDao) {
		this.adminExtensionDao = adminExtensionDao;
	}

	public Integer update(Admin admin) {
		return dao.update(admin);
	}

	public Integer insert(Admin admin) {
		return dao.insert(admin);
	}

	public Integer delete(Admin admin) {
		return dao.delete(admin);
	}

	public Admin getAdmin(Integer id) {
		return (Admin) dao.getEntity(id);
	}
	
	public List<Admin> getAllAdmin() {
		return (List<Admin>) dao.getAllEntity();
	}
	
	public List<Admin> getAdminDynamic(Admin admin) {
		return (List<Admin>) dao.getEntityDynamic(admin);
	}

	public Admin getAdminByEmail(String email) {
		return adminExtensionDao.getAdminByEmail(email);
	}
}
