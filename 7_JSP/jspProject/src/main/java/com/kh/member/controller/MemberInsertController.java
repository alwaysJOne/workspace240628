package com.kh.member.controller;

import java.io.IOException;

import com.kh.member.model.vo.Member;
import com.kh.member.sevice.MemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberInsertController
 */
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId"); // "user04"
		String userPwd = request.getParameter("userPwd"); // "pass04"
		String userName = request.getParameter("userName"); // "최지워이"
		String phone = request.getParameter("phone"); // "010-1111-2222" || ""
		String email = request.getParameter("email"); // "user04@gmail.com" || ""
		String address = request.getParameter("address"); // "경기도 하남시" || ""
		String[] interestArr = request.getParameterValues("interest"); //["운동", "게임", "영화"] || null
		
		//String[] -> String
		//["운동", "게임", "영화"] -> "운동,게임,영화"
		String interest = "";
		if(interestArr != null) {
			interest = String.join(",", interestArr);
		}
		
		Member m = new Member(userId, userPwd, userName, phone, email, address, interest);
		
		//sql요청 -> service -> dao -> sql실행
		int result = new MemberService().insertMember(m);
		
		if(result > 0) {//회원가입 성공
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "성공적으로 회원가입이 되었습니다.");
			
			//jsp url 재요청 -> index페이지로
			response.sendRedirect(request.getContextPath());
		} else { //회원가입 실패
			//에러문구가 보여지는 에러페이지
			request.setAttribute("errorMsg", "회원가입에 실패하였습니다.");
			
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
