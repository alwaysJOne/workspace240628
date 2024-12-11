package study.board.service;

import study.board.domain.entity.Board;

import java.util.List;

public interface BoardService {
    List<Board> findAll();
}
