package com.qf.aop;



import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;



public class MyAspect implements MethodInterceptor{
	/**
	 * 环绕通知：手动实现import org.aopalliance.intercept.MethodInterceptor
	 * 还需要手动调用方法，可以实现前置通知，后置通知，异常通知
	 */
	@SuppressWarnings("finally")
	@Override
	public Object invoke(MethodInvocation invoke) throws Throwable {
		Object proceed=null;
		try{
			//前置通知
			System.out.println("之前==="+invoke.getMethod().getName());
			
			//手动执行方法
			proceed = invoke.proceed();
			//后置通知
			System.out.println("之后==="+proceed);
			
			
		}
		
		catch (Throwable e) {
			System.out.println(e.getMessage());
			//异常通知
			System.out.println("异常通知~~出错啦");
			
			
		}finally {
			
			//最终通知
			System.out.println("最终~~~");
			return proceed;
		}
		
		
	}

	

}
