package com.qf.theWriter;

import java.io.FileWriter;
import java.io.IOException;

public class Demo_2 {
//�������ļ���׷������ ����ԭ�ļ�����
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//FileWriter(String fileName, boolean append) 
		//����������һ��true ���� �����������е��ļ� �������е��ļ�ĩβ ׷������ 
		FileWriter fw = new FileWriter("demo.txt",true);
		fw.write("he\r\nllo");
		//ע�� txt�ı��ĵ��ǲ��Ǳ�\n�� ֻ�����һ���ڷ��� windows��Ҫ\r\n
		fw.close();
	}

}
