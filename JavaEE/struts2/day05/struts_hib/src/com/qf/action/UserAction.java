package com.qf.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID = 8476910983041754614L;
	
	private User user=new User();
	private List<User> list=new ArrayList<>();
	private UserService userService=new UserServiceImpl();
	
	//提供getter和setter方法
	private Map<String,Object> jsonMap=new HashMap<>();
	
	
	
	
	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}


	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}


	public List<User> getList() {
		return list;
	}


	public void setList(List<User> list) {
		this.list = list;
	}


	public String register(){
		
		boolean flag=userService.register(user);
		if(flag){
			return SUCCESS;
		}
		
		
		return "register";
	}
	
	public String check() throws IOException{
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json;charset=utf-8");
		String json="{\"flag\":\"ok\"}";
		System.out.println(json);
		response.getWriter().write(json);
		
		return NONE;
	}

		public String check1() throws IOException{
			jsonMap.put("flag", "ok");
			List<User> list=new ArrayList<>();
			User u=null;
			for(int i=0;i<10;i++){
				u=new User();
				u.setUname("张三"+i);
				u.setUpwd("123");
				list.add(u);
				
			}
			
			jsonMap.put("list", list);
		
		return SUCCESS;
	}


	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}


}
