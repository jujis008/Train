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

import com.qf.dao.UserMapper;
import com.qf.pojo.User;

public class TestMapper {
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
		
		//获得mapper接口的实现类
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		int count = mapper.deleteUserById(12L);
		sqlSession.commit();//提交事务
		System.out.println(count);
	}
	//测试查询id
		@Test
		public void run2(){
			//获得session对象
			sqlSession=sqlSessionFactory.openSession();
			
			//获得mapper接口的实现类
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			List<User> list = mapper.findUserByName("rose");
			sqlSession.commit();//提交事务
			System.out.println(list);
		}
		//测试增加
		@Test
		public void run3(){
			//获得session对象
			sqlSession=sqlSessionFactory.openSession();
			
			//获得mapper接口的实现类
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			User u=new User();
			u.setUname("王大锤~~");//
			int c = mapper.insertUser(u);
			sqlSession.commit();//提交事务
			System.out.println(c);
		}
		
		//测试增加
			@Test
			public void run4(){
				//获得session对象
				sqlSession=sqlSessionFactory.openSession();
				
				//获得mapper接口的实现类
				UserMapper mapper = sqlSession.getMapper(UserMapper.class);
				User u=new User();
				u.setUid(10L);
				u.setUname("王尼玛~~");//
				int c = mapper.updateUser(u);
				sqlSession.commit();//提交事务
				System.out.println(c);
			}

}
