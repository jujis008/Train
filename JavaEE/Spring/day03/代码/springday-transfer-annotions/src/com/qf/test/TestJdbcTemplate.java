package com.qf.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qf.dao.UserDao;
import com.qf.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestJdbcTemplate {
	@Resource(name="userDao")
	private UserDao userDao;
	@Test
	public void run1(){
		
		userDao.add("insert into user(uname,upwd) values(?,?)", "流川枫","qwe");
	}
	@Test
	public void run2(){
		
		userDao.delete(24L);
	}
	@Test
	public void run3(){
		
		List<User> list = userDao.queryALl();
		System.out.println(list);
	}
	@Test
	public void run4(){
		
		User list = userDao.queryById(1L);
		System.out.println(list);
	}
	
	@Test
	public void run5(){
		
	List<User> user = userDao.queryByOthers("select * from user where uname=? and upwd=?", "jack","123");
		System.out.println(user);
	}
}
