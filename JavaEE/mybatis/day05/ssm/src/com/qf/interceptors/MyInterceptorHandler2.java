package com.qf.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptorHandler2 implements HandlerInterceptor{
	/**
	 * 返回视图之后
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MyInterceptorHandler2====afterCompletion");
		
	}
	/**
	 * 执行目标handler之后  返回制图之前     ModelAndView  ：可以对数据进行统一处理
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MyInterceptorHandler2====postHandle");
		
	}
	//执行目标handler之前   进行用户是否登录判断  
	//return true; 放行   return false;不会去访问目标的handler
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MyInterceptorHandler2====preHandle");
		
		return true;
	}

}
