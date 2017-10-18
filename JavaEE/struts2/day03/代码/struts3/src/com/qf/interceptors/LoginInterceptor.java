package com.qf.interceptors;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
	
		/**
		 * 没有登录，直接访问action,拦截不放行，
		 * user_login 就是跳转到用户登录界面    不拦截
		 */
		
		Object user = ServletActionContext.getRequest().getSession().getAttribute("user");
		
		if(user==null){//不放行  拦截  跳转到login.jsp
			return "login";
			
		}
		//过滤请求
		String invoke = invocation.invoke();
		//过滤响应
		
		
		return invoke;
	}

}
