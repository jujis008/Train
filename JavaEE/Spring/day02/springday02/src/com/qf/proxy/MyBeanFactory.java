package com.qf.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyBeanFactory {
	
	
	
	public static Object getProxy(Class clz){
		
		return  Proxy.newProxyInstance(clz.getClassLoader(), clz.getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				
						System.out.println("之前~~~~~~~~");
						Object invoke = method.invoke(clz.newInstance(), args);
						System.out.println("之后~~~~~~~~~~");
						return invoke;
			}
		});
		
		
	}

	

	public static Object getCGLIBProxy(Class clz){
		
		//1.获得核心代理类  
		Enhancer enhancer=new Enhancer();
		//2.设置父类  底层是cglib 通过生成目标类的子类的方式
		enhancer.setSuperclass(clz);
		
		//3.设置回调函数
		enhancer.setCallback(new MethodInterceptor() {
			/**
			 * 目标类的任意方法执行  都要执行该方法
			 * Object proxy:代理对象
			 *  Method method：当前正在执行的方法
			 *  Object[] args:方法的参数
			 *   MethodProxy methodProxy:方法的代理
			 */
			@Override
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
				// TODO Auto-generated method stub
				
				System.out.println("cglib动态代理  方法执行前");
				
				
				Object invoke = method.invoke(clz.newInstance(), args);
				/**
				 * 子类的方法
				 * 子类去执行父类的方法
				 */
				Object invokeSuper = methodProxy.invokeSuper(proxy, args);
				
				
				System.out.println("cglib动态代理  方法执行后");

				return invoke;
			}
		});
		
		//4.创建代理对象
		Object obj = enhancer.create();
		
		return obj;
		
	}
}
