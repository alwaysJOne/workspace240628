package com.kh.spring.board.service;

import java.util.ArrayList;

import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.Reply;
import com.kh.spring.common.vo.PageInfo;

public interface BoardService {
	//게시글 총 갯수 가져오기
	int selectListCount();
	
	//게시글 목록 가져오기
	ArrayList<Board> selectList(PageInfo pi);
	
	//게시글 조회수 증가
	int increaseCount(int bno);
	
	//boardNo로 게시글 조회
	Board selectBoard(int bno);
	
	//게시글 추가(insert) 
	int insertBoard(Board b);
	
	//게시글 수정
	int updateBoard(Board b);
	
	//댓글목록 가져오기
	ArrayList<Reply> selectReply(int bno);
	
	//댓글 추가
	int insertReply(Reply r);
	
	//조회수 상위 5개
	public ArrayList<Board> selectTopBoardList();
}






