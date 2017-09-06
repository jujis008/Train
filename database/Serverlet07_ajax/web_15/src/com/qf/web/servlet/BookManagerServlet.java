package com.qf.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.qf.bean.Book;
import com.qf.service.BookService;
import com.qf.service.impl.BookServiceImpl;

public class BookManagerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		BookService bs = new BookServiceImpl();

		String flag = req.getParameter("flag");
		String id = req.getParameter("id");
		//条件查询
		if("search".equals(flag)){
			String name = req.getParameter("name");
			String minPrice = req.getParameter("minPrice");
			String maxPrice = req.getParameter("maxPrice");
			String category = req.getParameter("category");
			
			List<Book> books = bs.search(name,minPrice,maxPrice,category);
			req.setAttribute("books", books);
			req.getRequestDispatcher("show.jsp").forward(req, resp);

		}
		//批量删除
		if("deleteAll".equals(flag)){
			String[] ids = req.getParameterValues("ids");
			bs.deleteAll(ids);
			flag = "show";
		}
		// 修改图书信息 第一步 根据id 查询学生信息 显示到update.jsp页面上
		if("preUpdate".equals(flag)){
			Book book = bs.findById(id);
			req.setAttribute("book", book);
			req.getRequestDispatcher("update.jsp").forward(req, resp);
		}
		// 修改图书信息 第二步 
		if("update".equals(flag)){
			Book book = new Book();
			try {
				BeanUtils.populate(book, req.getParameterMap());
				bs.update(book);
				flag = "show";
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 添加图书信息
		if("add".equals(flag)){
			Book book = new Book();
			try {
				BeanUtils.populate(book, req.getParameterMap());
				bs.add(book);
				flag = "show";
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 删除图书信息
		if ("delete".equals(flag)) {
			bs.deleteById(id);
			flag = "show";
		}

		// 查询所有图书信息
		if ("show".equals(flag)) {
			List<Book> books = bs.findAll();
			req.setAttribute("books", books);
			req.getRequestDispatcher("show.jsp").forward(req, resp);

		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		this.doGet(req, resp);
	}

}
