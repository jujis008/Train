package com.qf.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport{
	
	
	public String add(){
		
		System.out.println("add");
		return NONE;
	}
	
	public String delete(){
		
		System.out.println("delete");
		return NONE;
	}
	
	
	public String update(){
		
		System.out.println("update");
		return NONE;
	}

}
