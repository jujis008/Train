package com.qf.l_annotions;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotions {
	
	@Test
	public void run1(){
		String path="com/qf/l_annotions/applicationContext.xml";
		ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext(path);
		UserAction bean = ac.getBean("userAction",UserAction.class);
		UserAction bean1 = ac.getBean("userAction",UserAction.class);
		System.out.println(bean);
		System.out.println(bean1);
		bean.execute();
		ac.close();
	}

}
