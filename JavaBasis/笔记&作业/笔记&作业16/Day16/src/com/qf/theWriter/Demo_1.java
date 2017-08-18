package com.qf.theWriter;

import java.io.FileWriter;
import java.io.IOException;

public class Demo_1 {

	public static void main(String[] args) {
		// FileWriter(String fileName) 
		//创建一个FileWriter对象 该对象一被初始化 就必须要明确备操作的文件
		FileWriter fw = null;
		try {
			fw = new FileWriter("demo.txt");
			//改文件会被创建到指定的目录下 如果该目录下已有同名文件 将被覆盖
			//其实 该步就是在明确数据要存放的目的地
			//调用write方法 将字符串写入到流中
			fw.write("abc");
			fw.write("def");
			//刷新流对象中缓冲的数据
			//将数据刷到目的地中
			fw.write("dddddf");
			fw.write("wwww");
			//Writer append(char c) 追加
			fw.append("星期一");
		}catch(IOException e) {
			System.out.println("catch::"+e.toString());
		}finally {
		
			try {
					if(fw!=null)
						fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//关闭流资源 但是关闭之前 会先刷新一次内部的缓冲数据
		//将数据刷到目的地中
		//和flush的区别 flush刷新后 流可以继续使用 close刷新后 会将流关闭
	}

}
