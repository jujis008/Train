package com.qf.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.qf.dao.UserDao;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	@Override
	public int selectCount() {
		SqlSession sqlSession = this.getSqlSession();
		int c = sqlSession.selectOne("test.selectCount");
		
		return c;
	}
	
	

}
