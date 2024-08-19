package com.kh.view;

import java.util.Scanner;

import com.kh.controller.MemberController;

// View : 사용자가 보게될 시각적인 요소(출력및 입력)
public class MemberMenu {
	//Scanner객체 생성 : 전역으로 다 입력받을 수 있도록
	private Scanner sc = new Scanner(System.in);

	//MemberController 객체 생성(전역에서 바로 요청할 수 있도록)
	private MemberController mc = new MemberController();
	/*
	 * 사용자가 보게될 첫 화면(메인화면)
	 */
	public void mainMenu() {
		
		while(true) {
			System.out.println("========== 회원관리 프로그램 ==========");
			System.out.println("1. 회원추가"); //데이터 추가 create
			System.out.println("2. 회원전체조회"); //데이터 조회 read
			System.out.println("3. 회원정보수정"); //데이터 변경 update
			System.out.println("4. 회원탈퇴"); //데이터 삭제 delete
			System.out.println("0. 프로그램 종료"); 
			
			System.out.print("메뉴 입력 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				//회원추가
				this.inputMember();
				break;
			case 2:
			case 3:
			case 4:
			case 0:
				System.out.println("이용해주셔서 감사합니다. 프로그램을 종료합니다.");
				return;
			default:
				System.out.println("메뉴를 잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}
	}
	
	/**
	 * id~취미까지 멤버정보를 입력받아 controller에 전달하는 메소드
	 */
	public void inputMember() {
		System.out.println("============== 회원 추가 ================");
		
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String userPwd = sc.nextLine();
		
		System.out.print("이름 : ");
		String userName = sc.nextLine();
		
		System.out.print("성별(M, F) : ");
		String gender = sc.nextLine().toUpperCase();
		
		System.out.print("나이 : ");
		String age = sc.nextLine();
		
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		
		System.out.print("전화번호 : ");
		String phone = sc.nextLine();
		
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		System.out.print("취미(,로 이어서 작성) : ");
		String hobby = sc.nextLine();
		
		mc.insertMember(userId, userPwd, userName, gender, age, email, phone, address, hobby);
	}

	//-------------------------------------응답화면------------------------------------
	
	/**
	 * 서비스 요청 후 처리를 성공적으로 완료했을 때 보게될 응답화면
	 * @param message : 성공메세지
	 */
	public void displaySuccess(String message) {
		System.out.println("\n서비스 요청 성공 : " + message);
	}
	
	/**
	 * 서비스 요청 후 처리를 성공적으로 완료했을 못했을 때 보게될 응답화면
	 * @param message : 실패메세지
	 */
	public void displayFail(String message) {
		System.out.println("\n서비스 요청 실패 : " + message);
	}
}





