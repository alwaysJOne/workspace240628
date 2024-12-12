package study.board.domain.entity;

import lombok.*;

import java.time.LocalDateTime;

//BOARD_ID  	TITLE  	CONTENTS  	FILE_NAME  	MEMBER_EMAIL  	CREATE_AT  	UPDATE_AT

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Board {
    private Long boardId;

    private String title;

    private String contents;

    private String fileName;

    private String memberEmail;

    private LocalDateTime createAt;
    private LocalDateTime updatedAt;

    //변경이 필요한 부분만 setter를 작성해준다.
    public void changeFileName(String fileName) {
        this.fileName = fileName;
    }

//    public static Bulder bulider(){
//        return new Bulder();
//    }
//
//    public static class Bulder{
//        private Board board = new Board();
//
//        public Bulder setBoardId(Long boardId){
//            this.board.setBoardId(boardId);
//            return this;
//        }
//
//        public Bulder setTitle(String title){
//            this.board.setTitle(title);
//            return this;
//        }
//
//        public Board build(){
//            return this.board;
//        }
//    }
}
