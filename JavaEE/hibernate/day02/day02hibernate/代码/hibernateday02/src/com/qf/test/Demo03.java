package com.qf.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.qf.pojo.User;
import com.qf.utils.HibernateUtils;

/**
 * 一级缓存
 * @author tomcat
 *
 */
public class Demo03 {
	
	/**
	 * 验证一级缓存的存在:
	 * 
	 */
	@Test
	public void run1(){
		Session session = HibernateUtils.openSession();
		
		Transaction ts = session.beginTransaction();
		
		User user = session.get(User.class, 1L);// 发送一条select语句
		System.out.println(user);
	
		User user1 = session.get(User.class, 1L);// 发送一条select语句
		System.out.println(user1);
		
		System.out.println(user==user1);

		ts.commit();
		session.close();
	}
	
	
	@Test
	public void run2(){
		Session session = HibernateUtils.openSession();
		
		Transaction ts = session.beginTransaction();
		
		User user = session.get(User.class, 1L);// 发送一条select语句
		System.out.println(user);
		user.setUname("小泽姐");
		ts.commit();//会发送一条select语句
		session.close();
	}
	
	@Test
	public void run3(){
		Session session = HibernateUtils.openSession();	
		Transaction ts = session.beginTransaction();		
		User user = session.get(User.class, 1L);// 发送一条select语句
		System.out.println(user);
		ts.commit();//不会发送一条select语句
		session.close();
	}

	
	@Test
	public void run4(){
		Session session = HibernateUtils.openSession();
		
		Transaction ts = session.beginTransaction();
		
		User user = session.get(User.class, 1L);// 发送一条select语句
		System.out.println(user);
	
		user.setUname("XXX");
		user.setUname("QQQ");
		

		ts.commit();//会发送1条update语句
		session.close();
	}
	
	@Test
	public void run5(){
		Session session = HibernateUtils.openSession();
		
		Transaction ts = session.beginTransaction();
		
		User u=new User();//瞬时态
		u.setUid(4L);//游离态
		u.setUname("XXX");//游离态
		session.update(u);//持久态
		ts.commit();//？？？ 发送update语句
		session.close();
	}
	
	/**
	 * 
	 * hql语句查询到的数据默认不放进缓存
	 */
	
	@SuppressWarnings("unchecked")
	@Test
	public void run6(){
		Session session = HibernateUtils.openSession();
		
		Transaction ts = session.beginTransaction();
		
		Query query = session.createQuery("from User");
		
		List<User> list = query.list();//发送一条select语句
		System.out.println(list);
		List<User> list1 = query.list();//发送一条select语句
		
		System.out.println(list1);
		
		ts.commit();//？？？ 发送update语句
		session.close();
	}
	
}
