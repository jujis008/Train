package com.qf.bean;
//���������ҳ�йص���Ϣ��װ��PageBean ���� ����ֱ�ӽ�PageBean���󷵻ص�ҳ����

import java.util.ArrayList;
import java.util.List;

public class PageBean {
	private int count;//��¼��
	private int pageSize;//ÿҳ����
	private int currentPage;//��ǰҳ
	private int totalPage;//��ҳ��
	private List<Book> books = new ArrayList<>();//��ѯ���
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
