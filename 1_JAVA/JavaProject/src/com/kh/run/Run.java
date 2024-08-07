package com.kh.run;

import com.kh.view.MainMenu;

public class Run {

	/*
	 * MVC패턴을 적용해서 도서대여 프로그램을 제작해보자
	 * Run : main을 포함하고 자바의 실행을 위해서 작성하는 클래스
	 */
	public static void main(String[] args) {
		new MainMenu().menu();
	}

}
