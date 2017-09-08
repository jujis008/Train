package com.qf.dao;

import java.util.List;

import com.qf.bean.Book;

public interface BookDao {
	public List<Book> findAll();

	public void deleteById(String id);
	
	public void add(Book book);
	
	public Book findById(String id);
	
	public void update(Book book);
	
	public void deleteAll(String[] ids);
	
	public List<Book> search(String name,String minPrice,String maxPrice,String category);
	//selcet * from book limit 0,pageSize;
	public List<Book> findByPage(int currentPage,int pageSize);
	
	public int getCount();
}
