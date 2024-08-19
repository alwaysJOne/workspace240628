package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}









