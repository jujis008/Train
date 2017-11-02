package com.qf.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qf.dao.UserDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DemoSM {
	
	@Autowired
	private UserDao userDao;
	

@Test
public void run(){
	int c = userDao.selectCount();
	System.out.println(c);
	
}

}
