package com.qf.dbutils;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.qf.c3p0.C3P0Utils;
//update() ÔöÉ¾¸Ä
public class DemoUpdate {
	@Test
	public void testDelete02() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "delete from book where name like ?";
		qr.update(sql,"%java%");
	}
	@Test
	public void testDelete() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "delete from book where id = 11";
		qr.update(sql);
	}
	@Test
	public void testUpdate() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "update book set price=30 where id=11";
		qr.update(sql);
	}
	@Test
	public void testInsert02() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "insert into book(name,price,num,category,description) "
				+ "values(?,?,?,?,?)";
		qr.update(sql, "photoshop",23,3,"ui","hhhh");
	}
	@Test
	public void testInsert01() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "insert into book(name,price,num,category,description) "
				+ "values('html',10,12,'html','html')";
		qr.update(sql);
	}
}
