package com.qf.onetomany.pojo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.qf.utils.HibernateUtils;

public class TestOneToMany {
	
	/**
	 * hibernate之级联删除  是有方向性的   
	 *   我可以在删除一方的时候去级联删除多方      <set  cascade="delete">      <set  cascade="save-update,delete">  
	 * 
	 * 也可以在删除多方的时候 去级联删除一方  <many-to-one cascade="delete">
	 */
	@Test
	public void run6(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction ts = session.beginTransaction();
		
		Order o = session.get(Order.class, 1L);
		
		session.delete(o);
		
		ts.commit();
	}
	
	
	/**
	 * hibernate之级联删除  是有方向性的   
	 *   我可以在删除一方的时候去级联删除多方      <set  cascade="delete">      <set  cascade="save-update,delete">  
	 * 
	 * 也可以在删除多方的时候 去级联删除一方
	 */
	@Test
	public void run5(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction ts = session.beginTransaction();
		
		User user = session.get(User.class, 3L);
		
		session.delete(user);
		
		ts.commit();
	}
	
	
	/**
	 * hibernate，在有外键的情况下删除一方
	 * hibernate默认会先把外键设置为null  然后再把该条记录删除掉
	 */
	@Test
	public void run4(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction ts = session.beginTransaction();
		
		User user = session.get(User.class, 1L);
		
		session.delete(user);
		
		ts.commit();
	}
	
	
	/**
	 * 保存多方去级联保存一方
	 * 3条sql语句  少了2条更新外键的sql语句
	 */
	@Test
	public void run3(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction ts = session.beginTransaction();
		
		User u=new User();
		u.setUname("赵信");
		u.setUgender("男");
		
		Order o1=new Order();
		o1.setOname("蜡烛");
		o1.setOprice(10.0);
		
		Order o2=new Order();
		o2.setOname("皮鞭");
		o2.setOprice(100.0);
		
		o1.setUser(u);
		o2.setUser(u);
		
		
		session.save(o1);//保存订单级联保存用户
		session.save(o2);
		
		
		ts.commit();
	}
	
	
	
	
	@Test
	/*
	 * 演示：一对多之级联保存  级联保存是有方向性的     
	 * 我可以保存用户的时候去级联保存该用户下的所有订单   保存一方去级联保存多方     <set   cascade="save-update">
	 *  也可以去保存订单的时候  把该订单所属的用户帮我保存了。 保存多方去级联保存一方 <many-to-one cascade="save-update">
	 	5条sql语句
	 */
	public void run2(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction ts = session.beginTransaction();
		
		User u=new User();
		u.setUname("赵信");
		u.setUgender("男");
		
		Order o1=new Order();
		o1.setOname("蜡烛");
		o1.setOprice(10.0);
		
		Order o2=new Order();
		o2.setOname("皮鞭");
		o2.setOprice(100.0);
		
		
		//把订单和用户关联起来
		u.getOrderSet().add(o1);
		u.getOrderSet().add(o2);
		
		//user放弃对外间的维护  不会更新外键  导致order表里的外键是null  
		o1.setUser(u);
		o2.setUser(u);
		
		
		session.save(u);//保存用户级联保存订单
		
		
		ts.commit();
	}
	
	
	@Test
	/*
	 * 演示：一对多之双向关联保存   双向关联要把对象全部保存
	 * 5条sql语句   3条插入  2条更新外键
	 */
	public void run1(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction ts = session.beginTransaction();
		
		User u=new User();
		u.setUname("赵信");
		u.setUgender("男");
		
		Order o1=new Order();
		o1.setOname("蜡烛");
		o1.setOprice(10.0);
		
		Order o2=new Order();
		o2.setOname("皮鞭");
		o2.setOprice(100.0);
		
		//把订单放到user里
		u.getOrderSet().add(o1);
		u.getOrderSet().add(o2);
		
		//把user放到订单里
		o1.setUser(u);
		o2.setUser(u);
		
		session.save(u);
		session.save(o1);
		session.save(o2);
		
		
		ts.commit();
	}

	
}
