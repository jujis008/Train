package com.qf.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import com.qf.utils.DBUtils;

//ÔöÉ¾¸Ä PreparedStatement
public class Demo_02 {
	
	@Test
	public void testInsert(){
		try{
			Connection conn = DBUtils.getConnection();
			String sql = "insert into user(username,password) values(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "abc");
			pstmt.setString(2, "dbc");
			int line = pstmt.executeUpdate();
			if(line>0){
				System.out.println("success");
			}else{
				System.out.println("error");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdate(){
		try{
			Connection conn = DBUtils.getConnection();
			String sql = "update user set username=?,password=? where id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "dddd");
			pstmt.setString(2, "aaaa");
			pstmt.setInt(3, 2);
			
			int line = pstmt.executeUpdate();
			if(line>0){
				System.out.println("success");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void testDelete(){
		try{
			Connection conn = DBUtils.getConnection();
			String sql = "delete from user where id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 2);
			int line = pstmt.executeUpdate();
			if(line>0){
				System.out.println("success");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
