package com.qf.dao;

import java.util.List;

import com.qf.pojo.User;

public interface UserDao {
	//增加
	void save(User user);
	//删除
	void delete(User user);
	//删除
	int delete(Long uid);
	//根据主键查找
	User queryById(Long uid);
	//查询所有
	List<User> queryAll();
	//更新
	void update(User user);
	//自定义条件查找
	List<User> queryByOthers(String hql,Object...params);
	
	//分页
	List<User> queryUserByPage(String hql,int currentPage,int pageSize,Object...params);
	
	List<Object> queryByOthers1(String hql,Object...params);
}
