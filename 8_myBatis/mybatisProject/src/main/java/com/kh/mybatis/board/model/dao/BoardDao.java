package com.kh.mybatis.board.model.dao;

import org.apache.ibatis.session.SqlSession;

public class BoardDao {
	public int selectListCount(SqlSession sqlSession) {
		return sqlSession.selectOne("boardMapper.selectListCount");
	}
}
