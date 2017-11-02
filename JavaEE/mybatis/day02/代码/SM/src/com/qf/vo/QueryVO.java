package com.qf.vo;

import java.util.ArrayList;
import java.util.List;

import com.qf.pojo.User;
/**
 * view model 可扩展性非常强
 * @author tomcat
 *
 */
public class QueryVO {
	
	//包含user的所有属性
	private User user;

	
	private List<Long> ids=new ArrayList<>();
	
	
	

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "QueryVO [user=" + user + "]";
	}

	public QueryVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
