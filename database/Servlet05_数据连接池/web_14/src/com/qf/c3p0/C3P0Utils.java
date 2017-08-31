package com.qf.c3p0;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	// ��ȡ����Դ c3p0 �Զ���ȡ�����ļ���Ϣ 
	private static DataSource ds = new ComboPooledDataSource();
	// ���get����
	public static DataSource getDataSource() {
		return ds;
	}

	// ��ȡ����
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("��������æ....");
		}
	}

	// �ͷ���Դ
	public static void release(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
