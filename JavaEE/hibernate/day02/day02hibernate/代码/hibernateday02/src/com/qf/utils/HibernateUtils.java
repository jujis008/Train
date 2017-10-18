package com.qf.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	/**
	 * 
	 */
	private static final Configuration cfg;
	private static final SessionFactory factory;
	private static ThreadLocal<Session> tl=new ThreadLocal<>();
	
	static{
		//加载配置文件
		cfg=new Configuration().configure();
		//构建工厂
		factory=cfg.buildSessionFactory();
		
		//虚拟机关闭的时候  释放资源factory
		/*
		 * Runtime表示当前的运行环境
		 * addShutdownHook:当前class文件被虚拟机回收的时候
		 */
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				factory.close();
				System.out.println("factory关闭了");
			}
		}));
		
		
		
	}
	
	/**
	 * 每次获取新的session对象
	 * @return
	 */
	public static Session openSession(){
		
		return factory.openSession();
	}
	
	/**
	 * 获得和当前线程绑定的对象
	 * @return
	 */
	public static Session getCurrentSession1(){
		//从tl里面取session
		Session session = tl.get();
		if(session==null){//第一次取
			session=factory.openSession();
			//放进tl
			tl.set(session);
			
		}
		return session;
		
	}
	public static Session getCurrentSession(){
		
		//获取与当前线程绑定的session
		return factory.getCurrentSession();
		
	}
	

}
