package com.qf.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.qf.bean.Emp;
import com.qf.utils.DBUtils;

/*��ҳʵ��
 * ��һ�ν��� ��ʾ ҳ�� �� ��һҳ������
 * Ȼ�� ͨ������¼�� ҳ�� �� ��ȡ ָ��ҳ������ (���� ���ҳ�� ִ����ת)
 * 
 * ���� ͨ������ ������Ҫ ���� �ĸ�����
 * 1.pageSize ÿҳ��ʾ��¼��
 * 2.total �ܼ�¼�� 
 * 3.pageCount ��ҳ��
 * 4.pageNo ҳ��
 * ��������
 * 	1.��ȡ��һҳ������
 *  2.���������ҳ�� ȥ��ȡָ��ҳ������
 * */
public class Demo_Page {
	private static int pageSize = 3; //ÿҳ��ʾ3��
	private static int total;//������
	private static int pageCount; // ��ҳ��
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			//�������ݿ� ��ȡ������
			conn = DBUtils.getConnection();
			String sql = "select count(*) from emp";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				total = rs.getInt(1);
			}
			//���������� �� ÿҳ��ʾ�� ���� ҳ��  ����ȡ�� ceil()���� �������double���� ������Ҫ*1.0
			//����ֵ Ҳ��double���� ��Ҫǿת��int
			pageCount = (int)Math.ceil(total*1.0/pageSize);
			//��ӡҳ��
			for(int i=1;i<=pageCount;i++){
				System.out.print(i+" ");
			}
			System.out.println();
			
			//����һ��ҳ�� ��ѯ��һ�ν��������� ��һҳ
			int pageNo = 1;
			print(pageNo);
			
			//����¼��ҳ�� ��ʾ��ͬҳ��
			do{
				System.out.println("������ҳ��");
				Scanner sc = new Scanner(System.in);
				pageNo = sc.nextInt();
				if(pageNo<=pageCount && pageNo>0){
					print(pageNo);
				}else{
					System.out.println("ҳ���������");
				}
			}while(pageNo<=pageCount && pageNo>0);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private static void print(int pageNo){
		List<Emp> dataList = getData(pageNo);
		
		Iterator<Emp> it = dataList.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	//���� �����б� pageNo ����ֵ���� List ������ getData
	public static List<Emp> getData(int pageNo){
		List<Emp> list = new ArrayList<>();
		try{
			Connection conn = DBUtils.getConnection();
			String sql = "select * from emp limit ?,?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNo-1)*pageSize);
			pstmt.setInt(2, pageSize);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString("job"));
				emp.setBiredate(rs.getDate("biredate"));
				emp.setSal(rs.getInt("sal"));
				list.add(emp);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}












