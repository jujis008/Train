package com.qf.theReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo_2 {
//��ȡ��ʽ�� int read(char[] cbuf)  //int ���ص��Ƕ�ȡ���ַ��ĸ���
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("demo.txt");
		char[] buf = new char[1024];
		// 1���ַ���2���ֽ� �����С һ�㶨��Ϊ 1024���� 1024��������
		/*
		int num = fr.read(buf);
		System.out.println("num==="+num+"..."+new String(buf));
		int num2 = fr.read(buf);
		System.out.println("num==="+num2+"..."+new String(buf));
		int num3 = fr.read(buf);
		System.out.println("num==="+num3+"..."+new String(buf));
		int num4 = fr.read(buf);
		System.out.println("num==="+num4+"..."+new String(buf));
		*/
		//String(char[] value, int offset, int count) 
		int num = 0;
		while((num = fr.read(buf))!=-1) {
			System.out.println(new String(buf,0,num));
		}
		fr.close();
	}

}
