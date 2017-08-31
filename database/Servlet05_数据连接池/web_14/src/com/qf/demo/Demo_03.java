package com.qf.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.qf.c3p0.C3P0Utils;

//事务 案例:
//转账 从tom的账户里转出100 加入到jerry的账户里
public class Demo_03 {

	public static void main(String[] args) {
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		try {
			conn = C3P0Utils.getConnection();
			//1.mysql事务默认是自动提交的  将事务的提交方式变为手动提交
			conn.setAutoCommit(false);//设置为false 可以认为是开启了事务
			pstmt = conn.prepareStatement("update account set money=money-100 where name='tom'");
			pstmt.executeUpdate();
			int i = 1/0;//此处出现异常 下面不再执行
			pstmt = conn.prepareStatement("update account set money=money+100 where name='jerry'");
			pstmt.executeUpdate();
			
			//2.手动提交事务 事务的结束方式一
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			if(conn!=null){
				try {
					//2.回滚事务 如果try中的代码出现异常 走catch 那么在catch设置事务的回滚 事务的结束方式二
					//如果出现异常 就进行数据回滚
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
	}

}
