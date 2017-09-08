package com.qf.service;

import java.util.List;

import com.qf.bean.Book;
import com.qf.bean.PageBean;

public interface BookService {
	public List<Book> findAll();

	public void deleteById(String id);
	
	public void add(Book book);
	
	public Book findById(String id);
	
	public void update(Book book);
	
	public void deleteAll(String[] ids);
	
	public List<Book> search(String name,String minPrice,String maxPrice,String category);
	
	public PageBean findByPage(int currentPage,int pageSize);
}
