<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.model.vo.Person" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>JSTL Core Library</h1>
	
	<h3>1. 변수(속성 == attribute)</h3>
	<pre>
	*변수 선언과 동시에 초기화(c:set var="변수명" value="값" [scope="저장객체"])
	-변수 선언하고 초기값을 대입해두는 기능을 제공
	-해당 변수를 어떤 scope에 setAttribute를 통해 담아둘지 결정할 수 있다.
	=>c:set으로 선언한 변수는 접근할 때 무조건 EL로 접근해야한다.
	</pre>
	
	<c:set var="num1" value="10" /> <%-- <% pageContext.setAttribute("num1", 10); --%>
	<c:set var="num2" value="20" scope="request"/>
	num1 : ${ num1 }<br>
	num2 : ${ num2 }<br>
	
	<c:set var="result" value="${num1 + num2}" scope="session"/>
	result : ${result}<br><br>
	
	${pageScope.num1}<br>
	${requestScope.result} <br>	
	
	<pre>
	*변수 삭제(c:remove var="제거하고싶은 변수명" [scope=""])
	-해당 scope영역에 해당 변수를 찾아서 제거하는 태그
	-scope 지정 생략시 모든 scope에서 해당 변수를 다 찾아서 제거한다.
	=> 즉, 해당 scope에 .removeAttribute를 통해 제거하는 거라고 생각하면 된다.
	</pre>
	
	삭제전 : ${result}<br><br>
	
	1) 특정 scope지정해서 삭제
	<c:remove var="result" scope="request"/>
	request에서 삭제 후 request : ${result}<br><br>
	
	2) 모든 scope에서 삭제
	<c:remove var="result"/>
	모두 삭제 삭제 후 request : ${result}<br><br>
	
	<hr>
	
	<pre>
	*변수(데이터) 출력 (c:out value="출력하고자하는 값" [default="기본값"] [escapeXml="true | false"])
	=> 데이터를 출력하고자 할 때 사용하는 태그
	</pre>
	
	<c:out value="${result}"/><br>
	<c:out value="${result}" default="없음"/><br>
	
	<c:set var="outTest" value="<b>출력테스트</b>" />
	<c:out value="${outTest}" escapeXml="true" /><br>
	<c:out value="${outTest}" escapeXml="false" /><br>
	
	<hr>
	
	<h3>2. 조건문 - if(c:if test="조건식")</h3>
	<pre>
	-JAVA의 if문과 비슷한 역할을 하는 태그
	-조건식은 test속성에 작성(단, EL구문으로 기술해야한다.)
	</pre>
	
	<%-- 
	<% if(${num1} > ${num2}){ %>
		<b>num1이 num2보다 큽니다.</b>
	<%} %>
	--%>
	
	<c:if test="${num1 > num2 }">
		<b>num2가 num1보다 작습니다.</b>
	</c:if>
	
	<c:if test="${num1 < num2 }">
		<b>num2가 num1보다 큽니다.</b>
	</c:if>
	
	<br>
	
	<c:set var="str" value="안녕~?" />
	
	<c:if test="${str eq '안녕~?' }">
		<h4>그래 안녕!</h4>
	</c:if>
	
	<c:if test="${str ne '안녕~?' }">
		<h4>뭐지?</h4>
	</c:if>
	
	<h3>3. 조건문 - choose(c:choose, c:when, c:otherwise)</h3>
	
	<c:choose>
		<c:when test="${num1 > 30}">
			num1은 30보다 크다.
		</c:when>	
		<c:when test="${num1 > 20}">
			num1은 20보다 크다.
		</c:when>
		<c:when test="${num1 > 10}">
			num1은 10보다 크다.
		</c:when>
		<c:otherwise>
			모든 조건은 맞지않다.
		</c:otherwise>
	</c:choose>
	
	<h4>4.반복문 - forEach</h4>
	<pre>
	for loop문 - (c:forEach var="변수명" begin="초기값" end="끝값" [step="반복시증가값"])
	향상된 for문 - (c:forEach var="변수명" items="순차적으로 접근하고자하는 객체(배열/컬렉션)" [varStatus="현재접근된 요소의 상태값"])
	</pre>
	
	<%-- 
	<% for(int i=1; i<=10; i+=2){ %>
		1 3 5 7 9
	<%} %>
	--%>
	
	<c:forEach var="i" begin="1" end="10" step="2">
		반복확인 : ${i} <br>
	</c:forEach>
	
	<c:forEach var="i" begin="1" end="6">
		<h${i}>태그안에서 사용</h${i}>
	</c:forEach>
	
	<c:set var="colors">
		red,yellow,green,pink
	</c:set>
	
	colors :  ${colors }<br>
	
	<ul>
		<c:forEach var="c" items="${colors}">
			<li style="color : ${c}">${c}</li>
		</c:forEach>
	</ul>
	
	<%
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("홍길동", 18, "남자"));
		list.add(new Person("김개똥", 25, "여자"));
		list.add(new Person("최지원", 40, "여자"));
	%>
	
	<c:set var="pList" value="<%=list %>" scope="request" />
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>성별</th>
			</tr>
		</thead>
		<tbody>
		<%-- 
			<%for(Person p : list) {%>
				<tr>
					<td>-</td>
					<td><%=p.getName() %></td>
					<td><%=p.getAge() %></td>
					<td><%=p.getGender() %></td>
				</tr>
			<% }%>
		--%>
		<c:choose>
			<c:when test="${empty pList}">
				<tr><td colspan="4">조회된 사람이 없습니다.</td></tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="p" items="${pList}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${p.name }</td>
						<td>${p.age }</td>
						<td>${p.gender }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		</tbody>
	</table>
	
	<h5>5. 반복문 - forTokens</h5>
	<pre>
	(c:forTokens var="변수명" items="분리하고싶은 문자열" delims="구분자")
	
	-구분자를 통해서 분리된 가각의 문자열에 순차적으로 접근하면서 반복수행
	-JAVA의 문자열.split("구분자")과 비슷("최,지,원".split(",") -> ["최","지","원"])
	</pre>
	
	<c:set var="device" value="컴퓨터,노트북/핸드폰.모니터/냉장고" />
	
	<ol>
		<c:forTokens var="d" items="${device}" delims=",./">
			<li>${d}</li>
		</c:forTokens>
	</ol>
	
	<h3>6. url쿼리스트링</h3>
	<pre>
	-url경로를 생성하고, 쿼리스트링을 정의해둘 수 있는 태그
	
	c:url var="변수명" value="요청url"
		c:param name="키" value="값" /
		c:param name="키" value="값" /
		c:param name="키" value="값" /
	/c:url
	</pre>
	
	<a href="list.do?cpage=1&num=2">기존방식</a>
	
	<c:url var="listUrl" value="list.do">
		<c:param name="cpage" value="1" />
		<c:param name="num" value="2" />
	</c:url>
	<a href="${listUrl}">c:url이용방식</a>
</body>
</html>






