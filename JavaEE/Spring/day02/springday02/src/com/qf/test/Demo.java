package com.qf.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/qf/test/applicationContext.xml")//加载spring的配置文件
public class Demo {
	
	@Resource(name="userService")//注入service
	private UserService userService;
	@Test
	public void run1(){
		/*String path="com/qf/test/applicationContext.xml";
		//加载配置文件
		ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext(path);*/
		
		/*UserService bean = ac.getBean("userService",UserService.class);
		bean.say();*/
		
		userService.say();
		
	}

}
