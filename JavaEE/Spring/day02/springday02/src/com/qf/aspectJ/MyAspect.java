package com.qf.aspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	
	/**
	 * 前置通知
	 */
	public void myBefore(JoinPoint point){
		
		System.out.println("前置通知==="+point.getSignature().getName());
	}
	/**
	 * 后置通知
	 * 获得方法的返回值
	 * 方法的返回值的形参是需要手动配置
	 */
	public  void  myReturning(JoinPoint point,Object obj){
		
		System.out.println("后置通知==="+obj);
		
	}
	/**
	 * 环绕通知  手动自己调用方法的执行
	 */
	public  void  myAround(ProceedingJoinPoint point){
		Object proceed=null;
		try {
			System.out.println("环绕====前置");
			proceed = point.proceed();
			System.out.println("环绕====后置"+proceed);

		} catch (Throwable e) {
			
			e.printStackTrace();
			System.out.println("环绕====异常");
			
			
		}finally {
			
			System.out.println("环绕====最终");

		}
		
		
		
	}
	
	public void myThrowing(Throwable e){
		
		System.out.println("异常==="+e.getMessage());
	}
	
	public void myAfter(){
		
		System.out.println("最终通知");
	}

}
