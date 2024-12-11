function init(){
    getBoardList(drawBoardList);
}

function initBoard(){
    const path = window.location.pathname;
    const pathParts = path.split('/');
    const boardId = pathParts[pathParts.length - 1];

    getBoard(boardId, function(board){
        document.querySelector('#title').value = board.title;
        document.querySelector('#memberEmail').value = board.memberEmail;
        document.querySelector('#contents').value = board.contents;
        document.querySelector('#originFile').value = board.fileName;
        document.querySelector('#fileName').innerHTML = board.fileName;
        document.querySelector('#fileName').href = board.fileName;
    })
}

function formatDate(date) {
    let now = new Date(date);
    const year = now.getFullYear();
    const month = String(now.getMonth() + 1).padStart(2, '0');
    const day = String(now.getDate()).padStart(2, '0');
    return `${year}-${month}-${day}`;
}

function getBoard(boardId, callback){
    $.ajax({
        url: "http://localhost:8888/api/board/" + boardId,
        type: "get",                            
        contentType: "application/json",       
        success: function(response) {
            console.log(response)
            callback(response)
        },
        error: function() {
            console.error("board Request failed");
        }
    });
}

function getBoardList(callback){
    $.ajax({
        url: "http://localhost:8888/api/board",
        type: "get",                            
        contentType: "application/json",       
        success: function(response) {
            callback(response)
        },
        error: function() {
            console.error("board Request failed");
        }
    });
}

function drawBoardList(boardList){
    console.log(boardList)
    const boardBody = document.querySelector("#board-table tbody");

    if (boardList && boardList.length > 0) {
        boardBody.innerHTML = "";
        for(let board of boardList){
            boardBody.innerHTML += `<tr onclick="location.href='/boardDetail/${board.boardId}'">
                                        <td>${board.boardId}</td>
                                        <td>${board.title}</td>
                                        <td>${board.memberEmail}</td>
                                        <td>${formatDate(board.createAt)}</td>
                                    </tr>`
        }
    } else {
        boardBody.innerHTML = ` <tr>
                                    <td colspan="3">게시글이 없습니다</div></td>
                                </tr>`;
    }
}

function insertBoard(){
    // 입력값 가져오기

    const formData = new FormData();
    formData.append("title", document.querySelector('#title').value)
    formData.append("userId", document.querySelector('#userId').value)
    formData.append("contents", document.querySelector('#contents').value)
    formData.append("upfile", document.querySelector('#upfile').files[0])


    // AJAX 요청 보내기
    $.ajax({
        url: "http://localhost:8888/api/board", // 서버의 글쓰기 API URL
        type: "POST",
        data: formData,
        contentType: false, // FormData를 사용하면 contentType은 false로 설정
        processData: false, // FormData를 사용할 경우 데이터 직렬화 비활성화
        success: function(response) {
            alert("글이 성공적으로 등록되었습니다.");
            window.location.href = "/"; // 성공 후 목록 페이지로 이동
        },
        error: function(error) {
            alert("글 등록에 실패했습니다.");
            console.error("board insert failed");
        }
    });
};

function updateBoard(){
    if(!confirm("글을 정말 수정하시겠습니까?"))
        return;

    const path = window.location.pathname;
    const pathParts = path.split('/');
    const boardId = pathParts[pathParts.length - 1];

    const formData = new FormData();
    formData.append("title", document.querySelector('#title').value)
    formData.append("contents", document.querySelector('#contents').value)
    formData.append("upfile", document.querySelector('#upfile').files[0])
    formData.append("originFile", document.querySelector('#originFile').value)
    formData.append("boardId", boardId);

    $.ajax({
        url: "http://localhost:8888/api/board",
        type: "PUT",
        data: formData,
        contentType: false, // FormData를 사용하면 contentType은 false로 설정
        processData: false, // FormData를 사용할 경우 데이터 직렬화 비활성화
        success: function(response) {
            console.log(response)
            alert("글이 성공적으로 수정되었습니다.");
            window.location.href = "/boardDetail/" + boardId; 
        },
        error: function(error) {
            alert("글 등록에 실패했습니다.");
            console.error("board insert failed");
        }
    });
};

function deleteBoard(){
    if(!confirm("글을 정말 삭제하시겠습니까?"))
        return;
    
    const path = window.location.pathname;
    const pathParts = path.split('/');
    const boardId = pathParts[pathParts.length - 1];


    $.ajax({
        url: "http://localhost:8888/api/board/" + boardId,
        type: "DELETE",
        success: function(response) {
            alert("글이 성공적으로 삭제되었습니다.");
            window.location.href = "/"; 
        },
        error: function(error) {
            alert("글 등록에 실패했습니다.");
            console.error("board insert failed");
        }
    });
};