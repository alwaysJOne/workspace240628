<%@page import="com.kh.common.JDBCTemplate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 
		*회원서비스
					| C(Insert) | R(Select) | U(Update) | D(Delete) |
		==============================================================================
		   로그인		|			| 	o		|			|			|
		   회원가입    |	o		| 			|			|			|
		  마이페이지	|			| 	o		|			|			|
		   정보수정	|			| 			|	o		|			|
		   회원탈퇴	|			| 			|	o		|			|
		[아이디중복체크] |			| 	o		|			|			|
		
		*공지사항
		공지사항 리스트 조회(R) / 상세조회(R)
		공지사항 작성(C) / 공지사항 수정(U) / 공지사항 삭제(U)
		
		*일반게시판
		게시글 리스트 조회(R) - 페이징처리 / 상세조회(R)
		게시글 작성(C) / 게시글 수정(U) / 게시글 삭제(U)
		[댓글리스트 조회(R) / 댓글작성(C)]
		
		*사진게시판 
		게시판 리스트 조회(R) - 썸네일형식 / 상세조회(R)
		게시글 작성(C) - 첨부파일업로드
 	-->
 	
 	<%-- JDBCTemplate.getConnection(); --%>
 	
 	<%@ include file="views/common/menubar.jsp" %>
</body>
</html>