package com.kh.mybatis.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.vo.PageInfo;

public interface BoardService {
	
	//게시판리스트 조회
	public int selectListCount();
	public ArrayList<Board> selectList(PageInfo pi);
	
	//게시글상세조회
	public Board increaseCount(int boardNo);
	public ArrayList<Reply> selectReplyList(int boardNo);
	
	//게시판리스트 검색조회
	public int selectSearchCount(HashMap<String, String> map);
	public ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi);
}
