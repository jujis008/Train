package com.qf.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qf.dao.UserDao;
import com.qf.pojo.User;
import com.qf.utils.HibernateUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public void save(User user) {
		Session session = HibernateUtils.openSession();
		
		Transaction ts = session.beginTransaction();
		
		session.save(user);
		ts.commit();
		session.close();
	}

	@Override
	public void delete(User user) {
		Session session = HibernateUtils.openSession();
		
		Transaction ts = session.beginTransaction();
		
		session.delete(user);
		ts.commit();
		session.close();
		
	}

	@Override
	public int delete(Long uid) {
		Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		int count = session.createQuery("delete from User where uid=?").setParameter(0, uid).executeUpdate();
		ts.commit();
		session.close();
		return count;
	}

	@Override
	public User queryById(Long uid) {
		Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		User user = session.get(User.class, uid);
		ts.commit();
		session.close();
		return user;
	}

	@Override
	public List<User> queryAll() {
		Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<User> list = session.createQuery("from User").list();
		ts.commit();
		session.close();
		return list;
	}

	@Override
	public void update(User user) {
		Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		session.update(user);
		ts.commit();
		session.close();
		
		
	}

	@Override
	public List<User> queryByOthers(String hql, Object... params) {
		Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery(hql);
		for(int i=0;i<params.length;i++){
			query.setParameter(i, params[i]);
			
		}
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		ts.commit();
		session.close();
		return list;
	
	}
	
	@Override
	public List<Object> queryByOthers1(String hql, Object... params) {
		Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery(hql);
		for(int i=0;i<params.length;i++){
			query.setParameter(i, params[i]);
			
		}
		@SuppressWarnings("unchecked")
		List<Object> list = query.list();
		ts.commit();
		session.close();
		return list;
	
	}
	
	
	
	@Override
	public List<User> queryUserByPage(String hql,int currentPage, int pageSize,Object...params) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setFirstResult((currentPage-1)*pageSize);
		query.setMaxResults(pageSize);
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		
		return list;
	}

}
