package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.ecommerce.model.Users;

public class UsersHibernateDao implements CommonDao{
	private SessionFactory sessionFactory;
	
	public UsersHibernateDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Integer insert(Object object) {
		Users user = (Users) object;
		Transaction transaction = null;
		Session session = null;
		Integer i = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			i = (Integer) session.save(user);
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
		Users user = (Users) object;
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(user);
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
		Users user = (Users) object;
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			session.delete(user);
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
	public Users getEntity(Integer id) {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			return (Users) session.get(Users.class, id);
		} finally {

			transaction.commit();
			session.close();
		}
	}

	@Override
	public List<Users> getAllEntity() {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			List list = session.createQuery("from Users").list();
			return list;
		} finally {
			transaction.commit();
			session.close();
		}
	}

	@Override
	public List<Users> getEntityDynamic(Object object) {
		Users user = (Users) object;
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Users.class);
		if (user.getFirstName() != null && (!user.getFirstName().isEmpty())) {
			Criterion crit1 = Restrictions.like("firstName",
					"%" + user.getFirstName() + "%");
			Criterion crit2 = Restrictions.like("lastName",
					"%" + user.getFirstName() + "%");
			criteria.add(Restrictions.or(crit1, crit2));
		}
		if (user.getMobileNo() != null && (!user.getMobileNo().isEmpty()))
			criteria.add(Restrictions.ge("mobileNo", user.getMobileNo()));

		try {
			return criteria.addOrder(Property.forName("id").desc()).setMaxResults(10).list();
		} finally {
			transaction.commit();
			session.close();
		}
	}

}
