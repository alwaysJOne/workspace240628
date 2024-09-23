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

        .list-area > tbody > tr:hover{
            background: gray; 
            cursor: pointer;
        }
    </style>
</head>
<body>
    <%@ include file="../common/menubar.jsp"%>

    <div class="outer">
        <br>
        <h2 align="center">일반게시판</h2>
        <br>
        
        <% if( loginUser != null ) { %>
	        <div align="right" style="width: 850px; margin-bottom: 4px;">
	        	<a href="<%=contextPath%>/enrollForm.bo" class="btn btn-sm btn-secondary">글쓰기</a>
	        </div>
        <% } %>
        
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
	                    <tr onclick="clickDetailPage(<%=b.getBoardNo()%>)">
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
        <script>
            //contextPath/detail.bo?bno=?
            function clickDetailPage(boardNo){
                location.href = "<%=contextPath%>/detail.bo?bno=" + boardNo;
            }

            // const trList = document.querySelectorAll(".list-area>tbody>tr");
            // for(let tr of trList){
            //     tr.onclick = function(){

            //         console.log(this.children[0].innerText)
            //     }
            // }
        </script>
        
        <br><br>
        <div align="center">
        	<%if(currentPage > 1) { %>
            	<button onclick="location.href='<%=contextPath%>/list.bo?cpage=<%=currentPage - 1%>'">&lt;</button>
            <% } %>
            <% for(int p = startPage; p <= endPage; p++) { %>
                <% if(p == currentPage) { %>
                    <button disabled><%=p%></button>
                <% } else {%>
                    <button onclick="location.href='<%=contextPath%>/list.bo?cpage=<%=p%>'"><%=p%></button>
                <% } %>
            <% } %>
            <%if(currentPage < maxPage) { %>
            	<button onclick="location.href='<%=contextPath%>/list.bo?cpage=<%=currentPage + 1%>'">&gt;</button>
        	<% } %>
        </div>
    </div>

</body>
</html>