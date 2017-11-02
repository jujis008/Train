package com.qf.dao;

import java.util.List;
import java.util.Map;

import com.qf.pojo.User;
import com.qf.vo.QueryVO;

public interface UserMapper {
	/**
	 * mapper动态代理的方式：
	 * 1.mapper文件中的namesapce要和mapper接口的全限定名一致
	 * 2.接口中的方法名要和mapper.xml文件中的statement对象的id一致
	 * 3.方法的形参就是parameterType的类型
	 * 4.方法的返回值要和 resultType一致
	 * 
	 */
	
	 
	 //根据vo查询
	 
	 List<User>  selectUserQueryVo(QueryVO vo);
	 
	 //selectUserMap
	 List<User> selectUserMap(Map<String,String> map);
	 
	int selectCount();//查询个数
	
	 List<User> selectByNameIf(User user);//动态sql  if
	 List<User> selectByNameIf1(User user);//动态sql  if  where
	 List<User> selectUserFor(QueryVO vo);//动态sql foreach
	 
	 List<User> selectUserChoose(User user);//动态sql  choose
	 
	 int selectUserSet(User user);//动态sql  set
	 List<User>  selectUserTrim(User user);//动态sql  trim  where
	 int  updateUserTrim(User user);//动态sql  trim  set
	 
	 
	 List<User>  selectOneToMany(User user);//动态sql  trim  set
	 
	 
	 
	

}
