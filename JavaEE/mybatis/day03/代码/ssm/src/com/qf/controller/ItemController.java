package com.qf.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qf.pojo.ItemsCustom;
import com.qf.service.ItemService;

@Controller
public class ItemController {
	
	@Resource(name="itemServiceImpl")
	private ItemService itemService;
	
	
	@RequestMapping("/items")
	public  ModelAndView  findAllItems(){
		ModelAndView mav=new ModelAndView();
		
		List<ItemsCustom> ItemList = itemService.selectItems();
		
		mav.addObject("itemList", ItemList);
		mav.setViewName("itemList");
		
		return mav;
		
	}

}
