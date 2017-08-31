package com.qf.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.qf.c3p0.C3P0Utils;

//���� ����:
//ת�� ��tom���˻���ת��100 ���뵽jerry���˻���
public class Demo_03 {

	public static void main(String[] args) {
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		try {
			conn = C3P0Utils.getConnection();
			//1.mysql����Ĭ�����Զ��ύ��  ��������ύ��ʽ��Ϊ�ֶ��ύ
			conn.setAutoCommit(false);//����Ϊfalse ������Ϊ�ǿ���������
			pstmt = conn.prepareStatement("update account set money=money-100 where name='tom'");
			pstmt.executeUpdate();
			int i = 1/0;//�˴������쳣 ���治��ִ��
			pstmt = conn.prepareStatement("update account set money=money+100 where name='jerry'");
			pstmt.executeUpdate();
			
			//2.�ֶ��ύ���� ����Ľ�����ʽһ
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			if(conn!=null){
				try {
					//2.�ع����� ���try�еĴ�������쳣 ��catch ��ô��catch��������Ļع� ����Ľ�����ʽ��
					//��������쳣 �ͽ������ݻع�
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
	}

}
