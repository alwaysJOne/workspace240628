package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet 같은 경우 반드시 contextPath뒤에 작성되어야한다.
 * http:localhost:5000/st/test1.do
 */
//@webServlet("/test1.do")
public class RequestGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestGetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get방식으로 요청시 해당 doGet메소드가 저절로 호출된다.
		//System.out.println("서버에 요청이 정상적으로 도착함");
		
		/*
		 * 첫번째 매개변수인 request에는 요청시 전달된 내용들이 담겨있음(사용자가 입력한 값, 요청방식, 요청자의 ip주소등)
		 * 두번째 매개변수인 response는 요청 처리 후 응답에 사용되는 객체
		 * 
		 * 요청처리를 위해서 요청시 전달된 값들 추출
		 * request의 paramerter영역안에 존재
		 * request.getPrameter("키")
		 */
		
		String name = request.getParameter("name"); // "최지원" | ""
		String gender = request.getParameter("gender"); // "M" | "W" | null
		int age = Integer.parseInt(request.getParameter("age"));// "23" => 23
		String city = request.getParameter("city"); // "경기" | "서울" 등등
		double height = Double.parseDouble(request.getParameter("height")); // "179" -> 179.0000
		
		//체크박스와 같이 복수의 벨류값들을 추출하고자 할 때
		String[] foods = request.getParameterValues("food"); // ["한식", "중식"] | null
		
		System.out.println("name :" + name);
		System.out.println("gender :" + gender);
		System.out.println("age :" + age);
		System.out.println("city :" + city);
		System.out.println("height :" + height);
		
		if(foods == null) {
			System.out.println("foods : 없음 ");
		} else {
			System.out.println("foods : " + String.join(" ", foods));
		}
		
		//> service > dao > db
		/*
		 * int result = new MemberService().insertMember(name, gender...);
		 * if (result > 0) {
		 *	//성공
		 * } else {
		 * 	//실패
		 * }
		 */
		
		//위의 결과에따라 응답페이지(html) 만들어서 전송
		//즉, 여기 java코드내에 사용자가 보게될 응답 html구문을 작성
		
		
		//response객체를 통해 사용자에게 html(응답화면) 전달
		//1) 이제부터 내가 출력할 내용은 문서형태의 html이고 문자셋은 utf-8이다 -> 선언
		response.setContentType("text/html; charset=utf-8");
		
		//2)응답받는 사용자(요청했던 사람)와의 스트림(클라이언트와의 통로)를 생성
		PrintWriter out = response.getWriter();
		
		//3)위에서가져온 스트림을 통해 응답html을 한줄씩 출력
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("</style>");
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<h2>개인정보응답화면</h2>");
		out.printf("<span>%s</span>님은", name);
		out.printf("<span>%d</span>살이며", age);
		out.printf("<span>%s</span>에 삽니다", city);
		out.println("성별은 ");
		if(gender == null) {
			out.println("선택하지 않았습니다.");
		} else {
			if(gender.equals("M")) {
				out.printf("<span>남자입니다.</span>", gender);
			} else {
				out.printf("<span>여자입니다.</span>", gender);
			}
		}
		
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
