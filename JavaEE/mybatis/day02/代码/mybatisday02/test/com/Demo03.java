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

import com.qf.dao.OrderMapper;
import com.qf.dao.UserMapper;
import com.qf.pojo.Order;
import com.qf.pojo.User;

public class Demo03 {
	
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	
	
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
		//获得session对象
		sqlSession=sqlSessionFactory.openSession();
		
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		Order order=new Order();
		order.setOid(1L);
		List<Order> list = mapper.selectOneToOne(order);
		System.out.println(list);
	}
	@Test
	public void run2(){
		//获得session对象
		sqlSession=sqlSessionFactory.openSession();
		
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user=new User();
		user.setUid(1L);
		List<User> list = mapper.selectOneToMany(user);
		System.out.println(list);
	}
	

}
