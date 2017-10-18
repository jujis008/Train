package com.qf.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.qf.pojo.User;

public class UserAction extends ActionSupport{
	
	private String  xxx="嘿嘿嘿哈哈哈";	
	
	private List<User> list=new ArrayList<>();
	
	private Map<String,User> map=new HashMap<>();
	
	private User  user=new User();//key默认是属性名
	


	public String add(){
		
		//获取值栈对象
		HttpServletRequest request = ServletActionContext.getRequest();
		ValueStack stack = (ValueStack) request.getAttribute("struts.valueStack");
		
		System.out.println(stack);
		
		//request.setAttribute("name", "aaaaa");
		ActionContext.getContext().put("name", "1231424");
		Object object = ActionContext.getContext().get("name");
		
	
		
		System.out.println(object);
		System.out.println("request======"+request.getAttribute("name"));
		return SUCCESS;
	}
	
	public String ognl(){
		
		//获得值栈对象
		ValueStack stack = ActionContext.getContext().getValueStack();
		
		/**
		 * 转发
		 * push(obj)
		 * set(String,Objecy)
		 */
		
		stack.push("芙蓉姐姐");
		
		stack.set("detail", "芙蓉姐姐十八岁啦");
		
		stack.set("detail1", "凤姐姐十八岁啦");
		
		User u=new User();
		
		u.setUname("张三");
		u.setUpwd("123");
		u.setSex("男");
		
		stack.push(u);
		
		
		user.setUname("李四");
		user.setUpwd("321");
		user.setSex("女");
		
		for(int i=0;i<10;i++){
			User u1=new User();
			u1.setUname("张三"+i);
			u1.setUpwd("zs"+i);
			u1.setSex("男");
			if(i%2==0){
				u1.setSex("女");
			}
			list.add(u1);
			
			map.put("user"+i, u1);
		}
		
		
		
		
		
		return SUCCESS;
	}
	
	
	
	
	
	public String ognl1(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		ServletContext application = request.getServletContext();
		
		
		request.setAttribute("ooo", "request嘿嘿嘿");
		session.setAttribute("ooo", "session哈哈哈");
		application.setAttribute("ooo", "application嗷嗷嗷");
		
		
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	public Map<String, User> getMap() {
		return map;
	}

	public void setMap(Map<String, User> map) {
		this.map = map;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getXxx() {
		return xxx;
	}

	public void setXxx(String xxx) {
		this.xxx = xxx;
	}
}
