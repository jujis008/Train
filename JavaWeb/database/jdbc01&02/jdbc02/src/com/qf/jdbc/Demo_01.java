package com.qf.jdbc;

import java.util.Scanner;

import com.qf.bean.User;

public class Demo_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û���");
		String username = sc.nextLine();
		System.out.println("����������");
		String password = sc.nextLine();
		//��װ����
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		//���þ����ҵ�����
		DoLogin2 login = new DoLogin2();
		User user_back = login.findUser(user);
		if(user_back == null){
			System.out.println("��¼ʧ��");
		}else{
			System.out.println("��¼�ɹ�");
		}
	}

}
