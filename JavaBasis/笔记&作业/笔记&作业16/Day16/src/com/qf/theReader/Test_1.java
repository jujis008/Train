package com.qf.theReader;

import java.io.FileReader;
import java.io.IOException;

//��ȡһ���ļ����� ������ӡ������̨��
public class Test_1 {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("Student.java");
		char[] buf = new char[1024];
		int num = 0;
		while((num = fr.read(buf))!=-1) {
			System.out.println(new String(buf,0,num));
		}
		fr.close();
	}
}
