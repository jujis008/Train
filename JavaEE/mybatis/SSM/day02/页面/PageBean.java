
package com.bk.utils;

import java.util.List;

import com.bk.model.Product;

/**
 * 把每页的数据全部都封装到该pageBean里
* @desc: bk
* @author: 千锋讲师张增强
* @createTime: 2017年7月4日 下午2:04:53
* @history:
* @version: v1.0
 */
public class PageBean {
	private int currentPage;//当前页
	private int pageSize;//每页的数据大小
	private int totalCount;//记录总个数
	/**
	 * (totalCount%pageSize==0) ? (totalCount/pageSize):(totalCount/pageSize+1)
	 */
	private int totalPageSize;
	private List<Product> list;
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
	public int getTotalCount() {
	
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
	
		this.totalCount = totalCount;
	}
	public int getTotalPageSize() {
	
		return totalPageSize;
	}
	public void setTotalPageSize(int totalPageSize) {
	
		this.totalPageSize = totalPageSize;
	}
	public List<Product> getList() {
	
		return list;
	}
	public void setList(List<Product> list) {
	
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalCount=" + totalCount
				+ ", totalPageSize=" + totalPageSize + ", list=" + list + "]";
	}
	public PageBean(int currentPage, int pageSize, int totalCount, int totalPageSize, List<Product> list) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPageSize = totalPageSize;
		this.list = list;
	}
	public PageBean() {
		
		super();
		//TODO 
			
	}
	


}

	