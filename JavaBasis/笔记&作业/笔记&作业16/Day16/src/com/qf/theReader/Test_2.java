package com.qf.theReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test_2 {
//字符流 拷贝文本文件
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//创建 读入流 先获取文件内容
		FileReader fr = new FileReader("demo.txt");
		//创建 写出流 明确文件拷贝的目的地
		FileWriter fw = new FileWriter("abc.txt");
		
		int ch = 0;
		while((ch = fr.read())!=-1) {//循环读取
			fw.write(ch);//写入目的地
		}
		fr.close();
		fw.close();
	}
	public static void demo() throws IOException{
		FileReader fr = new FileReader("demo.txt");
		FileWriter fw = new FileWriter("abc.txt");
		char[] arr = new char[1024];
		int len = 0;
		while((len = fr.read(arr))!=-1) { //将文件上的数据读取到字符数组中
			fw.write(arr,0,len);//将字符数组中的数据写到目的地文件上
		}
		fr.close();
		fw.close();
	}
}
