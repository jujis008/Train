package com.qf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.qf.pojo.Items;

public class ItemController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		//商品列表
				List<Items> itemsList = new ArrayList<Items>();
				
				Items items_1 = new Items();
				items_1.setName("联想笔记本");
				items_1.setPrice(6000d);
				items_1.setDetail("ThinkPad T430 联想笔记本电脑！");
				
				Items items_2 = new Items();
				items_2.setName("苹果手机");
				items_2.setPrice(5000d);
				items_2.setDetail("iphone6苹果手机！");
				
				itemsList.add(items_1);
				itemsList.add(items_2);
				//ModelAndView 对象  有model  view
				ModelAndView mav=new ModelAndView();
				//就相当于 request.setAttribute("itemsList",itemsList)
				mav.addObject("itemList",itemsList);
				
				//view
				mav.setViewName("/WEB-INF/jsp/itemList.jsp");
				
		
				return mav;
	}

}
