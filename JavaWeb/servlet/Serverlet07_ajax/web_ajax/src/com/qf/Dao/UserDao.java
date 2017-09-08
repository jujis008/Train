package com.qf.Dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.qf.bean.User;
import com.qf.c3p0.C3P0Utils;

public class UserDao {
	public User findByUserName(String username){
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		User user = null;
		
		try {
			user = qr.query("select * from user where username=?", new BeanHandler<User>(User.class),username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
