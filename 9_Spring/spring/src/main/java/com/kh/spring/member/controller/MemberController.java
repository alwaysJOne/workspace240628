package com.kh.spring.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring.member.model.vo.Member;
import com.kh.spring.member.service.MemberService;

//Bean에 Class를 등록하는 방법으로 @Component을 클래스에 부여해주면 된다.
// @Controller -> @Component + Controller객체가 가질 수 있는 예외처리등이 추가된 어노테이션
@Controller
public class MemberController {
	
	/*
	 * @Autowired
	 * 의존성주입을 사용할 때 사용하는 어노테이션
	 * 클래스내에서 필요한 객체를 직접생성하지 않고  spring컨테이너가 관리하는 객체(Been)를 주입받아 사용할 수 있게 해줌 
	 * + 필드주입방식/생성자주입방식
	 */
	@Autowired
	private MemberService memberService;
	
	/*
	 * Spring에서클라이언트가 보낸 정보를 받는 방법
	 * 1. HttpServletRequest를 활용해서 전달값을 가져옴
	 * 메소드에 매개변수로 HttpServletRequest를 작성해두면
	 * 스프링컨테이너가 해당 메소드를 호출할 때 자동으로 객체생성해서 매게변수로 주입해준다.
	 */
//	@RequestMapping("login.me")
//	public String loginMember(HttpServletRequest request) {
//		String id = request.getParameter("userId");
//		String pwd = request.getParameter("userPwd");
//		
//		System.out.println(id);
//		System.out.println(pwd);
//		return null;
//	}
	
	/*
	 * 2. @RequestParam 어노테이션을 이용하는 방법
	 * request.getPrameter(키)로 벨류를 추출하는 역할을 대신해주는 어노테이션
	 * value속성의 값으로 jsp에서 작성했던 name속성값을 담으면 알아서 해당 매개변수로 받아올 수 있다.
	 * 만약, 요청할때의 값이 비어있는 경우 defaultValue속성으로 기본값을 지정할 수 있다.
	 * 
	 * default와같은 설정을 사용하지않고 요청받은 key값과 매개변수명을 동일하게 해준다면
	 * @RequestParam 생략할 수 있다.
	 */
//	@RequestMapping("login.me")
//	public String loginMember(@RequestParam(value="userId", defaultValue="test222") String id, String userPwd) {
//
//		System.out.println(id);
//		System.out.println(userPwd);
//		
//		return "main";
//		// /WEB-INF/views/main.jsp
//	}
	
	
	/*
	 * 3. 커맨드 객체 방식
	 * 
	 * 해당 메소드의 매개변수로
	 * 요청시 전달값을 담고자하는 클래스 타입으로 만들어 준 뒤
	 * 전달되는 key값과 매개변수 클래스의 필드명을 동일하게 작성해주면
	 * 객체를 생성하여 값을 담아서 전달해준다.
	 */
//	@RequestMapping("login.me")
//	public String loginMember(Member m) {
//
//		Member loginMember = memberService.loginMember(m);
//		
//		if (loginMember == null) {
//			System.out.println("로그인 실패");
//		} else {
//			System.out.println("로그인 성공");
//		}
//		
//		return "main";
//		// /WEB-INF/views/main.jsp
//	}
	
	// 요청처리 후에 응답데이터를 담고 응답페이지로 포워딩 또는 url재요청 처리하는 방법
	// 1. 스프링에서 제공하는 Model객체를 이용해서 retrun해주기
	
	@RequestMapping("login.me")
	public String loginMember(Member m, HttpSession session) {

		Member loginMember = memberService.loginMember(m);
		
		if (loginMember == null) {
			System.out.println("로그인 실패");
		} else {
			session.setAttribute("loginUser", loginMember);
			System.out.println("로그인 성공");
		}
		
		return "main";
		// /WEB-INF/views/main.jsp
	}
}
