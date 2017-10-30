package com.qf.dao;

import java.util.List;

import com.qf.pojo.User;

public interface UserMapper {
	/**
	 * mapper动态代理的方式：
	 * 1.mapper文件中的namesapce要和mapper接口的全限定名一致
	 * 2.接口中的方法名要和mapper.xml文件中的statement对象的id一致
	 * 3.方法的形参就是parameterType的类型
	 * 4.方法的返回值要和 resultType一致
	 * 
	 */
	//根据id进行查询用户  selectOne()
	  User findUserById(long uid);
	
	//根据用户名模糊查询用户  slectList()
	 List<User> findUserByName(String uname);
	
	//增加用户  insert()
	 //void  int
	 int insertUser(User user);
	
	//删除用户
	int deleteUserById(long uid);
	
	//修改用户
	int updateUser(User user);
	

}
