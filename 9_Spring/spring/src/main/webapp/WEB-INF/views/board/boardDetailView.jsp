<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
<style>
	table * {margin:5px;}
	table {width:100%;}
</style> 
</head>
<body>
	<jsp:include page="../common/header.jsp" />

    <div class="content">
        <br><br>
        <div class="innerOuter">
            <h2>게시글 상세보기</h2>
            <br>

            <a class="btn btn-secondary" style="float:right;" href="list.bo">목록으로</a>
            <br><br>

            <table id="contentArea" algin="center" class="table">
                <tr>
                    <th width="100">제목</th>
                    <td colspan="3">${b.boardTitle }</td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td>${b.boardWriter }</td>
                    <th>작성일</th>
                    <td>${b.createDate }</td>
                </tr>
                <tr>
                    <th>첨부파일</th>
                    <td colspan="3">
						<c:choose>
							<c:when test="${not empty b.originName }">
								<!-- case1 -->
                        		<a href="${b.changeName }" download="${b.originName }">${b.originName }</a>
                        	</c:when>
                        	<c:otherwise>
								<!-- case2 -->
								첨부파일이 없습니다.
							</c:otherwise>
						</c:choose>
                    </td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td colspan="3"></td>
                </tr>
                <tr>
                    <td colspan="4"><p style="height:150px;">${b.boardContent }</p></td>
                </tr>
            </table>
            <br>

   			
   			<!-- 수정하기, 삭제하기 버튼은 이 글이 본인이 작성한 글일 경우에만 보여져야 함 -->
            <div align="center">
            	<c:if test="${loginUser.userId eq b.boardWriter}">
	                <a class="btn btn-primary" onclick="postFormSubmit('edit')">수정하기</a>
	                <a class="btn btn-danger" onclick="postFormSubmit('delete')">삭제하기</a>
                </c:if>
            </div>
            <br><br>

            <form action="" method="POST" id="postForm">
                <input type="hidden" name="bno" value="${b.boardNo}">
            </form>

            <script>
                function postFormSubmit(type){
                    const formEl = document.querySelector("#postForm");
                    switch(type){
                        case "edit" : {
                            //formEl.action = "updateForm.bo";
                            $(formEl).attr("action", "updateForm.bo");
                        }break;
                        case "delete":{
                            //formEl.action = "delete.bo";
                            $(formEl).attr("action", "delete.bo")
                        }break;
                    }
                    
                    $(formEl).submit();
                }
            </script>
           
            
             <form action="" method="post" id="postForm">
           		<input type="hidden" name=bno value="7">
           		<input type="hidden" name="filePath" value="이미지.jpg">
             </form>
            
          
 
            <table id="replyArea" class="table" align="center">
                <thead>
                	<c:choose>
                		<c:when test="${empty loginUser }">
		                    <tr>
		                        <th colspan="2">
		                            <textarea class="form-control" readonly cols="55" rows="2" style="resize:none; width:100%;">로그인 후 이용 가능합니다.</textarea>
		                        </th>
		                        <th style="vertical-align:middle"><button class="btn btn-secondary disabled">등록하기</button></th>
		                    </tr>
	                	</c:when>
	                    <c:otherwise>
		                    <tr> 
		                        <th colspan="2">
		                            <textarea class="form-control" id="content" cols="55" rows="2" style="resize:none; width:100%;"></textarea>
		                        </th>
		                        <th style="vertical-align:middle"><button class="btn btn-secondary" onclick="addReply();">등록하기</button></th>
		                    </tr>
	                    </c:otherwise>
                    </c:choose>
                
                    
                    
                    <tr>
                        <td colspan="3">댓글(<span id="rcount">0</span>)</td>
                    </tr>
    
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
        <br><br>
    </div>

    <script>
        $(function(){
            const sendData = {
                bno: ${b.boardNo}
            }

            getReplyList(sendData, function(replyList){
                console.log(replyList)

                //댓글 갯수 나타내주는 함수 호출
                setReplyCount(replyList.length)

                const replyBody = document.querySelector("#replyArea tbody")
                //댓글목록 그려주는 함수 호출
                drawReplyList(replyBody, replyList);
            });



        })

        function drawReplyList(tBody, replyList){
            //단순하게 보여주기위한 view를 만들때
            // let str = "";
            // for(reply of replyList){
            //     str += `<tr>` + 
            //                 `<td>` + reply.replyWriter + `</td>` +
            //                 `<td>` + reply.replyContent + `</td>` +
            //                 `<td>` + reply.createDate + `</td>` +
            //             `</tr>`
            // }
            // tBody.innerHTML = str;

            $(tBody).empty();
            //tBody.innerHTML = ""
            //이벤트를 넣는 뷰를 작성하고 싶을 때
            for(const reply of replyList){
                const replyRow = document.createElement('tr'); // <tr></tr>
                replyRow.innerHTML = `<td>` + reply.replyWriter + `</td>` +
                                     `<td>` + reply.replyContent + `</td>` +
                                     `<td>` + reply.createDate + `</td>`;
                tBody.appendChild(replyRow);

                replyRow.onclick = function(){
                    console.log(reply.replyNo + "클릭됨")
                }
            }

        }

        function setReplyCount(count){
            document.querySelector("#rcount").innerHTML = count;
        }

        //ajax호출후 결과 가져오기(댓글목록)
        function getReplyList(data, callback){
            $.ajax({
                url: "rlist.bo",
                data: data,
                success: function(res){
                    callback(res)
                },
                error: function(){

                }
            })
        }

        //댓글 등록
        function addReply(){
            //boardNo
            //userId
            //댓글내용

            const boardNo = ${b.boardNo};
            const userId = "${loginUser.userId}"
            const content = document.querySelector("#content").value;

            addReplyAjax({
                refBno: boardNo,
                replyWriter: userId,
                replyContent: content
            }, function(res){
                // res -> 성공, 실패
                if(res === "success") {
                    document.querySelector("#content").value = "";
                    
                    getReplyList({bno: boardNo}, function(replyList){
                        setReplyCount(replyList.length);
                        drawReplyList(document.querySelector("#replyArea tbody"), replyList);
                    });
                }
            })
        }

        function addReplyAjax(data, callback){
            $.ajax({
                url: "rinsert.bo",
                data: data,
                success : function(res){
                    callback(res)
                }, error: function(){
                    console.log("댓글 생성 ajax 실패")
                }
            })
        }
    </script>
    
    <jsp:include page="../common/footer.jsp" />
</body>
</html>