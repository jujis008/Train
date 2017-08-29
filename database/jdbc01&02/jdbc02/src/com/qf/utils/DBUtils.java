package com.qf.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

//数据库工具类
//获取配置文件 创建数据库连接 释放资源
public class DBUtils {
	private static String driverClass;
	private static String url;
	private static String username;
	private static String password;
	
	static{//静态代码块 当程序加载 就执行
		//读取配置文件信息
		ResourceBundle rb = ResourceBundle.getBundle("DBConfig");
		driverClass = rb.getString("driverClass");
		url = rb.getString("url");
		username = rb.getString("username");
		password = rb.getString("password");
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获得链接
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, password);
	}
	//关闭资源
	public static void closeAll(ResultSet rs,Statement stmt,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
			if(stmt!=null){
				stmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
