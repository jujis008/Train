package com.qf.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qf.pojo.User;
import com.qf.utils.HibernateUtils;

public class Demo03 {
	
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
	 * 原生态的sql语句
	 */
	@Test
	public void run2(){
		
		Query query = session.getNamedQuery("com.qf.pojo.User.xxx");
		
		List list = query.list();
		System.out.println(list);
		
	}
	
	
	/**
	 * 原生态的sql语句
	 */
	@Test
	public void run1(){
		
		SQLQuery query = session.createSQLQuery("select * from tb_user where uname like ?");
		query.setParameter(0, "%赵%");
		query.addEntity(User.class);
		
		//List<Object[]> list = query.list();
		List<User> list = query.list();
		
		System.out.println(list);
		/*for(Object[] o:list){
			System.out.println(Arrays.toString(o));
			
		}*/
		
		
		
		
	}
	
	

}
