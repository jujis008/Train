package com.qf.action;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.opensymphony.xwork2.ActionSupport;
import com.qf.pojo.User;
import com.qf.service.PageBean;
import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;
import com.qf.utils.HibernateUtils;

public class UserPageAction extends ActionSupport{
	private static final long serialVersionUID = 5498679501155903004L;
	//整个Map
	private Map<String,Object> jsonMap=new HashMap<>();

	//
	private UserService userService=new UserServiceImpl();
	
	//从页面接收当前页  每页的个数大小
	private int currentPage=1;
	
	private int pageSize=10;

	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
	public String ajaxUserByPage(){
		PageBean<User> pb = userService.showUsersByPage(currentPage, pageSize);
		if(pb.getList().size()>0){
			jsonMap.put("flag", "1");//有数据
			jsonMap.put("pb", pb);
		}
		
		return "success";
	}

	
	
	//
	@Test
	public  void  run1(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction ts = session.beginTransaction();
		for(int i=0;i<166;i++){
			User u=new User();
			u.setUname("王美玲"+i);
			u.setSex("女");
			if(i%3==0){
				u.setSex("男");
			}
			u.setUpwd("ml"+i);
			session.save(u);
		}
		
		ts.commit();
		
		
		
	}

}
