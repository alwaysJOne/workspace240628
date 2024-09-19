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

    <div class="outer">
        <br>
        <h2 align="center">회원가입</h2>
        <form action="<%=contextPath %>/insert.me" method="post" id="enroll-form">
            <table>
                <tr>
                    <td>* 아이디</td>
                    <td><input type="text" name="userId" maxlength="12" required></td>
                    <td><button type="button" onclick="">중복확인</button></td>
                </tr>
                <tr>
                    <td>* 비밀번호</td>
                    <td><input type="password" name="userPwd" maxlength="15" required></td>
                    <td></td>
                </tr>
                <tr>
                    <td>* 비밀번호 확인</td>
                    <td><input type="password" name="userPwdCheck" maxlength="15" required></td>
                    <td></td>
                </tr>
                <tr>
                    <td>* 이름</td>
                    <td><input type="text" name="userName" maxlength="6" required></td>
                    <td></td>
                </tr>
                <tr>
                    <td>전화번호</td>
                    <td><input type="text" name="phone" placeholder="- 포함해서 입력"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td><input type="text" name="email"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td><input type="text" name="address"></td>
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

            <br><br>

            <div align="center">
                <button type="submit" onclick="return checkPwd()">회원가입</button>
                <button type="reset">초기환</button>
            </div>
        </form>
    </div>

    <script>
        function checkPwd(){
            const pwd = document.querySelector("#enroll-form input[name=userPwd]").value
            const pwdCheck = document.querySelector("#enroll-form input[name=userPwdCheck]").value

            if(pwd !== pwdCheck) {
                alert("비밀번호가 일치하지 않습니다.");
                return false;
            }
        }
    </script>
</body>
</html>