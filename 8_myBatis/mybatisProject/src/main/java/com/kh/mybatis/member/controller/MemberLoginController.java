package com.kh.mybatis.member.controller;

import java.io.IOException;

import com.kh.mybatis.member.model.vo.Member;
import com.kh.mybatis.member.service.MemberService;
import com.kh.mybatis.member.service.MemberServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberLoginController
 */
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Member m = new Member();
		m.setUserId(request.getParameter("userId"));
		m.setUserPwd(request.getParameter("userPwd"));
		
		
		MemberService memberService = new MemberServiceImpl(); 
		Member loginUser = memberService.loginMember(m);
		
		if(loginUser != null) {
			request.getSession().setAttribute("loginUser", loginUser);
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("errorMsg", "로그인 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
