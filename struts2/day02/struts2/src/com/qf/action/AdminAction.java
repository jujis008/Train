package com.qf.action;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class AdminAction extends ActionSupport{
	/**
	 * ServletActionContext 可以通过这个类来获得request response对象
	 * @return
	 */
public String add(){
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpSession session = request.getSession();
	ServletContext servletContext = ServletActionContext.getServletContext();
	
	//String name = request.getParameter("name");
	
	request.setAttribute("name", "request的name");//存储到request域对象
	session.setAttribute("name", "session的name");//存储到request域对象
	servletContext.setAttribute("name", "application的name");//存储到request域对象
		//获取表单数据
		
		//放进域对象
	
	
		System.out.println("admin add");
		return "add";
	}
	/**
	 * 完全解耦合的方式：ActionContext对象
	 * struts2是多实例的 每次请求过来都会创建一个新的action对象
	 *  ActionContext每次请求都会创建一个新的。
	 * @return
	 */
	public String delete(){
		//获得action上下文对象
		ActionContext context = ActionContext.getContext();
		
		//获取表单数据
		Map<String, Object> map = context.getParameters();
		
		/*System.out.println(map);*/
		/**
		 * 1.keySet()
		 * 2.entrySet()
		 * 3.values()
		 */
		Set<String> keySet = map.keySet();
		
		
		Set<Entry<String, Object>> entrySet = map.entrySet();
		
		Iterator<Entry<String, Object>> it = entrySet.iterator();
		
		while(it.hasNext()){
			Entry<String, Object> entry = it.next();
			System.out.println("map:"+entry.getKey()+"=="+Arrays.toString((Object[])entry.getValue()));
			
		}
		
		
		
		Collection<Object> values = map.values();
		
		//操作map就是操作域对象
		
		Map<String, Object> application = context.getApplication();
		Map<String, Object> session = context.getSession();
		//默认是往request存
		context.put("name", "request的name");
		application.put("name", "application的name");
		session.put("name", "session的name");
		
		
		
		System.out.println("admin delete");
		return "delete";
	}
	
	
	public String update(){
		
		System.out.println("admin update");
		return "update";
	}


}
