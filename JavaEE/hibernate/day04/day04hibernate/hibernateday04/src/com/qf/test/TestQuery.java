package com.qf.test;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qf.pojo.User;
import com.qf.utils.HibernateUtils;

public class TestQuery {
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
	public void run8(){
		
		//先查询所有用
	
		User user = session.get(User.class, 1L);
		
		
		System.out.println("---------------");
		System.out.println(user.getOrderSet().size());//只是想看长度
		System.out.println(user.getOrderSet());//真正使用数据
		
		
		
		
		
	}
	
	//false		subselect 立即加载集合数据  使用子查询语句
	@Test
	public void run7(){
		
		//先查询所有用
		User user = (User) session.createQuery("from User").list().get(0);
		
		
		
		System.out.println("---------------");
		System.out.println(user.getOrderSet().size());//只是想看长度
		System.out.println(user.getOrderSet());//真正使用数据
		
		
		
		
		
	}
	/**
	 * false		join	 立即去查询集合数据  使用表连接语句  lazy失效了
	 */
	@Test
	public void run6(){
		
		
		//先查询所有用
		User user = session.get(User.class, 1L);
		
		
		
		System.out.println("---------------");
		System.out.println(user.getOrderSet().size());//只是想看长度
		System.out.println(user.getOrderSet());//真正使用数据
		
		
		
		
		
	}
	
	/**
	 * false		select	立即加载集合数据	使用普通select查询语句
	 */
	@Test
	public void run5(){
		
		
		User user = session.get(User.class, 1L);
		
		
		
		System.out.println("---------------");
		System.out.println(user.getOrderSet().size());//只是想看长度
		System.out.println(user.getOrderSet());//真正使用数据
		
		
		
		
		
	}
	
	/**
	 * 
	 * lazy:true		fetch:subselect  
	 * 想看子查询的效果   hql: 
	 * 
	 * 不会立即加载集合数据  当用到集合数据的时候  会发送一条子查询语句
	 * 
	 */
	
	@Test
	public void run4(){
		
		//先查询所有用
		User user = (User) session.createQuery("from User").list().get(0);
		
		
		
		System.out.println("---------------");
		System.out.println(user.getOrderSet().size());//只是想看长度
		System.out.println(user.getOrderSet());//真正使用数据
		
		
		
		
		
	}
	
	
	
	/**
	 * 
	 * lazy:true		fetch:join   
	 * 立即去查询集合数据  使用表连接语句  lazy失效了
	 * 
	 */
	
	@Test
	public void run3(){
		User user = session.get(User.class, 1L);
		System.out.println("---------------");
		System.out.println(user.getOrderSet().size());//只是想看长度
		System.out.println(user.getOrderSet());//真正使用数据
		
		
		
		
		
	}
	
	
	/**
	 * true		select   不会立即加载集合数据，当真正使用集合数据的时候 
	 * 	会发送普通的select语句去查询集合数据
	 */
	
	@Test
	public void run2(){
		User user = session.get(User.class, 1L);
		System.out.println("---------------");
		System.out.println(user.getOrderSet().size());//只是想看长度
		System.out.println(user.getOrderSet());//真正使用数据
		
		
		
		
		
	}
	
	
	/**
	 * 类上的加载策略
	 * lazy="false"
	 */
	@Test
	public void run1(){
		User user = session.load(User.class, 1L);
		System.out.println("---------------");
		System.out.println(user);
		
		
		
		
	}
	

}
