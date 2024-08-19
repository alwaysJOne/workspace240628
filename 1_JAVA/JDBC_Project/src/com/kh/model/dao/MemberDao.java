package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.model.vo.Member;

//DAO(Data Access Object) : db에 직접적으로 접근해서 사용자의 요청에 맞는 sql문 실행 후 결과 반환(JDBC)
public class MemberDao {

	/**
	 * 
	 * @param Member m : 사용자가 입력한 값들이 담겨있는 member객체
	 * @return : insert문 실행 후 처리된 행 수
	 */
	public int insertMember(Member m) {
		//insert문 => 처리된 행수(int) => 트랜잭션
		
		//필요한 변수 먼저 센팅
		int result = 0; // 처리된 결과를 받아줄 변수
		Connection conn = null; //연결된 db정보를 담는 객체
		//Statement stmt = null; // 완성된 sql문 전달해셔 곧바로 실행 후 결과를 받는 객체
		PreparedStatement pstmt = null; // 미완성 sql문을 통해서 객체생성 후 객체의 메소드를 이용해 완성가능
		
		//미완성 SQL문
		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, ?, ?, ?, ?, ? ,? ,? ,? ,?, SYSDATE)";
		
//		String sql = "INSERT INTO MEMBER VALUES("
//				+ "SEQ_USERNO.NEXTVAL,"
//				+ "'" + m.getUserId() + "',"
//				+ "'" + m.getUserPwd() + "',"
//				+ "'" + m.getuserName() + "',"
//				+ "'" + m.getGender() + "',"
//				+ m.getAge() + ","
//				+ "'" + m.getEmail() + "',"
//				+ "'" + m.getPhone() + "',"
//				+ "'" + m.getAddress() + "',"
//				+ "'" + m.getHobby() + "',"
//				+ "SYSDATE)";
		
		
		try {
			//1) JDBC Driver등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2)Connection객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			conn.setAutoCommit(false);//수동커밋 설정
			
			//3) Statement객체 생성 -> PreparedStatement
			//미완성 sql문을 전달(필요한 요소중 일부가 ?로 채워져있음)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getuserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
			
			//4,5) sql로 전달하면서 실행 후 값 받아오기
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	public List<Member> selectMemberList() {
		//select문(여러행 조회) -> ResultSet객체 -> ArrayList<Member>에 담기
		
		//필요한 변수들 세팅
		List<Member> list = new ArrayList<>(); // 비어있는상태
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset =null; //select문 실행시 조회된 결과값들이 최초로 담기는 공간
		
		//실행할 sql
		String sql = "SELECT * FROM MEMBER";
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2)Connection객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			conn.setAutoCommit(false);//수동커밋 설정
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				Member m = new Member();
				m.setUserNo(rset.getInt("USER_NO"));
				m.setUserId(rset.getString("USER_ID"));
				m.setUserPwd(rset.getString("USER_PWD"));
				m.setuserName(rset.getString("USER_NAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLL_DATE"));
				//현재 참조하고있는 행에 대한 모든 컬럼에 데이터들을 한 Member객체에 담기
				
				list.add(m);
			}
			
			//반복문이 끝난 시점
			//조회된 데이터가 없다면 list -> 비어있을 것이다.
			//조회된 데이터가 있다면 전부 list에 담겨있을 것이다.
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public int updateMember(Member m) {
		//update문 -> 처리된 행 수(int)
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		/*
		 * update member
		 * set user_pwd = 'xxxx', email = 'xxxx', phone = 'xxxxxx', address = 'xxxxx'
		 * where user_id = 'xxx'
		 */
		
		String sql = "UPDATE MEMBER "
					+ "SET USER_PWD = ?,"
						+ "EMAIL = ?,"
						+ "PHONE = ?,"
						+ "ADDRESS = ?"
					+ "WHERE USER_ID = ?";
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2)Connection객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			conn.setAutoCommit(false);//수동커밋 설정
			
			//sql -> 미완성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserPwd());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getUserId());
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int deleteMember(String userId) {
		//delete문 => 처리된 행 수
		
		int result = 0;
		
		Connection conn = null;
		Statement stmt = null;
		
		String sql = "DELETE FROM MEMBER WHERE USER_ID = '" + userId + "'";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			
			result = stmt.executeUpdate(sql);
			
			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}









