package com.qf.exceptions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionHandler implements HandlerExceptionResolver {
/**
 * ex:就是出现的异常对象
 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// TODO Auto-generated method stub
		//打印错误的堆栈信息
		ex.printStackTrace();
		MyException exception=null;
		
		if(ex instanceof MyException){//预期的异常
			
			exception=(MyException)ex;
			
		}else{
			
			exception=new MyException("未知的错误");
		}
		
		ModelAndView mav=new ModelAndView();
		//往哪个页面进行跳转
		mav.addObject("message", exception.getMessage());
		
		mav.setViewName("error");
		
		return mav;
	}

}
