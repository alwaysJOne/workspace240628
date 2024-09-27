package com.kh.mybatis.member.service;

import com.kh.mybatis.member.model.vo.Member;

public interface MemberService {
	public abstract Member loginMember(Member m);
	int insertMember(Member m);
}
