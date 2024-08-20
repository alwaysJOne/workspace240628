package com.kh.run;

import com.kh.view.MemberMenu;

public class Run {

	public static void main(String[] args) {
		/*
		 * M(model) : 데이터 처리담당(데이터를 담기위한 클래스(vo), 데이터가 보관된 공간(db)과 직접적으로 접근해서 데이터를 주고받는 클래스(dao))
		 * V(View) : 화면을 담당(사용자가 보게되는 시각적인 요소, 출력및 입력)
		 * C(Controller) : 사용자의 요청을 처리해주는 역할
		 * */

		new MemberMenu().mainMenu();
	}

}
