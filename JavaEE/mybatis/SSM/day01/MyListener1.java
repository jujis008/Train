package com.qf.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.qf.pojo.ItemsCustom;
import com.qf.service.ItemService;

public class MyListener1 implements ServletContextListener{

	/*@Autowired
	private ItemService itemService;*/
	

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//spring给提供的工具类  WebApplicationContextUtils
		ItemService itemService = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext()).getBean("itemServiceImpl",ItemService.class);
		
		// TODO Auto-generated method stub
		List<ItemsCustom> selectItems = itemService.selectItems();
		System.out.println(selectItems);
	
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
