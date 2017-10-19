package com.qf.dao.impl;

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

}
