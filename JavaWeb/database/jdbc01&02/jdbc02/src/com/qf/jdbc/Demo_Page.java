package com.qf.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.qf.bean.Emp;
import com.qf.utils.DBUtils;

/*分页实现
 * 第一次进来 显示 页码 和 第一页的数据
 * 然后 通过键盘录入 页码 来 获取 指定页的数据 (仿照 点击页码 执行跳转)
 * 
 * 首先 通过分下 我们需要 定义 四个变量
 * 1.pageSize 每页显示记录数
 * 2.total 总记录数 
 * 3.pageCount 总页数
 * 4.pageNo 页码
 * 方法分析
 * 	1.获取第一页的数据
 *  2.根据输入的页码 去获取指定页的数据
 * */
public class Demo_Page {
	private static int pageSize = 3; //每页显示3条
	private static int total;//总行数
	private static int pageCount; // 总页数
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			//连接数据库 获取总行数
			conn = DBUtils.getConnection();
			String sql = "select count(*) from emp";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				total = rs.getInt(1);
			}
			//根据总行数 和 每页显示数 计算 页数  向上取整 ceil()方法 传入的是double类型 所以需要*1.0
			//返回值 也是double类型 需要强转成int
			pageCount = (int)Math.ceil(total*1.0/pageSize);
			//打印页码
			for(int i=1;i<=pageCount;i++){
				System.out.print(i+" ");
			}
			System.out.println();
			
			//定义一个页码 查询第一次进来的数据 第一页
			int pageNo = 1;
			print(pageNo);
			
			//键盘录入页码 显示不同页面
			do{
				System.out.println("请输入页码");
				Scanner sc = new Scanner(System.in);
				pageNo = sc.nextInt();
				if(pageNo<=pageCount && pageNo>0){
					print(pageNo);
				}else{
					System.out.println("页码输入错误");
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
	//方法 参数列表 pageNo 返回值类型 List 方法名 getData
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












