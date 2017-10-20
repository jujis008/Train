package com.qf.service;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
	
	//当前页
	private int currentPage;
	//每页的数据大小
	private int pageSize;	
	//总页数
	private int totalPage;
	//总个数
	private int  totalCount;
	
	//数据内容
	private List<T> list=new ArrayList<>();

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalPage=" + totalPage
				+ ", totalCount=" + totalCount + ", list=" + list + "]";
	}

	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
