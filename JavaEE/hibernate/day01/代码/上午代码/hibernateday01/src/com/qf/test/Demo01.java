package com.qf.test;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.qf.pojo.Users;

public class Demo01 {
	
	
	
	@Test
	public void run1(){
		//1.读取hibernate的配置文件
		
		Configuration cfg=new Configuration();
		//读取配置文件
		cfg.configure();//默认会去src的目录下找hibernate.cfg.xml的配置文件
		//SessionFactory  就相当于咱们第二阶段学习的Datasource数据源
		//2.获得SessionFactory工厂
		SessionFactory factory = cfg.buildSessionFactory();
		//session相当于 连接Connection
		//3.获得session对象
		Session session = factory.openSession();
		//4.开启事务
		Transaction ts = session.beginTransaction();
		
		Users u=new Users();
		u.setUname("jack");
		u.setUgender("男");
		u.setUpwd("jack123");
		
		//保存
		Serializable id = session.save(u);
		
		System.out.println(id);
		
		
		
		//5.提交事务
		ts.commit();
		//6.释放医院
		session.close();
		factory.close();
		
		
	}

}
