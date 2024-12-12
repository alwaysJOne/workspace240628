package study.board.service;

import study.board.domain.entity.Board;

import java.util.List;

public interface BoardService {
    int save(Board board);
    List<Board> findAll();
    Board findOne(Long boardId);
    int delete(Long boardId);
    Long update(Board board);
}
