package com.qf.service.impl;

import java.util.List;

import com.qf.bean.Book;
import com.qf.bean.PageBean;
import com.qf.dao.BookDao;
import com.qf.dao.impl.BookDaoImpl;
import com.qf.service.BookService;

public class BookServiceImpl implements BookService {

	BookDao dao = new BookDaoImpl();

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public void add(Book book) {
		dao.add(book);
	}

	@Override
	public Book findById(String id) {
		
		return dao.findById(id);
	}

	@Override
	public void update(Book book) {
		dao.update(book);
	}

	@Override
	public void deleteAll(String[] ids) {
		dao.deleteAll(ids);
	}

	@Override
	public List<Book> search(String name, String minPrice, String maxPrice, String category) {
		// TODO Auto-generated method stub
		return dao.search(name,minPrice,maxPrice,category);
	}

	@Override
	public PageBean findByPage(int currentPage, int pageSize) {
		PageBean pb = new PageBean();
		int count = dao.getCount();
		int totalPage = (int)Math.ceil(count*1.0/pageSize);
		
		pb.setTotalPage(totalPage);
		pb.setBooks(dao.findByPage(currentPage, pageSize));
		pb.setCurrentPage(currentPage);
		pb.setPageSize(pageSize);
		pb.setCount(count);
		
		return pb;
	}

}
