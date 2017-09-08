package com.qf.jdbc;

import java.util.Scanner;

import com.qf.bean.User;

public class Demo_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名");
		String username = sc.nextLine();
		System.out.println("请输入密码");
		String password = sc.nextLine();
		//封装对象
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		//调用具体的业务处理层
		DoLogin2 login = new DoLogin2();
		User user_back = login.findUser(user);
		if(user_back == null){
			System.out.println("登录失败");
		}else{
			System.out.println("登录成功");
		}
	}

}
