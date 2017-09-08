package com.qf.jdbc;

import java.sql.*;

import com.qf.bean.User;
import com.qf.utils.DBUtils;
//使用 PreparedStatement 来 避免sql注入
public class DoLogin2 {
	//根据传入的user对象中 username 和 password 连接数据库 进行匹配
	public User findUser(User u){
		User user = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtils.getConnection();
			//创建PreparedStatement对象 封装sql语句
			pstmt = conn.prepareStatement("select * from user where username=? and password=?");
			//给问号赋值 参数索引从1开始
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());
			System.out.println(pstmt.toString());
			//执行并返回结果集
			rs = pstmt.executeQuery();
			if(rs.next()){
				user = new User();
				user.setId(rs.getInt(1));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, pstmt, conn);
		}
		return user;
	}
}
