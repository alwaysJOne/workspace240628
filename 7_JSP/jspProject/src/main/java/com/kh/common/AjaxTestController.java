package com.kh.common;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.kh.member.model.vo.Member;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class AjaxTestController
 */
public class AjaxTestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println(name);
		System.out.println(age);
		
		//여러개를 한번에 반환하기 어렵다
		//response.getWriter().print(name);
		//response.getWriter().print(age);
		
		/*
		 * JSON(자바스크립트에서 객체를 표현했던 방법, 실제로는 파일형식을 의미한다)
		 * ajax통신시 데이터전송에 가장 많이 사용되는 포맷형식중 하나
		 * 
		 * JSONArray
		 * [value,value,value...]
		 * 
		 * JSONObject
		 * {key:value, key:value...}
		 */
		
		/*
		JSONArray jArr = new JSONArray();
		jArr.add(name);
		jArr.add(age);
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print(jArr);
		*/
		
		ArrayList<Member> list = new ArrayList<>();
		list.add(new Member(1, "김개똥", "01011112222"));
		list.add(new Member(2, "최개똥", "01011322222"));
		list.add(new Member(3, "박개똥", "01011432222"));
		list.add(new Member(4, "이개똥", "01011115422"));
		list.add(new Member(5, "서개똥", "01011113322"));
		
		/*
		JSONArray jArr = new JSONArray();
		for(Member m : list) {
			JSONObject jobj = new JSONObject();
			jobj.put("userNo", m.getUserNo());
			jobj.put("userName", m.getUserName());
			jobj.put("phone", m.getPhone());
			
			jArr.add(jobj);
		}
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print(jArr);
		*/
		response.setContentType("text/html; charset=UTF-8");
		new Gson().toJson(list, response.getWriter());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
