<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	쿠키생성완료
	
	<c:if test="${not empty cookie.test}">
		${cookie.test.value}
	</c:if>
	
	<script>
		function setCookie(name, value, days){
			const d = new Date(); //오늘
			d.setTime(d.getTime() + (days * 24 * 60 * 60 * 1000)) //days일 후의 시간
			const expires = "expires=" + d.toUTCString();
			document.cookie = name + "=" + value + ";" + expires + ";path=/";
		}
		
		setCookie("thema", "black", 30)
	</script>
</body>
</html>