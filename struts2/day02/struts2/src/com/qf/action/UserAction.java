package com.qf.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	
public String add(){
		
		System.out.println("user add");
		return "add";
	}
	
	public String delete(){
		
		System.out.println("user delete");
		return "delete";
	}
	
	
	public String update(){
		
		System.out.println("user update");
		return "update";
	}
/**
 * 用户登录成功之后  存储到session
 * @return
 */
	public String login(){
		
		System.out.println("user update");
		return "login";
	}
	
	public String register(){
		
		System.out.println("user update");
		return "login";
	}

}
