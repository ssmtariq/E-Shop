package com.ecommerce.dao;

import java.util.List;

public interface CommonDao {
	public Integer insert(Object object);
    
    public int update(Object object);

    public int delete(Object object);
    
    public Object getEntity(Integer id);
	
    public List<?> getAllEntity();

    public List<?> getEntityDynamic(Object object);
}
