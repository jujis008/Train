package com.qf.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.bean.PageBean;
import com.qf.dao.impl.BookDaoImpl;
import com.qf.service.BookService;
import com.qf.service.impl.BookServiceImpl;
//分页查询
public class PageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		int currentPage = 1; //当前页默认第一页
		int pageSize = 3;//每页显示条数 3条数据
		//获得点击的页码 只有点击页码 才能获取值 
		String cPage = req.getParameter("cPage");
		if(cPage!=null){
			currentPage = Integer.parseInt(cPage);
		}
		//selcet * from book limit 0,pageSize;
		BookService bs = new BookServiceImpl();
		PageBean pb = bs.findByPage(currentPage, pageSize);
		req.setAttribute("pb", pb);
		req.getRequestDispatcher("show2.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
