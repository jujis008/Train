package com.qf.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.qf.dao.UserDao;
import com.qf.pojo.User;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao{

	@Override
	public int add(String sql, Object... params) {
		// TODO Auto-generated method stub
		return this.getJdbcTemplate().update(sql,params);
	}

	@Override
	public int update(String sql, Object... params) {
		// TODO Auto-generated method stub
		return this.getJdbcTemplate().update(sql,params);
	}

	@Override
	public int delete(long uid) {
		// TODO Auto-generated method stub
		return this.getJdbcTemplate().update("delete from user where uid=?",uid);
	}

	@Override
	public User queryById(long uid) {
		// TODO Auto-generated method stub
	/*	return (User) this.getJdbcTemplate().queryForObject("select * from user where uid=?", new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet arg0, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				
				return null;
			}
		}, uid);*/
		
		return this.getJdbcTemplate().queryForObject("select * from user where uid=?",new BeanPropertyRowMapper<User>(User.class) ,uid);
		
	}

	@Override
	public List<User> queryALl() {
		// TODO Auto-generated method stub
		return this.getJdbcTemplate().query("select * from user ",new BeanPropertyRowMapper<User>(User.class));

	}

	@Override
	public List<User> queryByOthers(String sql, Object... params) {
		// TODO Auto-generated method stub
		return this.getJdbcTemplate().query(sql,new BeanPropertyRowMapper<User>(User.class),params);

	}

}
