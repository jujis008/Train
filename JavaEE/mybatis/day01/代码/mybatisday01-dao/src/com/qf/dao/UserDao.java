package com.qf.dao;

import java.util.List;

import com.qf.pojo.User;

public interface UserDao {
	//根据id进行查询用户
	User findUserById(long uid);
	
	//根据用户名模糊查询用户
	List<User> findUserByName(String uname);
	
	//增加用户
	int addUser(User user);
	
	//删除用户
	int deleteUser(long uid);
	
	//修改用户
	int updateUSer(User user);
	

}
