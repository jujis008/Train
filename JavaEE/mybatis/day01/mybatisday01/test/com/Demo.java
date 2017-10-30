package com;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.qf.pojo.User;

public class Demo {
	
	
	/**
	 * 测试根据id查找用户
	 * @throws IOException 
	 */
	@Test
	public void run1() throws IOException{
		String path="SqlMapConfig.xml";
		//加载路径
		InputStream in = Resources.getResourceAsStream(path);
		//获得sessionFactory工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		
		//获得SqlSession对象
		SqlSession session = factory.openSession();
		
		
		User user = session.selectOne("test.findUserById",1L );
		
		System.out.println(user);
		//释放资源
		session.close();
		
	}
	/**
	 * 根据用户名来模糊查询用户信息:findUserByName
	 * @throws IOException
	 */
	
	@Test
	public void run2() throws IOException{
		String path="SqlMapConfig.xml";
		//加载路径
		InputStream in = Resources.getResourceAsStream(path);
		//获得sessionFactory工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		
		//获得SqlSession对象
		SqlSession session = factory.openSession();
		/**
		 * 当结果集只有一条的时候可以用：selectOne
		 * 当结果有多条：selectList   可以是一条或者多条
		 */
		
		List<User> user = session.selectList("test.findUserByName","jack");
		
		System.out.println(user);
		//释放资源
		session.close();
		
	}
	
	/**
	 * insertUser
	 * 测试添加用户
	 * 
	 * sqlSession对象会自动开启事务，但是他不知道什么提交，得手动提交
	 * 
	 * 增加一个用户之后，我想立马获得他，通过主键获得他，我想获得我最后一次增加的数据的主键
	 */
	@Test
	public void run3() throws IOException{
		String path="SqlMapConfig.xml";
		//加载路径
		InputStream in = Resources.getResourceAsStream(path);
		//获得sessionFactory工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		
		//获得SqlSession对象
		SqlSession session = factory.openSession();
		User user=new User();
		user.setBirthday(new Date());
		user.setSex("女");
		user.setUname("小rose");
		user.setUpwd("123");
		//返回值是受影响的行数  
		int count = session.insert("test.insertUser1",user);
		
		System.out.println(count);
		
		System.out.println(user);//不会自动把主键放进该user对象里面
		//提交事务
		session.commit();
		//释放资源
		session.close();
		
	}
	

}
