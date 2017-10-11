package com.qf.manytomany;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qf.utils.HibernateUtils;

public class TestManyToMany {
	Session session =null;
	Transaction ts=null;
	
	/**
	 * 执行该类的任意一个单元测试方法之前  都会执行该方法
	 */
	@Before
	public void pre(){
		session = HibernateUtils.getCurrentSession();
		ts = session.beginTransaction();
		
	}
	/**
	 * 执行该类的任意一个单元测试方法之后  都会执行该方法
	 */
	@After
	public void after(){	
		ts.commit();
	
	}
	/**
	 * 多对多之解除关系
	 * 一对多解除关系外键置为null
	 * 多对多解除关系 从中间表中删除数据
	 */
	@Test
	public void run5(){
		Teacher teacher = session.get(Teacher.class, 3L);
		Student student = session.get(Student.class, 3L);
		
		teacher.getStudentSet().remove(student);
		
		
		
	}
	
	/**
	 * 多对多之级联删除： 慎用   
	 */
	@Test
	public void run4(){
		Student student = session.get(Student.class, 3L);
		
		System.out.println(student);
		session.delete(student);
		
	}
	
	
	
	/**
	 * 保存学生级联保存老师
	 */
	@Test
	public void run3(){
		Teacher t1=new Teacher();
		Teacher t2=new Teacher();
		t1.setTname("小泽老师");
		t1.setSex("女");
		
		t2.setTname("加藤老师");
		t2.setSex("男");
		
		
		Student s1=new Student();
		Student s2=new Student();
		
		

		//保存
		session.save(t1);
		session.save(t2);
		
		
	}
	
	
	/**
	 * 多对多之级联保存：
	 * 可以保存学生的时候去级联保存老师
	 * 可以保存老师的时候去级联保存学生
	 */
	@Test
	public void run2(){
		Teacher t1=new Teacher();
		Teacher t2=new Teacher();
		t1.setTname("小泽老师");
		t1.setSex("女");
		
		t2.setTname("加藤老师");
		t2.setSex("男");
		
		
		Student s1=new Student();
		Student s2=new Student();
		
		s1.setSname("诸葛亮");
		s1.setSex("男");
		
		s2.setSname("阿珂");
		s2.setSex("女");
		
		
		//建立关系
		
		t1.getStudentSet().add(s1);
		t1.getStudentSet().add(s2);
		
		t2.getStudentSet().add(s2);
		

		//保存
		session.save(t1);
		session.save(t2);
		
		
	}
	
	
	
	/**
	 * 测试多对多之双向关联
	 * 对多对会生成一个中间表，这个中间表用来描述他们之间的关系  默认双方都维护外键    多对多双向关联必须要有一方来牺牲一下，
	 * 放弃对外键的维护。哪一方操作的少  哪一方放弃对外间的维护
	 * 
	 */
	@Test
	public void run1(){
		Teacher t1=new Teacher();
		Teacher t2=new Teacher();
		t1.setTname("小泽老师");
		t1.setSex("女");
		
		t2.setTname("加藤老师");
		t2.setSex("男");
		
		
		Student s1=new Student();
		Student s2=new Student();
		
		s1.setSname("诸葛亮");
		s1.setSex("男");
		
		s2.setSname("阿珂");
		s2.setSex("女");
		
		
		//建立关系
		
		t1.getStudentSet().add(s1);
		t1.getStudentSet().add(s2);
		
		t2.getStudentSet().add(s2);
		
		
		
		s1.getTeacherSet().add(t1);
		
		s2.getTeacherSet().add(t1);
		
		s2.getTeacherSet().add(t2);
		
		
		//保存
		session.save(t1);
		session.save(t2);
		session.save(s1);
		session.save(s2);
		
	}

}
