package com.qf.jdbc;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao{
	
	/**
	 * 来个模板类的成员属性名
	 */
	/*private JdbcTemplate  jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}*/

	@Override
	public int add(String sql, Object... params) {
		// TODO Auto-generated method stub
		return this.getJdbcTemplate().update(sql,params);
	}

}
