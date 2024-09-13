package com.kh.member.sevice;

import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;

public class MemberService {

	public void loginMember(String userId, String userPwd){
		Connection conn = getConnection();
		new MemberDao().loginMember(conn, userId, userPwd);
	}
}
