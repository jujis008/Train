package com;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.qf.dao.UserDao;
import com.qf.dao.UserDaoImpl;
import com.qf.pojo.User;

public class Demo1 {
	
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	private UserDao userDao;
	
	@Before
	public void init() throws IOException{
		String path="SqlMapConfig.xml";
		//加载路径
		InputStream in = Resources.getResourceAsStream(path);
		//获得sessionFactory工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
	}
	//测试查询id
	@Test
	public void run1(){
		userDao=new UserDaoImpl(sqlSessionFactory);
		
		//调用dao之星方法
		User user = userDao.findUserById(1L);
		System.out.println(user);
	}
	//测试模糊查询
	@Test
	public void run2(){
		userDao=new UserDaoImpl(sqlSessionFactory);
		
		//调用dao之星方法
		List<User> user = userDao.findUserByName("rose");
		System.out.println(user);
	}
	//测试增加
	@Test
	public void run3(){
		userDao=new UserDaoImpl(sqlSessionFactory);
		
		User user=new User();
		user.setUname("猴子");
		//调用dao之星方法
		int c = userDao.addUser(user);
		System.out.println(c);
	}
	
	//测试更新
		@Test
		public void run4(){
			userDao=new UserDaoImpl(sqlSessionFactory);
			
		User user = userDao.findUserById(9L);
		user.setUname("赵信~~");
			//调用dao之星方法
			int c = userDao.updateUSer(user);
			System.out.println(c);
		}
		
		//测试删除
				@Test
				public void run5(){
					userDao=new UserDaoImpl(sqlSessionFactory);
					
				//User user = userDao.findUserById(9L);
				
					//调用dao之星方法
					int c = userDao.deleteUser(9L);
					System.out.println(c);
				}
			
	
	

}
