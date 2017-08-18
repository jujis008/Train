package com.qf.theWriter;

import java.io.FileWriter;
import java.io.IOException;

public class Demo_2 {
//在已有文件后追加内容 不将原文件覆盖
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//FileWriter(String fileName, boolean append) 
		//构造器传入一个true 参数 代表不覆盖已有的文件 并在已有的文件末尾 追加内容 
		FileWriter fw = new FileWriter("demo.txt",true);
		fw.write("he\r\nllo");
		//注意 txt文本文档是不是别\n的 只会输出一个黑方块 windows需要\r\n
		fw.close();
	}

}
