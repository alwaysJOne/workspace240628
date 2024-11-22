package com.kh.spring.member.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RunWith(SpringJUnit4ClassRunner.class) //JUnit을 사용하여 스프링 컨텍스트를 로드함.
@WebAppConfiguration
@ContextConfiguration(locations = {
		"file:src/test/resources/root-context.xml",
		"file:src/test/resources/servlet-context.xml",
		"file:src/test/resources/spring-security.xml"
})
public class MemberControllerTest {

	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;  
	
	@Before // Test메서드가 실행되기 전에 실행하는 메서드
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		log.info("==================mockMvc 준비 완료===================");
	}
	
	@Test
	public void testLoginMember() {
		try {
			mockMvc.perform(post("/login.me") //POST메서드로 /login.me 요청
					.param("userId", "admin") //요청파라미터 user정보 세팅
					.param("userPwd", "1234"))
				.andDo(print())//요청한 정보에대한 응답코드를 출력
				.andExpect(status().isFound()) // HTTP상태코드가 302인지 확인해줘.
				.andExpect(redirectedUrl("/"));
				//.andExpect(status().isOk())
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	@Test
	public void testIdCheck() {
		MvcResult result; //요청결과를 받아줄 result객체
		
		try {
			result = mockMvc.perform(
						get("/idCheck.me")
						.param("checkId", "jiwon0000"))
					.andExpect(status().isOk())
					.andReturn(); //요청결과를 반환
			
			//응답객체 내용확인
			String content = result.getResponse().getContentAsString();
			assertEquals("NNNNY", content); //아이디 사용가능을 예상함
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		
	}

}









