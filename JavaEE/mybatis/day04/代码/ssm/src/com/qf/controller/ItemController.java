package com.qf.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.qf.exceptions.MyException;
import com.qf.pojo.Items;
import com.qf.pojo.ItemsCustom;
import com.qf.service.ItemService;
import com.qf.vo.QueryVo;

@Controller

//@RequestMapping("/item")
public class ItemController {
	
	@Resource(name="itemServiceImpl")
	private ItemService itemService;
	
	
	@RequestMapping("/items")
	public  ModelAndView  findAllItems() throws MyException{
		ModelAndView mav=new ModelAndView();
		
		List<ItemsCustom> ItemList = itemService.selectItems();
		
		mav.addObject("itemList", ItemList);
		mav.setViewName("itemList");
		
		if(ItemList.size()>0){//
			throw new MyException("没有商品");
			
			
		}
		
		return mav;
		
	}
	
	/**
	 * 跳转到修改界面itemEdit.action?id=1?id=1
	 * 
	 * @RequestParam()  如果页面传过来的key 值和变量名不一样，需要用到@RequestParam()注解
	 * required=true 字段是必须的  不传会报错
	 * defaultValue="1" 默认值
	 * 
	 * method={RequestMethod.POST} ：限制为post请求，  
	 */
	@RequestMapping(value="/itemEdit.action",method={RequestMethod.POST,RequestMethod.GET})
	public  ModelAndView itemEdit(Model model,HttpServletResponse httpServletResponse,
			HttpSession httpSession,HttpServletRequest httpServletRequest, 
			@RequestParam(value="id",required=true,defaultValue="1") Integer item_id){
		//先获得id
		
		//调用service 根据查询  数据
		ItemsCustom item = itemService.selectById(item_id);
		
		ModelAndView mav=new ModelAndView();
		
		mav.setViewName("editItem");
		
		mav.addObject("item", item);
		//就相当于  request.setAttribute("item",item);
		model.addAttribute("item", item);
		
		return mav;
	}
	/**
	 * 简单pojo类型的数据绑定
	 * updateItem.action
	 * 
	 * 不支持从String到Date的转换
	 */
	@RequestMapping("/updateItem.action")
	public String updateItem(Items item){
		
		//调用service 去更新
		//去做修改  动态sql
		
		
		
		return "forward:editItem";
	}
	/**
	 * 修改
	 * @param vo
	 * @return
	 */
	@RequestMapping("/updateItem1.action")
	public String updateItem(QueryVo vo,Model model){
		
		//调用service 去更新
		
		
		return "forward:editItem";
		//return "forward:items";
	}
	
	
	
	/**
	 * springmvc 默认支持pojo类型的数据回显   
	 * key值是类名的首字母小写
	 * 
	 * 基本类型的数据要想回显的话  必须手动存储到域对象
	 * @param item
	 * @return
	 */
	
	@RequestMapping("/itemUpdate")
	public  String  itemUpdate( @ModelAttribute("item")  Items item,Model model,Integer id){
		
		//
		//model.addAttribute("item", item);
		
		return "forward:/WEB-INF/jsp/editItem.jsp";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * controller中方法的返回值有三种情况：
	 * 1.ModelAndView   既有数据  又需要跳转
	 * 2.String   只有跳转的情况下  或者带数据
	 * 3.void   
	 * @throws IOException 
	 * @throws ServletException 
	 */
	
	@RequestMapping("/hello")
	public  void  hello(Model model,HttpServletResponse httpServletResponse,HttpSession httpSession,HttpServletRequest httpServletRequest) throws ServletException, IOException{
		//就相当于  request.setAttribute("item",item);
		model.addAttribute("item", null);
		//修改界面跳转
		httpServletRequest.getRequestDispatcher("").forward(httpServletRequest,httpServletResponse);
	}
	
	public String  hello1(){
		
		//返回一个逻辑视图
		return "";
	}
	
	
	/**
	 * queryitem.action
	 * 批量删除：
	 * 	1.Integer[] ids  数组  
	 *  2.或者List<Integer>
	 *  
	 *  批量删除/批量修改  动态sql来修改
	 *  List<Items>
	 */
	@RequestMapping("/item/queryitem.action")
	public String queryitem(Model model,QueryVo vo){
		//按照条件 查询  做
		
		//得到ids数组  去做批量删除  写动态sql批量删除
		
		
		return "forward:itemList";
	}

	
	@RequestMapping("/aaa/{xxx}")
	public  String  aaa(@PathVariable("xxx") String a){
		System.out.println(a);
		
		return "";
	}
}
