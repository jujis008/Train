package com.qf.test;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qf.pojo.Order;
import com.qf.pojo.User;
import com.qf.utils.HibernateUtils;
/**
 * 一对多注解级联总结：
 * 如果是只有多方来维护外键 要爱多方上加个@JoinColumn(name="uid")//@JoinColumn 外键的注解   name="uid" 外键名  ，
 * 并且一方上要有mappedBy属性  	@OneToMany(mappedBy="user")
 * 
 * 如果对多双方都想维护外键：
 * 	在一方和多方上都加上@JoinColumn(name="uid")  注意 两方的name值一样，并且并且一方上不能有mappedBy属性 
 * 
 * 
 * 
 * 
 * @author tomcat
 *
 */
public class TestOneToMany {
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
	 * 级联保存
	 * 保存用户的时候级联保存订单    
	 * 保存订单的时候  去级联保存用户
	 */
	@Test
	public void run1(){
		User u=new User();
		u.setUname("张三");
		
		Order o1=new Order();
		Order o2=new Order();
		
		o1.setOname("红楼梦");
		
		o2.setOname("西游记");
		
		//把订单和用户关联
		u.getOrderSet().add(o1);
		u.getOrderSet().add(o2);
		
		session.save(u);//级联好使  只不过一方不维护外键
		
	}
	
	
	/**
	 * 级联保存
	 * 保存用户的时候级联保存订单    
	 * 保存订单的时候  去级联保存用户
	 */
	@Test
	public void run2(){
		User u=new User();
		u.setUname("张三");
		
		Order o1=new Order();
		Order o2=new Order();
		
		o1.setOname("红楼梦");
		
		o2.setOname("西游记");
		
		//把订单和用户关联
		o1.setUser(u);
		o2.setUser(u);
		
		session.save(o1);//外键有值  订单表维护外键
		session.save(o2);
		
	}
	
	/**
	 * 级联删除多方
	 */
	@Test
	public void run3(){
	User user = session.get(User.class, 2L);
	
	session.delete(user);
		
	}
	/**
	 * 
	 * Gson:hibernate双向关联  json解析出现互相循环引用导致内存溢出
	 * 
	 * 
	 */
	@Test
	public  void  run4(){
		//User user = session.get(User.class, 3L);
		
		//session.get(Order.c, arg1)
		
		List list = session.createQuery("from Order").list();
		
		Gson g=new Gson();
		String json = g.toJson(list);
		System.out.println(json);
		
		
	}
	/**
	 * setDateFormat("yyyy-MM-dd HH:mm:ss")  格式化日期
	 * @Expose注解
	 * 
	 */
	@Test
	public  void  run5(){
		//User user = session.get(User.class, 3L);
		
		//session.get(Order.c, arg1)
		
		List list = session.createQuery("from Order").list();
		
		//Gson g=new Gson();
		Gson g=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String json = g.toJson(list);
		System.out.println(json);
		
		
	}

}
