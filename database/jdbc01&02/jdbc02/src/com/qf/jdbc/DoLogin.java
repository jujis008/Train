package com.qf.jdbc;

import java.sql.*;

import com.qf.bean.User;
import com.qf.utils.DBUtils;

public class DoLogin {
	//���ݴ����user������ username �� password �������ݿ� ����ƥ��
	public User findUser(User u){
		User user = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from user where username='"+u.getUsername()+"' and password='"+u.getPassword()+"'";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				user = new User();
				user.setId(rs.getInt(1));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, stmt, conn);
		}
		return user;
	}
}
