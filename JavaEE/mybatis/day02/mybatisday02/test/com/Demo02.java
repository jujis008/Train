package com;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.qf.dao.UserMapper;
import com.qf.pojo.User;
import com.qf.vo.QueryVO;

public class Demo02 {
	
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
		
		QueryVO vo=new QueryVO();
		
		User user=new User();
		
		user.setUname("rose");
		
		vo.setUser(user);
		
		List<User> list = mapper.selectUserQueryVo(vo);
		System.out.println(list);
		
	}
	
	//测试查询id
		@Test
		public void run2(){
			//获得session对象
			sqlSession=sqlSessionFactory.openSession();
			
			//获得mapper接口的实现类
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			Map<String,String> map=new HashMap<>();
			map.put("uname", "rose");
			
			List<User> list = mapper.selectUserMap(map);
			System.out.println(list);
			
		}
		
		//查询个数  
		@Test
		public void run3(){
			//获得session对象
			sqlSession=sqlSessionFactory.openSession();
			
			//获得mapper接口的实现类
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
			int selectCount = mapper.selectCount();
			System.out.println(selectCount);
			
		}
		
		//查询
				@Test
				public void run4(){
					//获得session对象
					sqlSession=sqlSessionFactory.openSession();
					
					//获得mapper接口的实现类
					UserMapper mapper = sqlSession.getMapper(UserMapper.class);
				
					User user=new User();
					//user.setUname("rose");
					 List<User> userList = mapper.selectByNameIf(user);
					System.out.println(userList);
					
				}
				
		//查询
		@Test
		public void run5(){
			//获得session对象
			sqlSession=sqlSessionFactory.openSession();
			
			//获得mapper接口的实现类
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
			User user=new User();
			user.setUname("rose");
			user.setUpwd("123");
			 List<User> userList = mapper.selectByNameIf1(user);
			System.out.println(userList);
			
		}
		
		//动态sql foreach
		@Test
		public void run6(){
			//获得session对象
			sqlSession=sqlSessionFactory.openSession();
			
			//获得mapper接口的实现类
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
			QueryVO vo=new QueryVO();
			List<Long> ids = vo.getIds();
			ids.add(1L);
			ids.add(2L);
			ids.add(3L);
			 List<User> userList = mapper.selectUserFor(vo);
			System.out.println(userList);
			
		}
		
		//动态sql choose
				@Test
				public void run7(){
					//获得session对象
					sqlSession=sqlSessionFactory.openSession();
					
					//获得mapper接口的实现类
					UserMapper mapper = sqlSession.getMapper(UserMapper.class);
				
					User user=new User();
					//user.setUid(1L);
					//user.setUname("rose");
					 List<User> userList = mapper.selectUserChoose(user);
					System.out.println(userList);
					
				}		
	
				//动态sql set
				@Test
				public void run8(){
					//获得session对象
					sqlSession=sqlSessionFactory.openSession();
					
					//获得mapper接口的实现类
					UserMapper mapper = sqlSession.getMapper(UserMapper.class);
				
					User user=new User();
					user.setUid(1L);
					user.setUname("jack");
					int count = mapper.selectUserSet(user);
					System.out.println(count);
					sqlSession.commit();
					
					sqlSession.close();
					
				}	
				
				
				//动态sql set
				@Test
				public void run9(){
					//获得session对象
					sqlSession=sqlSessionFactory.openSession();
					
					//获得mapper接口的实现类
					UserMapper mapper = sqlSession.getMapper(UserMapper.class);
				
					User user=new User();
					user.setUid(1L);
					//user.setUname("jack");
					user.setUpwd("123");
					List<User> selectUserTrim = mapper.selectUserTrim(user);
					System.out.println(selectUserTrim);
					sqlSession.commit();
					
					sqlSession.close();
					
				}
				
				//updateUserTrim
				
				@Test
				public void run10(){
					//获得session对象
					sqlSession=sqlSessionFactory.openSession();
					
					//获得mapper接口的实现类
					UserMapper mapper = sqlSession.getMapper(UserMapper.class);
				
					User user=new User();
					user.setUid(1L);
					//user.setUname("jack");
					user.setUpwd("XXX0000");
					int c = mapper.updateUserTrim(user);
					System.out.println(c);
					sqlSession.commit();
					
					sqlSession.close();
					
				}

}
