<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>jsp:include</h3>
	<p>또 다른 페이지를 포함하고자 할 때 쓰는 태그</p>
	
	<h4>1. 기존의 include 지시어를 이용한 방식(정적 include방식 == 컴파일시 애초에 포함되어있는 상태)</h4>
	
	<%--
	<%@ include file="footer.jsp" %>
	<br><br>
	
	특징 : include하고있는 페이지상에 선언되어있는 변수를 현재 페이지에서도 사용가능<br>
	include한 페이지의 year변수 : <%=year %><br><br>
	
	=> 단 현재 이 페이지에서 동일한 이름의 변수를 선언할 수 없다. <br>
	<% int year = 2024; %>
	--%>
	
	<h4>2. JSP표준액션 태그를 이용한 방식(동적 include == 런타임시 포함되는 형태)</h4>
	<jsp:include page="footer.jsp" />
	<br>
	
	특징 1. : include하고있는 페이지에 선언된 변수를 공유하지 않음 <br>
	=> 동일한 이름의 변수로 재선언이 가능하다. <br><br>
	<% int year = 2024; %>
	
	특징 2. : 포함시 include하는 페이지로 값을 전달할 수 있음<br>
	<jsp:include page="footer.jsp" >
		<jsp:param name="test" value="hi" />
	</jsp:include>
</body>
</html>








