package test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Run {

	/*
	 * JDBC를 사용하기 위해서는 자바 프로젝트에 JDBC드라이버를 추가해줘야한다.
	 * 
	 * *JDBC용 객체
	 * - Connection : DB의 연결정보를 담고있는 객체
	 * - [Prepared]Statement : 연결된 DB에 sql문을 전달해서 실행하고, 결과를 받아내는 객체
	 * - ResultSet : SELECT문 실행 후 조회된 결과물을 담는 객체
	 * 
	 * *JDBC 과정
	 * 1) JDBC Driver등록 : 해당 DMBS(오라클)가 제공하는 클래스 등록
	 * 2) Connection생성 : 연결하고자하는 db정보를 입력해서 해당 db와 연결할 수 있는 객체
	 * 3) Statement생성 : Connection객체를 이용해서 생성
	 * 4) sql문 전달하면서 실행 : Statment객체를 이용해서 sql문 실행
	 * 5) 결과받기 > select문 실행(6_1) -> ResultSet객체, DML문 실행(6_2) -> int
	 * 
	 * 6_1) ResultSet객체에 담겨있는 데이터들을 하나하나 추출해서 옮겨담기[ArrayList에 담기]
	 * 6_2) 트랜잭션 처리(성공했으면 commit, 실패했다면 rollback 실행)
	 * 
	 * 7)다 사용한 JDBC용 객체를 반드시 자원 반납(close) -> 생성된 역순으로
	 * 
	 * */
	public static void main(String[] args) {
		/*
		// 1. 내 pc에 jdbc계정 연결 후 TEST테이블에 insert해보기
		
		Scanner sc = new Scanner(System.in);
		System.out.print("번호 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		Connection conn = null;
		Statement stmt = null;
		
		//실행할 sql문(완전한 상태로 slq문을 구성해준다/ 맨뒤에 ;생략!!!!!!!!!!!!!!!!!!)
		String sql = "INSERT INTO TEST VALUES(" + num + ", '" + name + "', SYSDATE)";
		

		try {
			//1) JDBC Driver등록
			Class.forName("oracle.jdbc.driver.OracleDriver"); //ojdbc11.jar파일을 추가하지 않거나 오타가 있으면 -> 에러
			System.out.println("OracleDriver 등록 성공");
			
			//2) Connection생성(url, 계정명, 비밀번호)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			//3) Statement생성
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			
			//4, 5)) sql문 전달하면서 실행 후 결과 받기
			int result = stmt.executeUpdate(sql);
			//내가 실행할 sql문이 DML(insert, update, delete) -> stmt.executeUpdate(sql문) : int
			//내가 실행할 sql문이 select문 -> stmt.executeQuery(select문) : ResultSet
			if (result > 0) { // 요청성공
				conn.commit();
			} else { //요청실패
				conn.rollback();
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//7)  다쓴 JDBC용 객체를 반납(생성과 역순으로)
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		*/
		
		
		// 2. 내 pc에 있는 db에서 jdbc계정에 연결해 TEST테이블의 모든 데이터 조회해오기
		//필요한 변수들 세팅
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		//실행할 sql문
		String sql = "SELECT * FROM TEST";
		
		try {
			//1) JDBC Driver등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//ojdbc11.jar파일을 추가하지 않거나 오타가 있으면 -> 에러
			System.out.println("OracleDriver 등록 성공");
			
			//2) Connection생성(url, 계정명, 비밀번호)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			//3) Statement생성
			stmt = conn.createStatement();
			
			//4, 5) SQL문 전달해서 실행 후 결과값 받기(RsultSet)
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				int num = rset.getInt("NUM");
				String name = rset.getString("NAME");
				Date birth = rset.getDate("BIRTH");
				
				System.out.println(num + " " + name + " " + birth);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
