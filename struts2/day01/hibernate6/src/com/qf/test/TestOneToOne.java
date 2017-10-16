package com.qf.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qf.pojo.Card;
import com.qf.pojo.Person;
import com.qf.utils.HibernateUtils;

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
	
	
	@Test
	public void run1(){
		Person p=new Person();
		p.setPname("小苍");
		
		Card card=new Card();
		
		card.setName("美女卡~~");
		
		card.setPerson(p);
		
		session.save(card);
		
	}

}
