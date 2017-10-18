package com.qf.test;

import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qf.pojo.User;
import com.qf.util.HibernateUtils;



public class Demo01 {
	
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

	
	@Test
	public  void run1(){
		
		/**
		 * hibernate 处理悲观锁   共享锁  排它锁
		 */
		//session.get(User.class, 1L,LockOptions.UPGRADE);
		//session.get(User.class, 1L,LockMode.);
		
		//session .createQuery("from User").setLockOptions(LockOptions.READ)
		
		
	}
	
	
	@Test
	public  void run2(){
		
		/**
		 * hibernate 处理乐观锁
		 */
		
		User u=new User();
		u.setUname("李二狗");
		
		session.save(u);
		
		
	}
	
	@Test
	public  void run3(){
		
		/**
		 * hibernate 处理乐观锁
		 */
		User user = session.get(User.class, 1L);
		user.setUname("李二狗他爹");
		
		
		
		
	}
}
