<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.board.model.vo.Category, java.util.ArrayList"%>
<%
	ArrayList<Category> list = (ArrayList<Category>)request.getAttribute("categorys");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
    .outer{
        background: black;
        color: white;
        width: 1000px;
        margin: auto;
        margin-top: 50px;
        padding: 10px 0 50px 0px;
    }

    .outer table{
        border: 1px solid white;
        border-collapse: collapse;
    }
    .outer > table tr, .outer > table td{
        border: 1px solid white;
    }
    .outer > form input, .outer > form textarea{
        width: 100%;
        box-sizing: border-box;
    }
</style>

</head>
<body>

    <%@ include file="../common/menubar.jsp" %>
    <div class="outer">
        <br>
        <h2 align="center">일반게시글 작성하기</h2>
        <br>

        <form action="<%=contextPath%>/insert.bo" method="post" enctype="multipart/form-data">
            <input type="hidden" name="userName" value="<%=loginUser.getUserNo()%>">
            <table border="1" align="center">
                <tr>
                    <th width="70">카테고리</th>
                    <td width="500">
                        <select name="category">
                        	<% for(Category c : list) { %>
                            	<option value="<%=c.getCategoryNo()%>"><%=c.getCategoryName() %></option>
                            <% } %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>제목</th>
                    <td>
                        <input type="text" name="title" required>
                    </td>
                </tr>
                <tr></tr>
                    <th>내용</th>
                    <td>
                        <textarea name="content" rows="10" style="resize: none;"></textarea>
                    </td>
                </tr>
                <tr>
                    <th>청부파일</th>
                    <td>
                        <input type="file" name="upfile">
                    </td>
                </tr>
            </table>
            <br>

            <div align="center">
                <button type="submit">작성하기</button>
                <button type="reset">취소하기</button>
            </div>
        </form>
    </div>
</body>
</html>