package com.qf.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSONFieldBridge;

import com.opensymphony.xwork2.ActionSupport;
import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.utils.PageBean;import javassist.CodeConverter.ArrayAccessReplacementMethodNames;

public class UserAction extends ActionSupport{
	//往页面传送的json数据
	private Map<String,Object> jsonMap;
	//接收页面传过来的当前页
	private int currentPage=1;
	//接收页面传过来来的每页数据大小
	private int pageSize=8;
	//注入UserService
	private UserService userService=new UserService();
	
	public String ajaxQueryUserByPage(){
		
		//调用userService获得PageBean对象
		PageBean<User> pb = userService.showUsersByPage(currentPage, pageSize);
		jsonMap=new HashMap<>();
		if(pb.getList().size()>0){//有数据
		
			jsonMap.put("msg", "ok");
			jsonMap.put("pb", pb);
			
			
		}else{//没有数据
			jsonMap.put("msg", "error");
			
		}
		
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}


	public String register(){
		
		
		
		System.out.println("注册");
		
		return SUCCESS;
	}
	
	
	public String creatChart(){
		//调用service获取数据
		Map<String, Object> map = userService.chart();
		jsonMap=new HashMap<>();
		//jsonMap.put("xAxis", new String[]{"男","女"});
		jsonMap.put("xAxis", map.get("sex"));
		jsonMap.put("yAxis",map.get("count"));
		//System.out.println(obj);
		System.out.println(map);
		return SUCCESS;
	}
	
}
