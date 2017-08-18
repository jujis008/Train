package com.qf.theReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo_1 {
//读取方式一
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("demo.txt");
		// int read() 
		/*
		int ch1 = fr.read();
		System.out.println((char)ch1);
		int ch2 = fr.read();
		System.out.println((char)ch2);
		int ch3 = fr.read();
		System.out.println((char)ch3);
		int ch4 = fr.read();
		System.out.println(ch4);
		fr.close();*/
		/*
		while(true) {
			int ch = fr.read();
			if(ch==-1) {
				break;
			}
			System.out.println("ch=="+(char)ch);
		}*/
		int ch = 0;
		while((ch=fr.read())!=-1) {	
			System.out.println("ch=="+(char)ch);
		}
	}

}
