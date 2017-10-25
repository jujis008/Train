package com.qf.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qf.service.TransferService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestTransfer {
	@Resource(name="transferService")
	private TransferService transferService;
	@Test
	public void run1(){
		
		boolean flag = transferService.transfer("jack", "rose", 2000.0);
		System.out.println(flag);
	}

}
