<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.common.PageInfo, java.util.ArrayList, com.kh.board.model.vo.Board" %>
<%
    PageInfo pi = (PageInfo)request.getAttribute("pi");
    ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");

    int currentPage = pi.getCurrentPage();
    int startPage = pi.getStartPage();
    int endPage = pi.getEndPage();
    int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>일반게시판</title>

    <style>
        .outer{
            background: black;
            color: white;
            width: 1000px;
            margin: auto;
            margin-top: 50px;
            padding: 10px 0 50px 0px;
        }

        .list-area{
            border: 1px solid white;
            text-align: center;
        }
    </style>
</head>
<body>
    <%@ include file="../common/menubar.jsp"%>

    <div class="outer">
        <br>
        <h2 align="center">일반게시판</h2>
        <br>
        <table align="center" class="list-area">
            <thead>
                <th width="70">글번호</th>
                <th width="80">카테고리</th>
                <th width="300">제목</th>
                <th width="100">작성자</th>
                <th width="50">조회수</th>
                <th width="100">작성일</th>
            </thead>
            <tbody>
            	<% if(list.isEmpty()) { %>
            		<tr>
            			<td colspan="6">존재하는 게시글이 없습니다.</td>
            		</tr>
            	<% } else { %>
	                <% for(Board b : list) { %>
	                    <tr>
	                        <td><%=b.getBoardNo()%></td>
	                        <td><%=b.getCategory()%></td>
	                        <td><%=b.getBoardTitle()%></td>
	                        <td><%=b.getBoardWriter()%></td>
	                        <td><%=b.getCount()%></td>
	                        <td><%=b.getCreateDate()%></td>
	                    </tr>
	                <% } %>
	           <% } %>
            </tbody>
        </table>
        
        <br><br>
        <div align="center">
            <button>&lt;</button>
            <% for(int p = startPage; p <= endPage; p++) { %>
                <% if(p == currentPage) { %>
                    <button disabled><%=p%></button>
                <% } else {%>
                    <button onclick="location.href='<%=contextPath%>/list.bo?cpage=<%=p%>'"><%=p%></button>
                <% } %>
            <% } %>
            <button>&gt;</button>
        </div>
    </div>

</body>
</html>