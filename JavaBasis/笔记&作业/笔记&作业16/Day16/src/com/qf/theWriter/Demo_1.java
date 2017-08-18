package com.qf.theWriter;

import java.io.FileWriter;
import java.io.IOException;

public class Demo_1 {

	public static void main(String[] args) {
		// FileWriter(String fileName) 
		//����һ��FileWriter���� �ö���һ����ʼ�� �ͱ���Ҫ��ȷ���������ļ�
		FileWriter fw = null;
		try {
			fw = new FileWriter("demo.txt");
			//���ļ��ᱻ������ָ����Ŀ¼�� �����Ŀ¼������ͬ���ļ� ��������
			//��ʵ �ò���������ȷ����Ҫ��ŵ�Ŀ�ĵ�
			//����write���� ���ַ���д�뵽����
			fw.write("abc");
			fw.write("def");
			//ˢ���������л��������
			//������ˢ��Ŀ�ĵ���
			fw.write("dddddf");
			fw.write("wwww");
			//Writer append(char c) ׷��
			fw.append("����һ");
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
		//�ر�����Դ ���ǹر�֮ǰ ����ˢ��һ���ڲ��Ļ�������
		//������ˢ��Ŀ�ĵ���
		//��flush������ flushˢ�º� �����Լ���ʹ�� closeˢ�º� �Ὣ���ر�
	}

}
