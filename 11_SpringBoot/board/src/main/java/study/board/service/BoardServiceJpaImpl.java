package study.board.service;

import org.springframework.stereotype.Service;
import study.board.domain.entity.Board;

import java.util.List;


public class BoardServiceJpaImpl implements BoardService {
    @Override
    public List<Board> findAll() {
        return List.of();
    }
}
