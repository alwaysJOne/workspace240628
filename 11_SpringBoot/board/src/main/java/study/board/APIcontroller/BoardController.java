package study.board.APIcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import study.board.domain.dto.BoardRequest;
import study.board.domain.dto.BoardResponse;
import study.board.domain.entity.Board;
import study.board.service.BoardService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
    REST API는 REST(Representational State Transfer)라는 라키텍처 스타일을 따르는 API이다.
    REST는 자원을 기반으로 한 네트워크 아키텍처 설계 방식으로, 주로 HTTP를 사용하여 클라이언트와 서버간의 데이터 통신읋 지원한다.
    REST API는 REST의 원칙에 따라 자우ㅝㄴ을 정의하고 자원에 대한 표준 HTTP메서드(GET, POST, PUT, DELETE, PATCH등)을 사여하여 조작한다.

    url에는 접근할 자원의 경로를 지정합니다.
    작업은 HTTP 메서드를 사용하여 표현한다.
    GET : 자원의 조회(읽기)
    POST : 자원의 생성
    PUT : 자원의 수정(전체)
    PATCH : 자원의 수정(일부)
    DELETE : 자원의 삭제

    REST 아키텍처 스타일이지 공식이 아니다. 따라서 설계와 구현 방식이 개발자마다 다를 수 있다.
    RESTful하지 않는 방식으로 설계되는 경우도 많다.
 */

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<List<BoardResponse.SimpleDTO>> getBoardList() {
        List<Board> boardList = boardService.findAll();
        List<BoardResponse.SimpleDTO> resultDtoList = new ArrayList<>();
        for (Board board : boardList) {
            resultDtoList.add(BoardResponse.SimpleDTO.fromEntity(board));
        }

        return new ResponseEntity<>(resultDtoList, HttpStatus.OK);
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<BoardResponse.DetailDTO> getBoard(@PathVariable Long boardId){
        Board board = boardService.findOne(boardId);
        BoardResponse.DetailDTO resultBoard = BoardResponse.DetailDTO.fromEntity(board);
        return new ResponseEntity<>(resultBoard, HttpStatus.OK);
    }

    //테스트할 때 member의 email은 실제로 존재하는 값을 넣어주어야합니다.
    //ex) user1@example.com
    @PostMapping
    public ResponseEntity<String> createBoard(BoardRequest.CreateDTO request, MultipartFile upfile) throws Exception{
         /*
            @Builder를 객체에 추가하면 빌더 클래스가 자동으로 생성되어 객체 생성을 보다 편리하게 할 수 있다.
            객체가 가질 필드들을 설정하는 메서드들을 체이닝방식으로 연결하여 객체를 생성하는 패턴이다.
         */

        if(request == null || request.getUserId() == null) {
            throw new RuntimeException("check value");
        }

        Board board = request.toEntity();

        if (!upfile.isEmpty()) {
            // 파일 저장 경로 생성
            //static안에 폴더 생성 후 해당 폴더의 절대경로를 넣어주세요.
            File realObj = new File("C:\\workspace240628\\11_SpringBoot\\board\\src\\main\\resources\\uploads", upfile.getOriginalFilename());
            upfile.transferTo(realObj);

            board.changeFileName("/uploads/" + upfile.getOriginalFilename());
        }

        int result = boardService.save(board);

        if (result > 0) {
            return new ResponseEntity<>("게시글 등록 성공", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("게시글 등록 실패", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Long> updateBoard(BoardRequest.UpdateDTO request, MultipartFile upfile) throws Exception{

        Board board = request.toEntity();

        if (upfile != null && !upfile.isEmpty()) {
            // 파일 저장 경로 생성
            File realObj = new File("C:\\workspace240628\\11_SpringBoot\\board\\src\\main\\resources\\uploads\"", upfile.getOriginalFilename());
            upfile.transferTo(realObj);

            board.changeFileName("/uploads/" + upfile.getOriginalFilename());
        }

        Long boardId = boardService.update(board);
        return new ResponseEntity<>(boardId, HttpStatus.OK);
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<String> deleteBoard(@PathVariable Long boardId){
        int result = boardService.delete(boardId);
        return new ResponseEntity<>(result + "개 게시글 삭제완료", HttpStatus.OK);
    }
}
