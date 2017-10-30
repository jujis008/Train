package com.qf.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.qf.pojo.User;

public class UserDaoImpl implements UserDao{
	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
		
		this.sqlSessionFactory=sqlSessionFactory;
	}
	@Override
	public User findUserById(long uid) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById", uid);
		sqlSession.close();
		return user;
	}

	@Override
	public List<User> findUserByName(String uname) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> user = sqlSession.selectList("test.findUserByName", uname);
		sqlSession.close();
		return user;
	}

	@Override
	public int addUser(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int insert = sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
		sqlSession.close();
		return insert;
	}

	@Override
	public int deleteUser(long uid) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int insert = sqlSession.delete("test.deleteUserById", uid);
		sqlSession.commit();
		sqlSession.close();
		return insert;
	}

	@Override
	public int updateUSer(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int insert = sqlSession.update("test.updateUser", user);
		sqlSession.commit();
		sqlSession.close();
		return insert;
	}

}
