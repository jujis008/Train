package com.qf.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.qf.dao.TransferDao;

public class TransferDaoImpl extends JdbcDaoSupport implements TransferDao{

	@Override
	public int min(String from, Double money) {
		// TODO Auto-generated method stub
		return this.getJdbcTemplate().update("update user set money=money-? where uname=?",money,from);
	}

	@Override
	public int add(String to, Double money) {
		// TODO Auto-generated method stub
		return this.getJdbcTemplate().update("update user set money=money+? where uname=?",money,to);
	}

}
