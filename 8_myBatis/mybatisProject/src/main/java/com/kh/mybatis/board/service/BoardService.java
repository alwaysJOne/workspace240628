package com.kh.mybatis.board.service;

import java.util.ArrayList;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.vo.PageInfo;

public interface BoardService {
	
	//게시판리스트 조회
	public int selectListCount();
	public ArrayList<Board> selectList(PageInfo pi);
}
