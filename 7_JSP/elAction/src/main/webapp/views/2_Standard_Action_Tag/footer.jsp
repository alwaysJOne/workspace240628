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
		String year = new java.text.SimpleDateFormat("yyyy").format(new java.util.Date());
	%>
	
	Copyright © 1998-<%=year %> KH Information Educational Institute All Right Reserved
	test : ${param.test}
</body>
</html>