package com.qf.service;

import java.util.Map;

import com.qf.pojo.User;

public interface UserService {

	boolean register(User user);
	
	PageBean<User> showUsersByPage(int currentPage,int pageSize);
	
	/**
	 * 按照性别统计个数
	 */
	Map<String,Object> getChart();
	

}
