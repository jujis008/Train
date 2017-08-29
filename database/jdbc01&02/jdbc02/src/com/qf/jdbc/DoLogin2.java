package com.qf.jdbc;

import java.sql.*;

import com.qf.bean.User;
import com.qf.utils.DBUtils;
//ʹ�� PreparedStatement �� ����sqlע��
public class DoLogin2 {
	//���ݴ����user������ username �� password �������ݿ� ����ƥ��
	public User findUser(User u){
		User user = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtils.getConnection();
			//����PreparedStatement���� ��װsql���
			pstmt = conn.prepareStatement("select * from user where username=? and password=?");
			//���ʺŸ�ֵ ����������1��ʼ
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());
			System.out.println(pstmt.toString());
			//ִ�в����ؽ����
			rs = pstmt.executeQuery();
			if(rs.next()){
				user = new User();
				user.setId(rs.getInt(1));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, pstmt, conn);
		}
		return user;
	}
}
