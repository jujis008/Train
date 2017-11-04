package com.qf.exceptions;

/**
 * 自定义异常类：预期的异常
 * @author tomcat
 *
 */
public class MyException extends Exception{
	
	private String message;//错误的信息
	
	public  MyException(String message){
		
		super(message);
	}

}
