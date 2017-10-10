package com.qf.test;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.qf.pojo.User;
import com.qf.pojo.User2;
import com.qf.utils.HibernateUtils;

public class Demo01 {
	@Test
	public void run1(){
		//每次获得的都是新的session会话
		Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		
		User2 u=new User2();
		User u1=new User();
		User u2=new User();
		u.setUid("123abc");
		u1.setUname("哈哈哈哈");
		
		Serializable id = session.save(u1);//save方法生成id 和insert into 语句
		//主键不能被修改
		//u.setUid("123abc");
		
		
		ts.commit();
		session.close();
		
	}

}
