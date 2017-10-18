package com.qf.cache;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qf.pojo.User;
import com.qf.utils.HibernateUtils;

public class TestCache {

	Session session=null;
	Transaction ts=null;
	
	@Before
	public void pre(){
		session=HibernateUtils.getCurrentSession();
		ts=session.beginTransaction();
		
	}
	
	@After
	public void after(){
		ts.commit();
		
	}
	/**
	 * get()/load()  自动存进一级缓存和二级缓存
	 * 
	 * 验证二级缓存的存在
	 */	
	@Test
	public void run1(){
		
		User user = session.get(User.class, 1L);
		
		System.out.println(user);
		session.clear();//清空一级缓存
		
		User user1 = session.get(User.class, 1L);
		System.out.println(user1);

	}
	
	/**
	 *  session.createQuery("from User").setCacheable(true);
	 * get()/load()
	 * hql  qbc  默认不进二级缓存
	 * 
	 * 验证二级缓存的存在
	 */	
	@Test
	public void run2(){
		//
		Query query = session.createQuery("from User").setCacheable(true);
		
		
		List list = query.list();
		System.out.println(list);
		
		session.clear();//清空一级缓存
		Query query1 = session.createQuery("from User").setCacheable(true);
		
		List list1 = query1.list();
		System.out.println(list1);

	}

}
