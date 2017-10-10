package com.qf.test;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.qf.pojo.User;
import com.qf.utils.HibernateUtils;

/**
 * 持久化对象的三种转化关系
 * 瞬时态：没有oid 没有被session管理
 * 持久态：有oid 有被session管理
 * 游离态：有oid 没有被session管理
 * @author tomcat
 *
 */
public class Demo02 {
	
	
	/**
	 * 瞬时态转持久态
	 */
	@Test
	public void run1(){
		Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		
		User u=new User();//瞬时态
		u.setUname("小泽老师");//瞬时态
		u.setUgender("女");//瞬时态
		u.setBirthday(new Date());//瞬时态
		u.setUpwd("xj123");//瞬时态
		
		Serializable id = session.save(u);//save() 1.获取oid  2.发送insert into语句   持久态  
		
		u.setUname("小苍老师");
		ts.commit();
		session.close();
	}
	
	/**
	 * 持久态转游离态
	 */
	@Test
	public void run2(){
		Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		
		User user = session.get(User.class, 1L);//持久态
		 
		session.evict(user);//把user对象和session解除关系  
		
		user.setUname("小泽他姐");//游离态
		
		
		session.update(user);
		
		
		
		ts.commit();
		session.close();//游离态
	}
	
	/**
	 * 持久态 有oid  有被session管理
	 * 转瞬时态  
	 */
	@Test
	public void run3(){
		Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		
		User user = session.get(User.class, 1L);//持久态
		 
		session.evict(user);//把user对象和session解除关系  
		
		user.setUname("小泽他姐");//游离态
		
		
		user.setUid(null);//瞬时态
		
		user.setUname("小泽他妹");
		
		session.save(user);//持久态
		
		ts.commit();
		session.close();//游离态
	}
	
	/**
	 * 瞬时态 没有oid 没有被session管理
	 * 游离态 有oid 没有被session管理
	 */
	@Test
	public void run4(){
		Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		
		User u=new User();//瞬时态
		u.setUname("小泽老师");//瞬时态
		u.setUgender("女");//瞬时态
		u.setBirthday(new Date());//瞬时态
		u.setUpwd("xj123");//瞬时态
		
		u.setUid(1L);//游离态
		
		u.setUname("小泽她二姨");//游离态
		
		
		session.update(u);
		
		ts.commit();
		session.close();
	}
	
	
	/**
	 * 游离态 有oid 没有被session管理
	 * 转
	 * 瞬时态 没有oid 没有被session管理
	 * 
	 */
	@Test
	public void run5(){
		Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		
		User user = session.get(User.class, 1L);//持久态
		session.clear();//把session管理的对象全部清空   游离态
		
		user.setUid(null);
		
		ts.commit();
		session.close();
	}
	
	
	/**
	 * 游离态 有oid 没有被session管理
	 * 转
	 * 持久态 有oid 有被session管理
	 * 
	 */
	@Test
	public void run6(){
		Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		
		User user = session.get(User.class, 1L);//持久态
		session.clear();//把session管理的对象全部清空   游离态
		
		user.setUname("小泽妹");//游离态
		
		session.saveOrUpdate(user);//持久态
		
		
		ts.commit();
		session.close();
	}
	/**
	 * 持久态对象不能更改oid
	 */
	@Test
	public void run7(){
		Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		
		User user = session.get(User.class, 1L);//持久态
		user.setUid(222L);
		
		
		ts.commit();
		session.close();
	}
	
	/**
	 * 持久态对象有直接更新数据到数据库的能力
	 */
	@Test
	public void run8(){
		Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		
		User user = session.get(User.class, 1L);//持久态
		//user.setUid(222L);
		user.setUname("小泽妹1");
		
		ts.commit();
		session.close();
	}
}
