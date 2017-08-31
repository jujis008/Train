package com.qf.dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.qf.bean.Book;
import com.qf.c3p0.C3P0Utils;

public class DemoQuery {
	//2.BeanListHandler 把每条记录封装成对象 把对象存储到List集合中 适合取多条记录
	@Test
	public void testQuery03() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		List<Book> list = qr.query("select * from book where id=? or id=?", new BeanListHandler<Book>(Book.class),2,3);
		System.out.println(list);
	}
	//1.BeanHandler 把每条记录封装成对象 适合取一条记录
	@Test
	public void testQuery02() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		Book book = qr.query("select * from book where id=?", new BeanHandler<Book>(Book.class),2);
		System.out.println(book);
	}
	@Test
	public void testQuery01() throws SQLException{
		//1.创建QueryRunner对象 指定数据源
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		//查询图书信息 范围list<Book>集合
		//2.使用query方法执行select语句
		List<Book> list = qr.query("select * from book", new ResultSetHandler<List<Book>>() {
			//3.使用ResultSetHandler封装结果集
			//使用 ResultSetHandler 匿名内部类的方式
			@Override
			public List handle(ResultSet rs) throws SQLException {
				List<Book> list = new ArrayList<>();
				while(rs.next()){
					Book book = new Book();
					book.setId(rs.getInt("id"));
					book.setName(rs.getString("name"));
					book.setPrice(rs.getDouble("price"));
					book.setNum(rs.getInt("num"));
					book.setCategory(rs.getString("category"));
					book.setDescription(rs.getString("description"));
					list.add(book);
				}
				return list;
			}
		});
		System.out.println(list);
	}
	
}
