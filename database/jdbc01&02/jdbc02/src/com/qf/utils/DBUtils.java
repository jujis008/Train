package com.qf.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

//���ݿ⹤����
//��ȡ�����ļ� �������ݿ����� �ͷ���Դ
public class DBUtils {
	private static String driverClass;
	private static String url;
	private static String username;
	private static String password;
	
	static{//��̬����� ��������� ��ִ��
		//��ȡ�����ļ���Ϣ
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
	//�������
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, password);
	}
	//�ر���Դ
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
