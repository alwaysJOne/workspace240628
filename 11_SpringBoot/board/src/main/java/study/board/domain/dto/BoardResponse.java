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
        private LocalDateTime createdAt;

        public static SimpleDTO fromEntity(Board board){
            return SimpleDTO.builder()
                    .boardId(board.getBoardId())
                    .memberEmail(board.getMemberEmail())
                    .title(board.getTitle())
                    .fileName(board.getFileName())
                    .createdAt(board.getCreatedAt())
                    .build();
        }
    }
}
