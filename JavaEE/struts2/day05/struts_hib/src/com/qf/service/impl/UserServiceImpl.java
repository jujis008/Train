package com.qf.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qf.dao.UserDao;
import com.qf.dao.impl.UserDaoImpl;
import com.qf.pojo.User;
import com.qf.service.PageBean;
import com.qf.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao =new UserDaoImpl();
	
	@SuppressWarnings("finally")
	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			userDao.save(user);
			flag=true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag=false;
		}
		finally {
			return flag;
		}
		
	}
/**
 * 分页的业务逻辑
 */
	@Override
	public PageBean<User> showUsersByPage(int currentPage, int pageSize) {
		
		PageBean<User> pb=new PageBean<>();
		pb.setCurrentPage(currentPage);
		pb.setPageSize(pageSize);
		//获得要分页的所有条数
		int size = userDao.queryAll().size();		
		pb.setTotalCount(size);
		pb.setTotalPage(size%pageSize==0? (size/pageSize):(size/pageSize+1));
		
		String hql="Select user from User user";
		List<User> list = userDao.queryUserByPage(hql, currentPage, pageSize);
		
		pb.setList(list);
		return pb;
		
	}
@Override
public Map<String, Object> getChart() {
	
	String hql="select user.sex from User user group by user.sex";
	
	String hql1="select count(*) from User user group by user.sex";
	//哪些性别
	List<Object> sexList = userDao.queryByOthers1(hql);
	//性别对应的个数
	List<Object> countList = userDao.queryByOthers1(hql1);
	
	Map<String,Object> map=new HashMap<>();
	map.put("sex", sexList);
	map.put("count", countList);

	return map;
}

}
