package com.qf.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.qf.bean.Book;
import com.qf.c3p0.C3P0Utils;
import com.qf.dao.BookDao;

public class BookDaoImpl implements BookDao {
	QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	@Override
	public List<Book> findAll() {
		List<Book> list = new ArrayList<Book>();
		try {
			list = qr.query("select * from book", new BeanListHandler<Book>(Book.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
		try {
			qr.update("delete from book where id=?", id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void add(Book book) {
		try {
			String sql = "insert into book(name,price,num,category,description) values(?,?,?,?,?)";
			qr.update(sql, book.getName(),book.getPrice(),book.getNum(),book.getCategory(),book.getDescription());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Book findById(String id) {
		Book book = null;
		try {
			book = qr.query("select * from book where id=?", new BeanHandler<Book>(Book.class),Integer.parseInt(id));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public void update(Book book) {
		try {
			qr.update("update book set name=?,price=?,num=?,category=?,description=? where id=?",book.getName(),book.getPrice(),book.getNum(),book.getCategory(),book.getDescription(),book.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAll(String[] ids) {
		Object[][] params = new Object[ids.length][];
		for(int i=0;i<params.length;i++){
			params[i] = new Object[]{ids[i]};
		}
		try {
			qr.batch("delete from book where id=?", params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Book> search(String name, String minPrice, String maxPrice, String category) {
		List<Book> list = new ArrayList<>();
		String sql = "select * from book where 1=1";
		//创建集合 用来存储形参列表
		List<String> condition = new ArrayList<>();
		//判断文本框是否有值 如果不为空 就拼接
		if(!"".equals(name)){
			sql+=" and name like ? ";
			condition.add("%"+name+"%");
		}
		if(!"".equals(category)){
			sql+=" and category = ? ";
			condition.add(category);
		}
		if(!"".equals(minPrice)){
			sql+=" and price > ? ";
			condition.add(minPrice);
		}
		if(!"".equals(maxPrice)){
			sql+=" and price < ? ";
			condition.add(maxPrice);
		}
		System.out.println(sql);
		try {//可变参数 可以和数组替换使用
			list = qr.query(sql, new BeanListHandler<Book>(Book.class),condition.toArray());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Book> findByPage(int currentPage, int pageSize) {
		List<Book> list = new ArrayList<>();
		try {
			list = qr.query("select * from book limit ?,?", 
					new BeanListHandler<Book>(Book.class),(currentPage-1)*pageSize,pageSize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getCount() {
		String sql = "select count(*) from book";
		long count = 0;
		try {
			count = (Long)qr.query(sql, new ScalarHandler());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (int)count;
	}
}
