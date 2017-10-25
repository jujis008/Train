package com.qf.jdbc;

import java.beans.PropertyVetoException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DemoJdbc {
	
	
	@Test
	public void run1(){
		/**
		 * Spring有一个内置的连接池
		 */
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:mysql:///haha");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		
		/**
		 * JdbcTemplate
		 */
		JdbcTemplate template=new JdbcTemplate();
		
		template.setDataSource(dataSource);
		int update = template.update("insert into user(uname,upwd) values(?,?)","小张","123");
		
		System.out.println(update);
		
	}

	/**
	 * DBCP连接池
	 */
	@Test
	public void run2(){
		/**
		 * Spring有一个内置的连接池
		 */
		BasicDataSource dataSource=new BasicDataSource();
		
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:mysql:///haha");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		
		/**
		 * JdbcTemplate
		 */
		JdbcTemplate template=new JdbcTemplate();
		
		template.setDataSource(dataSource);
		int update = template.update("insert into user(uname,upwd) values(?,?)","小丽","123");
		
		System.out.println(update);
		
	}
	/**
	 * c3p0连接池
	 * @throws PropertyVetoException 
	 */
	@Test
	public void run3() throws PropertyVetoException{
		/**
		 * Spring有一个内置的连接池
		 */
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		
		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setJdbcUrl("jdbc:mysql:///haha");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		
		/**
		 * JdbcTemplate
		 */
		JdbcTemplate template=new JdbcTemplate();
		
		template.setDataSource(dataSource);
		int update = template.update("insert into user(uname,upwd) values(?,?)","小王","123");
		
		System.out.println(update);
		
	}
}
