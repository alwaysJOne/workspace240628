package com.kh.mybatis.board.controller;

import java.io.IOException;

import com.kh.mybatis.board.service.BoardServiceImpl;
import com.kh.mybatis.common.template.Template;
import com.kh.mybatis.common.vo.PageInfo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardListController
 */
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//-------------------페이징처리---------------------------
		int currentPage = Integer.parseInt(request.getParameter("cpage"));
		int listCount = new BoardServiceImpl().selectListCount(); //총 게시글 수
		
		PageInfo pi = Template.getPageInfo(listCount, currentPage, 10, 5);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
