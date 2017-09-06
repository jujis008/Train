package com.qf.bean;
//将所有与分页有关的信息封装到PageBean 这样 可以直接将PageBean对象返回到页面上

import java.util.ArrayList;
import java.util.List;

public class PageBean {
	private int count;//记录数
	private int pageSize;//每页几条
	private int currentPage;//当前页
	private int totalPage;//总页数
	private List<Book> books = new ArrayList<>();//查询结果
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
