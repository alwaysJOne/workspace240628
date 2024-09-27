<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>

 	<!-- jQuery -->
    <script 
        src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
        crossorigin="anonymous"></script>
    <script
        src="https://code.jquery.com/ui/1.14.0/jquery-ui.min.js"
        integrity="sha256-Fb0zP4jE3JHqu+IBB9YktLcSjI1Zc6J2b6gTjB0LpoM="
        crossorigin="anonymous"></script>
        
    <!-- 부트스트램 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
 
 
	<style>
	    .login-area a{
	        text-decoration: none;
	        color: black;
	        font-size: 12px;
	    }
	
	    .nav-area{
	        background: black;
	        color: white;
	        height: 50px;
	    }
	    .menu{
	        display: table-cell;
	        width: 250px;
	        height: 50px;
	        vertical-align: middle;
	        font-size: 20px;
	        font-weight: bold;
	    }
	    .outer{
	    	width: 900px;
	    	background: black;
	    	color: white;
	    	margin: auto;
	    	margin-top: 50px;
	    }
	</style>
</head>
<body>

    <h1 align="center">welcome to Mybatis World</h1>
    <br>

    <div class="login-area" align="right">
    	<c:choose>
    		<c:when test="${ empty loginUser }">
		        <!-- 로그인전 -->
		        <form action="login.me" method="post">
			        <table>
			            <tr>
			                <td>아이디</td>
			                <td><input type="text" name="userId" required></td>
			                <td rowspan="2"><button type="submit" style="height: 50px;">로그인</button></td>
			            </tr>
			            <tr>
			                <td>비밀번호</td>
			                <td><input type="password" name="userPwd" required></td>
			                
			            </tr>
			            <tr>
			                <td colspan="3" align="center">
			                    <a href="enrollForm.me">회원가입</a>
			                    <a href="">아이디/비번찾기</a>
			                </td> 
			            </tr>
		            </table>
		        </form>
	     	</c:when>
	       	<c:otherwise>
		        <!-- 로그인후 -->
		        <div>
		            <table>
		                <tr>
		                    <td colspan="2">
		                        <h3>${loginUser.userName}님 환영합니다. </h3>
		                    </td>
		                    <td></td>
		                </tr>
		                <tr>
		                    <td><a href="">마이페이지</a></td>
		                    <td><a href="">로그아웃</a></td>
		                </tr>
		            </table>
		        </div>
	        </c:otherwise>
        </c:choose>
    </div>
    <br>

    <div class="nav-area" align="center">
        <div class="menu">HOME</div>
        <div class="menu">공지사항</div>
        <div class="menu"><a onclick="location.href='list.bo?cpage=1'">게시판</a></div>
        <div class="menu">ETC</div>
    </div>
</body>
</html>