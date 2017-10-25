package com.qf.dao.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.qf.dao.TransferDao;

@Repository("transferDao")
public class TransferDaoImpl extends JdbcDaoSupport implements TransferDao{
	
	/**
	 * 要么注入JdbcTemplate模板
	 * 要么注入数据源  （推荐）
	 */
	@Resource(name="dataSource")
	private DataSource dataSource;

	@PostConstruct
	void init(){
		//给父类的赋值
		setDataSource(dataSource);
		
		
	}
	
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
