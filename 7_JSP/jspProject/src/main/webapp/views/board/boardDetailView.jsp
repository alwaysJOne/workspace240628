<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.board.model.vo.Board, com.kh.board.model.vo.Attachment" %>

<%
    Board b = (Board)request.getAttribute("board");

	Attachment at = (Attachment)request.getAttribute("attachment");
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
    
    .outer table a{
    	color: white;
    }
</style>

</head>
<body>

    <%@ include file="../common/menubar.jsp" %>
    <div class="outer">
        <br>
        <h2 align="center">일반게시글 상세보기</h2>
        <br>

        <table border="1" align="center">
            <tr>
                <th width="70">카테고리</th>
                <td width="70"><%= b.getCategory() %></td>
                <th width="70">제목</th>
                <td width="350"><%= b.getBoardTitle() %></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><%= b.getBoardWriter() %></td>
                <th>작성일</th>
                <td><%= b.getCreateDate() %></td>
            </tr>
            <tr></tr>
                <th>내용</th>
                <td colspan="3">
                    <p style="height: 200px;">
                        <%= b.getBoardContent() %>
                    </p>
                </td>
            </tr>
            <tr>
            	<th>청부파일</th>
            	<td colspan="3">
                	<%if(at == null) { %> 
	                    첨부파일이 없습니다. 
                    <% } else {%>
	                    <a download="<%=at.getOriginName() %>" href="<%=contextPath%>/<%=at.getFilePath() + at.getChangeName()%>"><%=at.getOriginName() %></a>
                	<%} %>
                </td>
            </tr>
        </table>
        <br>

        <div align="center">
            <a href="<%=contextPath%>/list.bo?cpage=1" class="btn btn-sm btn-secondary"> 목록가기</a>
            <% if(loginUser != null && loginUser.getUserId().equals(b.getBoardWriter())) { %>
                <a href="<%=contextPath %>/updateForm.bo?bno=<%=b.getBoardNo()%>" class="btn btn-sm btn-warning">수정하기</a>
                <a href="" class="btn btn-sm btn-danger">삭제하기</a>
            <% } %>
        </div>

        <br>
        
        <div id="reply-area">
            <table align="center">
                <thead>
                    <tr>
                        <th>댓글작성</th>
                        <%if(loginUser != null) { %>
	                        <td>
	                            <textarea id="reply-content" style="resize: none;" cols="50" rows="3"></textarea>
	                        </td>
	                        <td>
	                            <button onclick="insertReply()">댓글등록</button>
	                        </td>
                        <% } else {%>
                            <td>
	                            <textarea id="reply-content" style="resize: none;" cols="50" rows="3" readonly></textarea>
	                        </td>
	                        <td>
	                            <button disaled>댓글등록</button>
	                        </td>
                        <% } %>
                    </tr>
                </thead>
                <tbody>
                	<tr>
                        <td></td>
                        <td align="center"><div class="spinner-border"></div></td>
                        <td></td>
                    </tr>
                	<!--  
                    <tr>
                        <td>user05</td>
                        <td>안녕하세요.</td>
                        <td>2024/09/26</td>
                    </tr>
                    <tr>
                        <td>user05</td>
                        <td>댓글남깁니다.</td>
                        <td>2024/09/26</td>
                    </tr>
                    <tr>
                        <td>user05</td>
                        <td>댓글남깁니다.</td>
                        <td>2024/09/26</td>
                    </tr>
                    <tr>
                        <td>user05</td>
                        <td>댓글남깁니다.</td>
                        <td>2024/09/26</td>
                    </tr>
                    -->
                </tbody>
            </table>

            <script>
            	window.onload = function(){      
                    selectReplyList();
                    setInterval(selectReplyList, 2000);
                }

                function selectReplyList(){
                    $.ajax({
            			url: "rlist.bo",
            			contentType: "application/json",
            			data: {
            				bno: <%=b.getBoardNo()%>
            			},
            			success: function(res){
                            let str = "";
                            for(let reply of res){
                                str += ("<tr>" +
                                        "<td>" + reply.replyWriter + "</td>" +
                                        "<td>" + reply.replyContent + "</td>" +
                                        "<td>" + reply.createDate + "</td>" +
                                        "</tr>")
                            }

                            const replyBody = document.querySelector("#reply-area tbody");
                            replyBody.innerHTML = str;
            			},
            			error: function(){
            				console.log("댓글 조회용 ajax통신 실패")
            			}
            		})
                }
            	
                function insertReply(){
                    const boardNo = <%=b.getBoardNo()%>;
                    const contentArea = document.querySelector("#reply-content");

                    $.ajax({
                        url : "rinsert.bo",
                        type : "post",
                        data : {
                            bno : boardNo,
                            content : contentArea.value
                        },
                        success : function(res){
                            contentArea.value = "";
                            selectReplyList();
                        },
                        error : function(){
                            console.log("댓글 작성중 ajax통신 실패")
                        }
                    })
                }
            </script>
        </div>
    </div>
</body>
</html>