package com.qf.aspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
/**
 * 切面类：通知
 *
 *
 *@Component("myAspect") 
 *相当于
 *<bean id="myAspect" class="com.qf.aspectJ.MyAspect">
 */
@Component("myAspect")
@Aspect//相当于	<aop:aspect ref="myAspect">
public class MyAspect {
	
	/**
	 * 声明公共的切入点
	 * 
	 * 通过方法名来引入公共的切入点
	 */
	//<aop:pointcut expression="execution(* com.qf..*.*(..))" id="myPointCut"/>
	@Pointcut(value="execution(* com.qf..*.*(..))")//
	private void myPointCut(){
		
	}
	
	/**
	 * 前置通知
	 */
	
	//@Before(value="execution(* com.qf..*.*(..))")//相当于<aop:before method="myBefore" pointcut="execution(* com.qf..*.*(..))" />
	@Before("myPointCut()")
	public void myBefore(JoinPoint point){
		
		System.out.println("前置通知==="+point.getSignature().getName());
	}
	/**
	 * 后置通知
	 * 获得方法的返回值
	 * 方法的返回值的形参是需要手动配置
	 */
	@AfterReturning(returning="obj",value="myPointCut()")
	public  void  myReturning(JoinPoint point,Object obj){
		
		System.out.println("后置通知1233==="+obj);
		
	}
	/**
	 * 环绕通知  手动自己调用方法的执行
	 */
	@Around(value="execution(* com.qf..*.*(..))")
	
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
	@AfterThrowing(value="execution(* com.qf..*.*(..))",throwing="e")
	public void myThrowing(Throwable e){
		
		System.out.println("异常==="+e.getMessage());
	}
	@After(value="execution(* com.qf..*.*(..))")
	public void myAfter(){
		
		System.out.println("最终通知");
	}

}
