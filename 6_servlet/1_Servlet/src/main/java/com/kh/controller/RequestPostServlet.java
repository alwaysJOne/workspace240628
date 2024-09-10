package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class RequestPostServlet
 */
public class RequestPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청시 전달된 값들은 request의 parameter영역에 담겨있음
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post호출완료");
		doGet(request, response);
	}

}
