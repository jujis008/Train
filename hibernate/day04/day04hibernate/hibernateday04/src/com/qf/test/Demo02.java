package com.qf.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qf.pojo.Order;
import com.qf.pojo.User;
import com.qf.utils.HibernateUtils;
/**
 * hql之多表查询
 * sql:
 * 		笛卡尔积：缺少条件的的多表查询  尽量避免出现
 * 		内连接：显示符合条件的数据
 * 			1.显式内连接  inner join  on
 * 			2.隐式内连接  where 条件
 * 
 * 		外链接：
 * 			1.左外连接  left outer join   on  
 * 			2.右外链接  right  outer  join  on
 * 
 * 		自连接
 * 
 * 
 * hql
 * 
 * 
 * @author tomcat
 *
 */
public class Demo02 {
	
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
	 * 左外连接  
	 * right outer join  返回是两个表的结果集  List<Object[]>
	 * 
	 * 迫切左外连接      会把一方的数据封装到另外一方里面
	 * from User u right outer join  fetch u.orderSet
	 */
	@Test
	public void run5(){
	Query query = session.createQuery("from User u left outer join u.orderSet");
	
	List<Object[]> list = query.list();
	for(Object[] o:list){
		System.out.println(Arrays.toString(o));
		
	}
	
	}
	
	/**
	 * 左外连接  
	 * left outer join  返回是两个表的结果集  List<Object[]>List<Object[]>
	 * 
	 * 迫切左外连接      会把一方的数据封装到另外一方里面
	 * from User u left outer join  fetch u.orderSet
	 */
	@Test
	public void run4(){
	Query query = session.createQuery("from User u left outer join u.orderSet");
	
	List<Object[]> list = query.list();
	for(Object[] o:list){
		System.out.println(Arrays.toString(o));
		
	}
	
	System.out.println(list);
		
	}
	
	
	/**
	 * hql:2.显示内连接  
	 * from User u inner join u.orderSet结果集是一个List<Object[]>
	 * 
	 * 迫切内连接
	 * from User u inner join fetch  u.orderSet
	 * 结果集是List<User>    
	 */
	@Test
	public void run3(){
	//Query query = session.createQuery("from user u inner join  u.orderSet ");
	Query query = session.createQuery("from User u inner join fetch  u.orderSet ");
	//Query query = session.createQuery("from Order o inner join o.user ");
	//Query query = session.createQuery("from Order");
	
	
	
	List<User> list = query.list();
	
	/*for(Object[] o:list){
		System.out.println(Arrays.toString(o));
		
	}*/
	
	System.out.println(list);
		
	}
	
	
	/**
	 * hql:2.隐式内连接  where 条件
	 */
	@Test
	public void run2(){
	Query query = session.createQuery("from User u,Order o where u=o.user");
	
	List<Object[]> list = query.list();
	for(Object[] o:list){
		System.out.println(Arrays.toString(o));
		
	}
	
	System.out.println(list);
		
	}
	

	/**
	 * hql:笛卡尔积
	 */
	@Test
	public void run1(){
	Query query = session.createQuery("from User u,Order o");
	
	List<Object[]> list = query.list();
	for(Object[] o:list){
		System.out.println(Arrays.toString(o));
		
	}
	
	System.out.println(list);
		
	}
}
