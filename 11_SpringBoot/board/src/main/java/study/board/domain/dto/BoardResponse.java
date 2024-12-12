package study.board.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import study.board.domain.entity.Board;

import java.time.LocalDateTime;

public class BoardResponse {

    @Getter
    @Setter
    @Builder
    public static class SimpleDTO{
        private Long boardId;
        private String memberEmail;
        private String title;
        private String fileName;
        private LocalDateTime createAt;

        public static SimpleDTO fromEntity(Board board){
            return SimpleDTO.builder()
                    .boardId(board.getBoardId())
                    .memberEmail(board.getMemberEmail())
                    .title(board.getTitle())
                    .fileName(board.getFileName())
                    .createAt(board.getCreateAt())
                    .build();
        }
    }

    @Getter
    @Setter
    @Builder
    public static class DetailDTO{
        private Long boardId;
        private String memberEmail;
        private String title;
        private String contents;
        private String fileName;
        private LocalDateTime createAt;

        public static DetailDTO fromEntity(Board board) {
            return DetailDTO.builder()
                    .boardId(board.getBoardId())
                    .memberEmail(board.getMemberEmail())
                    .title(board.getTitle())
                    .contents(board.getContents())
                    .fileName(board.getFileName())
                    .createAt(board.getCreateAt())
                    .build();
        }
    }
}
