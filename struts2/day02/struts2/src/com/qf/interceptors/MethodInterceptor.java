package com.qf.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class MethodInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("method拦截器过滤请求");
		 String invoke = invocation.invoke();
		 System.out.println("method拦截器过滤响应");
		 
		 return invoke;
	}

}
