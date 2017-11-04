package com.qf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qf.pojo.Items;
import com.qf.service.ItemService;
import com.qf.vo.QueryVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private ItemService itemService;
	@RequestMapping("add")
	public String add(){
		
		return "forward:/error.jsp";
	}

	@RequestMapping("/price")
	public  String itemByPrice(QueryVo vo,Model model){
		
		List<Items> itemList = itemService.selectByPrice(vo);
		model.addAttribute("itemList",itemList );
		return "itemList";
	}
	
	@RequestMapping("/ids")
	public  String itemByIds(Integer[] ids,Model model){
		
		 itemService.deleteByIds(ids);
		
		return "itemList";
	}
}
