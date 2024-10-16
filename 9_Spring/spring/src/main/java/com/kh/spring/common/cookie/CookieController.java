package com.kh.spring.common.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	/*
	 * cookie
	 * 브라우저에 저장되는 데이터 조각, 주로 사용자를 식별하고 상태정보를 기억하는데 사용된다.
	 * 쿠키는 클라이언트(브라우저)의 로컬저장소에 저장된다.
	 * 저장된 쿠키정보는 서버에 http요청시 헤더에 담겨 함께 전송된다.
	 * 
	 * 쿠키는 보안성이 낮고 개인정보 유출에 취약할 수 있다. 따라서 중요정보를 저장하는데 사용하려면 보안적인 조취가 필요하다.
	 */
	
	@RequestMapping("create")
	public String create(HttpServletResponse response) {
		//쿠키는 객체를 생성한 다음 응답정보에 첨부할 수 있다.
		//name, value속성을 필수로 작성해야한다.
		
		Cookie ck = new Cookie("test", "choijiwon");
		response.addCookie(ck);
		
		
		return "cookie/create";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletResponse response) {
		//쿠키는 삭제 명령어가 따로 없음
		
		Cookie ck = new Cookie("test", "choijiwon");
		ck.setMaxAge(0);
		response.addCookie(ck);
		
		
		return "cookie/delete";
	}
}
