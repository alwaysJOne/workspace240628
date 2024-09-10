<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//스크립틀릿(scriptlet) -> html문서내에서 자바코드를 쓸 수 있는 영역
		String name = (String)request.getAttribute("name");
		int age = (Integer)request.getAttribute("age");
	%>
	
	<h1>개인정보 응답화면</h1>
	<span id="name"><%=name %></span>님은
	<%= age%>살입니다.
</body>
</html>