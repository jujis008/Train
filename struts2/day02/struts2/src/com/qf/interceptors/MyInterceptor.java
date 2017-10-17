package com.qf.interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/*
 * 只可以过滤action下的方法  jsp文件不能过滤
 */
public class MyInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		
		
		ActionContext context = invocation.getInvocationContext();
		System.out.println("1号拦截器过滤请求"+context.getName()+"==方法名"+invocation.getProxy().getMethod());
		
		String invoke = invocation.invoke();//调用下一个拦截器
		
		
		System.out.println("1号拦截器过滤响应");
		
		return invoke;
	}
	
	

}
