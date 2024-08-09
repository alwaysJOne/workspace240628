package com.kh.controller;

import java.util.ArrayList;
import java.util.List;

import com.kh.vo.Member;

//Controller : view를 통해서 사용자가 요청한 기능에 대해 처리하는 담당
//				해당 메소드로 전달된 데이터[가공처리 후] 다시 결과를 view로 전달해준다.

//Member에 관한 기능을 제공한다.
public class MemberController {
	private int num;
	private String str;
	private List<Member> memberList = new ArrayList<>(); // Member를 저장할 수 있는 list생성
	
	public MemberController() {
		super();
		memberList.add(new Member("user01", "pass01", "최지원", 20));
	}

	public boolean insertMember(Member m) {
		return memberList.add(m);
	}
	
	//전달받은 id와 pwd로 회원을 검색해서 있다면 반환, 없다면 null 반환
	public Member loginMember(String id, String pwd) {
		for(Member m : memberList) {
			if (m.getUserId().equals(id) && m.getUserPwd().equals(pwd)) {
				return m;
			}
		}
		
		return null;
	}
}
