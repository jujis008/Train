package com.qf.proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;
public class Demo {
	
	@Test
	public void run1(){
		
		//创建个代理对象
		XJJProxy proxy=new XJJProxy();	
		proxy.work(100);

		
	}
	/*
	 * 动态代理模式
	 */
	@Test
	public void run2(){
		Worker proxy = (Worker) Proxy.newProxyInstance(XJJ.class.getClassLoader(), XJJ.class.getInterfaces(), new InvocationHandler() {
			/**
			 * 当你执行膜表对象的任意方法的时候，该invoke方法都要执行
			 * Object proxy：代理对象  一般不用他  
			 * Method method：当前正在执行的方法
			 * Object[] args：方法的参数
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("方法执行前");
				//执行方法
				method.invoke(XJJ.class.newInstance(), (double)args[0]/2);
				System.out.println("方法执行后");
				
				return null;
			}
		});
		
	
		proxy.work(100);

		
	}

	
	@Test
	public void run3(){
		
		Worker proxy = (Worker) MyBeanFactory.getProxy(XJJ.class);
		
		proxy.work(100);
	}
	
	@Test
	public void run4(){
		
	/*	Worker proxy = (Worker) MyBeanFactory.getCGLIBProxy(XJJ.class);
		
		proxy.work(100);*/
		
		Demo d = (Demo) MyBeanFactory.getCGLIBProxy(Demo.class);
		d.haha();
	}
	
	
	public  void  haha(){
		
		System.out.println("哈哈哈哈~~~");
	}
}
