package com.qf.test;

import javax.persistence.JoinTable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qf.pojo.Student;
import com.qf.pojo.Teacher;
import com.qf.utils.HibernateUtils;
/**
 * 多对多注解：
 * 要想实现双向关联  只需要在其中一方配置上@JoinTable注解，并且另外一方要加上mappedBy属性
 * 
 * 级联保存
 * 
 * 
 * @author tomcat
 *
 */
public class TestManyToMany {
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
	 * 测试级联双向保存：如果双方都配置@JoinTable表示双方都维护外键，
	 * 双向保存会报错。
	 * 
	 * 
	 */
	@Test
	
	public void run1(){
		Teacher t1=new Teacher();
		Teacher t2=new Teacher();
		
		t1.setTname("小张");
		t2.setTname("小李");
		
		Student s1=new Student();
		Student s2=new Student();
		
		s1.setSname("小黑");
		s2.setSname("小白");
		
		//做关联  双向
		t1.getStudentSet().add(s1);
		t1.getStudentSet().add(s2);
		
		s1.getTeacherSet().add(t1);
		//s1.getTeacherSet().add(t2);
		
		//s2.getTeacherSet().add(t2);
		s2.getTeacherSet().add(t1);
		
	
		session.save(t1);
		//session.save(t2);
		session.save(s1);
		session.save(s2);
		
		
		
		
	}
	/**
	 * 一对多之级联保存
	 * 
	 */
		@Test
	public void run2(){
		Teacher t1=new Teacher();
		Teacher t2=new Teacher();
		
		t1.setTname("小张");
		t2.setTname("小李");
		
		Student s1=new Student();
		Student s2=new Student();
		
		s1.setSname("小黑");
		s2.setSname("小白");
		
		//做关联  双向
		t1.getStudentSet().add(s1);
		t1.getStudentSet().add(s2);
		
		//s1.getTeacherSet().add(t1);
		//s1.getTeacherSet().add(t2);
		
		//s2.getTeacherSet().add(t2);
		//s2.getTeacherSet().add(t1);
		
	
		session.save(t1);
		//session.save(t2);
		//session.save(s1);
		//session.save(s2);
		
		
		
		
	}

}
