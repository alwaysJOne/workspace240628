<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <style>
        .outer{
            background: black;
            color: white;
            width: 1000px;
            margin: auto;
            margin-top: 50px;
            padding: 10px 0px 50px 0px;
        }
        table{
            margin: auto;
        }
    </style>
</head>
<body>
    <%@ include file="../common/menubar.jsp" %>
    <%
        String userId = loginUser.getUserId();
        String userName = loginUser.getUserName();
        String phone = loginUser.getPhone() == null ? "" : loginUser.getPhone();
        String email = loginUser.getEmail() == null ? "" : loginUser.getEmail();
        String address = loginUser.getAddress() == null ? "" : loginUser.getAddress();
        String interest = loginUser.getInterest() == null ? "" : loginUser.getInterest();
    %>

    <div class="outer">
        <br>
        <h2 align="center">내 정보</h2>
        <form action="<%=contextPath %>/update.me" method="post" id="update-form">
            <table>
                <tr>
                    <td>* 아이디</td>
                    <td><input type="text" name="userId" maxlength="12" value="<%=userId%>" readonly></td>
                    <td></td>
                </tr>
                <tr>
                    <td>* 이름</td>
                    <td><input type="text" name="userName" maxlength="6" value="<%=userName%>" readonly></td>
                    <td></td>
                </tr>
                <tr>
                    <td>전화번호</td>
                    <td><input type="text" name="phone" placeholder="- 포함해서 입력" value="<%=phone%>"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td><input type="text" name="email" value="<%=email%>"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td><input type="text" name="address" value="<%=address%>"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>관심분야</td>
                    <td colspan="2">
                        <label>
                            <input type="checkbox" name="interest" value="운동">
                            운동
                        </label>
                        <label>
                            <input type="checkbox" name="interest" value="등산">
                            등산
                        </label>
                        <label>
                            <input type="checkbox" name="interest" value="낚시">
                            낚시
                        </label>
                        <br>
                        <label>
                            <input type="checkbox" name="interest" value="요리">
                            요리
                        </label>
                        <label>
                            <input type="checkbox" name="interest" value="게임">
                            게임
                        </label>
                        <label>
                            <input type="checkbox" name="interest" value="영화">
                            영화
                        </label>
                        <label>
                            <input type="checkbox" name="interest" value="기타">
                            기타
                        </label>
                    </td>
                </tr>
            </table>
            <script>
            	const interest = "<%=interest%>"; //운동,게임,영화
            	const inputArr = document.querySelectorAll("input[name=interest]");
            	//[<input>,<input>,<input>,<input>,<input>,<input>,<input>]
            	
            	for(let input of inputArr){
            		if(interest.includes(input.value)){ // interes에 input.value의 값이 포함되어 있다면
            			input.checked = true;
            		}  
            	}
            </script>

            <br><br>

            <div align="center">
                <button type="submit" class="btn btn-sm btn-secondary">정보변경</button>
                <button type="button" class="btn btn-sm btn-primary" data-bs-toggle="modal" data-bs-target="#update-pwd-modal">
                	비밀번호 변경
                </button>
                <button type="button" class="btn btn-sm btn-danger" data-bs-toggle="modal" data-bs-target="#delete-member-modal">회원탈퇴</button>
            </div>
        </form>
    </div>
	
	<!-- 회원탈퇴 Modal -->
	<div class="modal" id="delete-member-modal">
	  <div class="modal-dialog modal-dialog-centered">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="modal-title">회원탈퇴</h4>
	        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
	      </div>
	
	      <!-- Modal body -->
	      <div class="modal-body" align="center">
	        <form action="<%=contextPath%>/delete.me" method="post">
	        	<b>탈퇴 후 복구가 불가능합니다.<br>
	        	정말로 탈퇴하시겠습니까?</b>
	        	<br><br>
	        	<input type="hidden" name="userId" value="<%=userId%>">
	   			비밀번호 : <input type="password" name="userPwd" required>
	        	<br><br>
	        	<button type="submit" class="btn btn-sm btn-danger" >
	        		탈퇴하기
	        	</button>
	        </form>
	      </div>
	    
	    </div>
	  </div>
	</div>
	
	<!-- 비밀번호 변경 Modal -->
	<div class="modal" id="update-pwd-modal">
	  <div class="modal-dialog modal-dialog-centered">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="modal-title">비밀번호 변경</h4>
	        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
	      </div>
	
	      <!-- Modal body -->
	      <div class="modal-body" align="center">
	        <form action="<%=contextPath%>/updatePwd.me" method="post">
	        	<input type="hidden" name="userId" value="<%=userId%>">
	        	<table>
	        		<tr>
	        			<td>현재 비밀번호</td>
	        			<td><input type="password" name="userPwd" required></td>
	        		</tr>
	        		<tr>
	        			<td>변경할 비밀번호</td>
	        			<td><input type="password" name="updatePwd" required></td>
	        		</tr>
	        		<tr>
	        			<td>변경할 비밀번호 확인</td>
	        			<td><input type="password" name="checkPwd" required></td>
	        		</tr>
	        	</table>
	        	<br>
	        	<button id="edit-pwd-btn" type="submit" class="btn btn-sm btn-secondary" >
	        		비밀번호 변경
	        	</button>
	        </form>
	        
	        <script>
		        document.getElementById("edit-pwd-btn").onclick = function(){
		            const pwd = document.querySelector("input[name=updatePwd]").value
		            const pwdCheck = document.querySelector("input[name=checkPwd]").value
	
		            if(pwd !== pwdCheck) {
		                alert("비밀번호가 일치하지 않습니다.");
		                return false;
		            }
		        }
	        </script>
	      </div>
	    
	    </div>
	  </div>
	</div>
</body>
</html>