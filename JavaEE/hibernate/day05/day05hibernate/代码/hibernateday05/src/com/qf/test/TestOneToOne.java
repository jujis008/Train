package com.qf.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qf.pojo.Card;
import com.qf.pojo.Person;
import com.qf.util.HibernateUtils;

public class TestOneToOne {

	
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
	 * 一对第一操作外键所在表比较方方便
	 */
	
	@Test
	public  void run1(){
		Person p=new Person();
		p.setPname("隔壁老王~~~");
		
		Card c=new Card();
		
		c.setCname("好人卡~~~");
		
		p.setCard(c);
		c.setPerson(p);
		
		
		session.save(p);//外键没值
	}
	
	@Test
	public  void run2(){
		Person p=new Person();
		p.setPname("隔壁老王~~~");
		p.setSex("女");
		Card c=new Card();
		
		c.setCname("好人卡~~~");
		
	
		c.setPerson(p);
		
		
		session.save(c);//外键没值
	}
	
	@Test
	public  void run3(){
		Person p=new Person();
		p.setPname("隔壁老王~~~");
		p.setSex("女");
		Card c=new Card();
		
		c.setCname("好人卡~~~");
		
	
		c.setPerson(p);//保存外键所在方去级联保存另一方
		
		
		session.save(c);//
	}
	
	
	@Test
	public  void run4(){
		Person p=new Person();
		p.setPname("隔壁老王~~~");
		p.setSex("女");
		Card c=new Card();
		
		c.setCname("好人卡~~~");
		
	
		p.setCard(c);//p和c做关联  但是p不维护外键  导致只有person会保存 card不会保存
		
		c.setPerson(p);
		
		session.save(p);//  
	}
	
}
