<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	
	<!-- JavaScript -->
<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>

<!-- CSS -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css"/>
<!-- Default theme -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css"/>
<!-- Semantic UI theme -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/semantic.min.css"/>
<!-- Bootstrap theme -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/bootstrap.min.css"/>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> 
    
<style>
    #header{
        width:80%;
        height:100px;
        padding-top: 20px;
        margin:auto;
    } 
    #header>div{width:100%; margin-bottom:10px}
    #header_1{height:40%;}
    #header_2{height:60%;}

    #header_1>div{
        height:100%;
        float:left;
    }
    #header_1_left{width:150px;position:relative;}
    #header_1_center{width:calc(100% - 420px);}
    #header_1_right{width:270px;}

    #header_1_left>img{height:80%;position:absolute;margin:auto;top:0;bottom:0;right: 0;left:0;}
    #header_1_right{text-align: right; line-height:35px; font-size: 12px;}
    #header_1_right>a{margin: 5px;}
    #header_1_right>a:hover{cursor: pointer;}
    
    #header_2>ul{width:100%; height:100%; list-style-type: none; margin: auto; padding:0;}
    #header_2>ul>li{float:left; width:25%; height:100%; line-height: 55px; text-align:center;}
    #header_2>ul>li a{text-decoration: none; color:black; font-size: 18px; font-weight: 900;}

    #header_2{border-top:1px solid lightgray}

    #header a{text-decoration:none; color:black}
    
    /* 세부 페이지마다 공통적으로 유지할 style */
    div{box-sizing: border-box;}
    
    .content{
        background-color:rgb(247, 245, 245);
        width:80%;
        margin:auto;
    }
    .innerOuter{
        border:1px solid lightgray;
        width:80%;
        margin:auto;
        padding:5% 10%;
        background:white;
    }

</style>
</head>
<body>

	<c:if test="${ not empty alertMsg}">
		<script>
			alert("${alertMsg}");
		</script>
		<c:remove var="alertMsg" scope="session"/>
	</c:if>

	<div id="header">
        <div id="header_1">
            <div id="header_1_left">
                <img src="https://www.iei.or.kr/resources/images/common/top_logo_s.jpg" alt="" onclick="location.href='${ pageContext.servletContext.contextPath }';">
            </div> 
            <div id="header_1_center"></div>
            <div id="header_1_right">
	            <c:choose>
	            	<c:when test="${empty loginUser}">
		                <!-- 로그인 전 -->
		                <a href="enrollForm.me">회원가입</a>
		                <a data-toggle="modal" data-target="#loginModal">로그인</a> 
	            	</c:when>
	                <c:otherwise>
		                <!-- 로그인 후 -->
		                <label>${loginUser.userName}님 환영합니다</label> &nbsp;&nbsp;
		                <a href="myPage.me">마이페이지</a>
		                <a href="logout.me">로그아웃</a>
	                </c:otherwise>
	            </c:choose>         
            </div>
        </div>
        <div id="header_2">
            <ul>
                <li><a href="">HOME</a></li>
                <li><a href="">공지사항</a></li>
                <li><a href="list.bo">자유게시판</a></li>
                <li><a href="">사진게시판</a></li>
            </ul>
        </div>
    </div>

    <!-- 로그인 클릭 시 뜨는 모달  -->
    <div class="modal fade" id="loginModal">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Login</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button> 
            </div>

            <form action="login.me" method="post">
                <!-- Modal Body -->
                <div class="modal-body">
                    <label for="userId" class="mr-sm-2">ID :</label>
                    <input type="text" class="form-control mb-2 mr-sm-2" placeholder="Enter ID" id="userId" name="userId" value="${cookie.saveId.value}"> 
                    <input type="checkbox" name="saveId" id="saveId" checked>
                    <label for="saveId" class="mr-sm-2">아이디저장</label>
                    <br>
                    <label for="userPwd" class="mr-sm-2">Password:</label>
                    <input type="password" class="form-control mb-2 mr-sm-2" placeholder="Enter password" id="userPwd" name="userPwd">
                </div>
                
                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">로그인</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
                </div> 
            </form>
            </div>
        </div>
    </div>

    <br clear="both">
</body>
</html>