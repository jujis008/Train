package com.qf.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.qf.pojo.User;
import com.qf.utils.HibernateUtils;

public class Demo05 {
	
	@Test
	
	public void run1(){
		
		Session session = HibernateUtils.getCurrentSession();
		Session session1 = HibernateUtils.getCurrentSession();
		Session session2 = HibernateUtils.openSession();
		
		/**
		 * hibernate对ThreadLocal 类做封装 给我们提供一个方法 可以直接获取和当前线程绑定的session对象
		 * 
		 */
		System.out.println(HibernateUtils.getCurrentSession1()==HibernateUtils.getCurrentSession1());
		
		System.out.println(session==session2);
		
	}
	
	/**
	 * 获得与当前线程绑定的session   session不用关
	 */
	@Test
	public void run2(){
		
		Session session = HibernateUtils.getCurrentSession();
		Transaction ts = session.beginTransaction();
		
		User u=new User();
		u.setUname("小智~~~");
		
		session.save(u);
		
		
		ts.commit();
		//session.close();
		
	}
	

}
