package com.qf.jdbc;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/qf/jdbc/applicationContext.xml")
public class Demo02 {
	
	@Resource(name="userDao")
	private UserDao userDao;
	
	@Test
	public void run(){
		int add = userDao.add("insert into user(uname,upwd) values(?,?)", "蜡笔小新","xm123");
		
		System.out.println(add);
	}
	
	

}
