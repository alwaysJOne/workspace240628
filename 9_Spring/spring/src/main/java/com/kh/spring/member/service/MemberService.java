package com.kh.spring.member.service;

import com.kh.spring.member.model.vo.Member;

public interface MemberService {

	//로그인
	Member loginMember(Member m);
	//id중복check
	int idCheck(String checkId);
}
