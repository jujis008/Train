package com.qf.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/qf/aop/applicationContext.xml")
public class TestAOp {
	@Autowired
	@Qualifier("userService")
	private UserSrvice userService;
	
	@Test
	public void run(){
		userService.add();
		userService.delte();
		userService.update();
		userService.query();
		
	}

}
