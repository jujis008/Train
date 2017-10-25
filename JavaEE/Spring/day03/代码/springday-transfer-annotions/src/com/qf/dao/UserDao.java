package com.qf.dao;

import java.util.List;

import com.qf.pojo.User;

public interface UserDao {
	
	int add(String sql,Object...params);
	int update(String sql,Object...params);
	int delete(long uid);
	User queryById(long uid);
	
	List<User> queryALl();
	
	List<User> queryByOthers(String sql,Object...params);

}
