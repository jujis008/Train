package com.qf.theReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test_2 {
//�ַ��� �����ı��ļ�
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//���� ������ �Ȼ�ȡ�ļ�����
		FileReader fr = new FileReader("demo.txt");
		//���� д���� ��ȷ�ļ�������Ŀ�ĵ�
		FileWriter fw = new FileWriter("abc.txt");
		
		int ch = 0;
		while((ch = fr.read())!=-1) {//ѭ����ȡ
			fw.write(ch);//д��Ŀ�ĵ�
		}
		fr.close();
		fw.close();
	}
	public static void demo() throws IOException{
		FileReader fr = new FileReader("demo.txt");
		FileWriter fw = new FileWriter("abc.txt");
		char[] arr = new char[1024];
		int len = 0;
		while((len = fr.read(arr))!=-1) { //���ļ��ϵ����ݶ�ȡ���ַ�������
			fw.write(arr,0,len);//���ַ������е�����д��Ŀ�ĵ��ļ���
		}
		fr.close();
		fw.close();
	}
}
