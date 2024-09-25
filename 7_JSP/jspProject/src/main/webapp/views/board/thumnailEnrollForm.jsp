<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
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
    
    .outer img:hover{
    	cursor: pointer;
        background: gray;
    }
</style>

</head>
<body>

    <%@ include file="../common/menubar.jsp" %>
    <div class="outer">
        <br>
        <h2 align="center">사진게시글 작성하기</h2>
        <br>

        <form action="<%=contextPath%>/insert.th" method="post" enctype="multipart/form-data">
            <input type="hidden" name="userName" value="<%=loginUser.getUserNo()%>">
            <table border="1" align="center">         
                <tr>
                    <th width="100">제목</th>
                    <td colspan="3">
                        <input type="text" name="title" required>
                    </td>
                </tr>
                <tr></tr>
                    <th>내용</th>
                    <td colspan="3">
                        <textarea name="content" rows="5" style="resize: none;"></textarea>
                    </td>
                </tr>
                <tr>
                    <th>대표이미지</th>
                    <td colspan="3">
                        <img id="title-img" width="250" height="170" onclick="chooseFile(1)">
                    </td>
                </tr>
                <tr>
                    <th>상세이미지</th>
                    <td><img id="content-img1" width="150px" height="120px" onclick="chooseFile(2)"></td>
                    <td><img id="content-img2" width="150px" height="120px" onclick="chooseFile(3)"></td>
                    <td><img id="content-img3" width="150px" height="120px" onclick="chooseFile(4)"></td>
                </tr>
            </table>
            
            <div style="display: none;">
                <input type="file" name="file1" id="file1" required onchange="loadImg(this, 1)">
                <input type="file" name="file2" id="file2" onchange="loadImg(this, 2)">
                <input type="file" name="file3" id="file3" onchange="loadImg(this, 3)">
                <input type="file" name="file4" id="file4" onchange="loadImg(this, 4)">
            </div>

            <script>
                function loadImg(_input, num){
                    //_input.files[0]-> 선택된 파일이 담겨있다.
                    //_input.files.legnth -> 1

                    if(_input.files.length == 1){ //파일이 하나 선택됬다
                        //파일을 읽어들일 객체생성
                        const reader = new FileReader();

                        //해당파일을 읽어들여 해당파일만의 고유한 url부여
                        reader.readAsDataURL(_input.files[0])

                        //파일읽어들이기를 완료했을 때 실행해주는 함수
                        reader.onload = function(ev){       
                            switch(num){
                                case 1: document.getElementById("title-img").src = ev.target.result; break;
                                case 2: document.querySelector("#content-img1").src = ev.target.result; break;
                                case 3: $("#content-img2").attr("src", ev.target.result); break;
                                case 4: $("#content-img3").attr("src", ev.target.result); break;
                            }
                        } 

                    } else { //선택된 파일을 취소한 경우 -> 미리보기 지워준다.
                        switch(num){
                            case 1: document.getElementById("title-img").src = null; break;
                            case 2: document.querySelector("#content-img1").src = null; break;
                            case 3: $("#content-img2").attr("src", null); break;
                            case 4: $("#content-img3").attr("src", null); break;
                        }
                    }
                }

                function chooseFile(num){
                    const fileInput = document.querySelector("#file" + num);
                    fileInput.click();
                }
            </script>

			<br>
			
            <div align="center">
                <button type="submit">작성하기</button>
                <button type="reset">취소하기</button>
            </div>

        </form>
    </div>
</body>
</html>