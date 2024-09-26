package com.kh.board.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Category;
import com.kh.board.model.vo.Reply;
import com.kh.common.PageInfo;

public class BoardService {

	public int selectListCount() {
		Connection conn = getConnection();
		
		int listCount = new BoardDao().selectListCount(conn);
		close(conn);
		
		return listCount;
	}
	
	public ArrayList<Board> selectList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Board> list = new BoardDao().selectList(conn, pi);
		close(conn);
		
		return list;
	}
	
	public Board increaseCount(int boardNo) {
		Connection conn = getConnection();
		
		BoardDao bDao = new BoardDao();
		int result = bDao.increaseCount(conn, boardNo);
		
		Board b = null;
		if(result > 0) {
			commit(conn);
			b = bDao.selectBoard(conn, boardNo);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return b;
	}
	
	
	
	public Attachment selectAttachment(int boardNo) {
		Connection conn = getConnection();
		Attachment at = new BoardDao().selectAttachment(conn, boardNo);
		
		close(conn);
		return at;
	}
	
	public ArrayList<Category> selectCategoryList(){
		Connection conn = getConnection();
		ArrayList<Category> list = new BoardDao().selectCategoryList(conn);
		
		close(conn);
		
		return list;
	}
	
	
	public int insertBoard(Board b, Attachment at) {
		Connection conn = getConnection();
		BoardDao bDao = new BoardDao();
		
		int result1 = bDao.insertBoard(conn, b);
		int result2 = 1;
		
		if(at != null) {
			result2 = bDao.insertAttachment(conn, at);
		}
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
	
		return result1 * result2;
	}
	
	public Board selectBoard(int boardNo) {
		Connection conn = getConnection();
		
		Board b = new BoardDao().selectBoard(conn, boardNo);
	
		close(conn);
		
		return b;
	}
	
	public int updateBoard(Board b, Attachment at) {
		Connection conn = getConnection();
		
		BoardDao bDao = new BoardDao();
		int result1 = bDao.updateBoard(conn, b);
		
		int result2 = 1;
		if(at != null) { //첨부파일이 있을 때
			if(at.getFileNo() != 0) { //기존첨부파일이 있을 때 -> update
				result2 = bDao.updateAttachment(conn, at);
			} else {//기존첨부파일 없을 때 -> insert
				result2 = bDao.insertNewAttachment(conn, at);
			}
		}
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result1 * result2;
	}
	
	public ArrayList<Board> selectThumbnailList() {
		Connection conn = getConnection();
		
		ArrayList<Board> list = new BoardDao().selectThumbnailList(conn);
		close(conn);
		
		return list;
	}
	
	public int insertThumbnailBoard(Board b, ArrayList<Attachment> list) {
		Connection conn = getConnection();
		
		BoardDao bDao = new BoardDao();
		int result1 = bDao.insertThumbnailBoard(conn, b);
		int result2 = bDao.insertAttachmentList(conn, list);
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
				
		close(conn);
		
		return result1 * result2;
	}
	
	public ArrayList<Attachment> selectAttachmentList(int boardNo){
		Connection conn = getConnection();
		
		ArrayList<Attachment> list = new BoardDao().selectAttachmentList(conn, boardNo);
		close(conn);
		
		return list;
	}
	
	public int insertReply(Reply r) {
		Connection conn = getConnection();
		int result = new BoardDao().insertReply(conn, r);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public ArrayList<Reply> selectReplyList(int boardNo){
		Connection conn = getConnection();
		
		ArrayList<Reply> list = new BoardDao().selectReplyList(conn, boardNo);
		
		close(conn);
		return list;
	}
}








