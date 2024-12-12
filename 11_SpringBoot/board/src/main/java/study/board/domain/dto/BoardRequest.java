package study.board.domain.dto;

import lombok.Getter;
import lombok.Setter;
import study.board.domain.entity.Board;

public class BoardRequest {

    @Getter
    @Setter
    public static class CreateDTO{
        private String userId;
        private String title;
        private String contents;
        private String fileName;

        // CreateDTO를 엔티티로 변환
        public Board toEntity() {
            return Board.builder()
                    .memberEmail(userId)
                    .title(title)
                    .contents(contents)
                    .fileName(fileName)
                    .build();
        }
    }

    @Getter
    @Setter
    public static class UpdateDTO{
        private Long boardId;
        private String title;
        private String contents;
        private String originFile;

        // CreateDTO를 엔티티로 변환
        public Board toEntity() {
            return Board.builder()
                    .boardId(boardId)
                    .title(title)
                    .contents(contents)
                    .fileName(originFile)
                    .build();
        }
    }
}
