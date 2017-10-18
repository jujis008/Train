package com.action;

import com.opensymphony.xwork2.Action;
/**
 *第二种：实现Action接口需要 实现一个方法 
 */
public class DemoAction1 implements Action{

	@Override
	public String execute() throws Exception {
		System.out.println("Action~~~~~~");
		return SUCCESS;
	}

}
