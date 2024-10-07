<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

	<!-- 메뉴바 -->
    <jsp:include page="../common/header.jsp" />

    <div class="content">
        <br><br>
        <div class="innerOuter">
            <h2>회원가입</h2>
            <br>

            <form action="insert.me" method="post" id="enrollForm">
                <div class="form-group">
                    <label for="userId">* ID : </label> 
                    <input type="text" class="form-control" id="userId" placeholder="Please Enter ID" name="userId" required>
                    <div id="checkResult" style="font-size:0.7em; display:none;"></div>
					<br>
                    <label for="userPwd">* Password : </label>
                    <input type="password" class="form-control" id="userPwd" placeholder="Please Enter Password" name="userPwd" required> <br>

                    <label for="checkPwd">* Password Check : </label>
                    <input type="password" class="form-control" id="checkPwd" placeholder="Please Enter Password" required> <br>

                    <label for="userName">* Name : </label>
                    <input type="text" class="form-control" id="userName" placeholder="Please Enter Name" name="userName" required> <br>

                    <label for="email"> &nbsp; Email : </label>
                    <input type="text" class="form-control" id="email" placeholder="Please Enter Email" name="email"> <br>

                    <label for="age"> &nbsp; Age : </label>
                    <input type="number" class="form-control" id="age" placeholder="Please Enter Age" name="age"> <br>

                    <label for="phone"> &nbsp; Phone : </label>
                    <input type="tel" class="form-control" id="phone" placeholder="Please Enter Phone (-없이)" name="phone"> <br>
                    
                    <label for="address"> &nbsp; Address : </label>
                    <input type="text" class="form-control" id="address" placeholder="Please Enter Address" name="address"> <br>
                    
                    <label> &nbsp; Gender : </label> &nbsp;&nbsp;
                    <input type="radio" id="Male" value="M" name="gender" checked>
                    <label for="Male">남자</label> &nbsp;&nbsp;
                    <input type="radio" id="Female" value="F" name="gender">
                    <label for="Female">여자</label> &nbsp;&nbsp;
                </div> 
                <br>
                <div class="btns" align="center">
                    <button type="submit" class="btn btn-primary" disabled>회원가입</button>
                    <button type="reset" class="btn btn-danger">초기화</button>
                </div>
            </form>
        </div>
        <br><br>   
        <script>
            $(function(){
                const idInput = document.querySelector("#enrollForm input[name=userId]");

                let eventFlag;

                idInput.onkeyup = function(ev){ //키가 입력될때마다 호출
                    clearTimeout(eventFlag); // 아직 실행되지 않은 ajax요청을 취소
                    
                    const str = ev.target.value;
                    if(str.trim().length >= 5){ 
                            eventFlag = setTimeout(function(){ // 1초뒤에 값을 확인해서 ajax요청
                                            // ajax요청
                                            $.ajax({
                                                url: "idCheck.me",
                                                data: {checkId: str},
                                                success : function(result){
                                                    const checkResult = document.querySelector("#checkResult");
                                                    checkResult.style.display = "block";

                                                    if(result === "NNNNN"){
                                                        checkResult.style.color = "red";
                                                        checkResult.innerText = "이미 사용중인 아이디입니다.";

                                                        document.querySelector("#enrollForm button[type='submit']").disabled = true;
                                                    } else {
                                                        checkResult.style.color = "green";
                                                        checkResult.innerText = "사용가능한 아이디입니다.";

                                                        document.querySelector("#enrollForm button[type='submit']").disabled = false;
                                                    }
                                                }, error : function(){
                                                    console.log("아이디 중복체크 ajax 실패")
                                                }
                                            })
                                        }, 1000)
                    } else {
                        document.querySelector("#enrollForm button[type='submit']").disabled = true;
                        document.querySelector("#checkResult").style.display = "none";
                    }
                }
            })
        </script>

    </div>

    <!-- 푸터바 -->
    <jsp:include page="../common/footer.jsp" />
    
</body>
</html>