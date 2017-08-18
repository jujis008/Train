package com.qf.theReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo_2 {
//读取方式二 int read(char[] cbuf)  //int 返回的是读取的字符的个数
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("demo.txt");
		char[] buf = new char[1024];
		// 1个字符是2个字节 数组大小 一般定义为 1024或者 1024的整数倍
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
