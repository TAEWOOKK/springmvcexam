package com.ezen.biz.dao;

import java.sql.*;

import org.springframework.stereotype.Repository;

import com.ezen.biz.common.JDBCUtil;
import com.ezen.biz.dto.UserVO;

@Repository("userDAO")
public class UserDAO {
	// JDBC ���� ����
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	// SQL ��ɾ��
	private static final String USER_GET = "select * from users where id=? and password=?";
	private static final String USER_INSERT = "insert into users values(?,?,?,?)";
	
	public UserVO getUser(UserVO vo) {
		System.out.println("===> JDBC�� getUser() ó��");
		UserVO result = null;
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement(USER_GET);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {	//��ȸ�� ����� ������ UserVO ��ü�� �����Ѵ�.
				result = new UserVO();
				result.setId(rs.getString("id"));
				result.setPassword(rs.getString("password"));
				result.setName(rs.getString("name"));
				result.setRole(rs.getString("role"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return result;
	}
	
	public void insertUser(UserVO vo) {
		System.out.println("===> JDBC�� insertUser() ó��");
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement(USER_INSERT);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getRole());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4.�����ͺ��̽� ���� ����
			JDBCUtil.close(conn, pstmt);
		}
		
	}
}
