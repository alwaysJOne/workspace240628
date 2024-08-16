package com.kh.view;

import java.util.Scanner;

import com.kh.controller.BookController;
import com.kh.controller.MemberController;
import com.kh.controller.RentController;
import com.kh.vo.Member;

// View : 사용자가 보게될 시각인 요소(화면) 출력및 입력
public class MainMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	private BookController bc = new BookController();
	private RentController rc = new RentController();
	
	/**
	 * 메인화면 : 가장 처음나타나는 화면으로 다양한 메뉴로 진입할 수 있다.
	 */
	public void menu() {
		
		while(true) {
			System.out.println("===============도서관리프로그램=================");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 아이디찾기");
			System.out.println("4. 비밀번호찾기");
			System.out.println("9. 프로그램종료");
			System.out.print("메뉴 입력 : ");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				//로그인 화면
				loginMember();
				break;
			case 2:
				//회원가입 화면
				insertMember();
				break;
			case 3:
				break;
			case 4:
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못입력하였습니다. 다시입력해주세요");
			}
		}
	}
	
	/**
	 * 회원가입 화면 : 사용자에게 회원가입에 필요한 정보를 입력받아 controller로 전달
	 */
	public void insertMember() {
		System.out.println("==================회원가입=====================");
		System.out.print("아이디 입력 : ");
		String id = sc.nextLine();
		
		System.out.print("비밀번호 입력 : ");
		String pwd = sc.nextLine();
		
		System.out.print("이름 입력 : ");
		String name = sc.nextLine();
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		sc.nextLine();
		
		//회원추가
		Member m = new Member(id, pwd, name, age);
		if(mc.insertMember(m)) {
			System.out.println("회원가입에 성공하였습니다.");
		} else {
			System.out.println("회원가입에 실패하였습니다.");
		}
		
	}

	/**
	 * 로그인 화면 : 사용자에게 id, pwd받아서 controller로 전달하여 로그인처리
	 */
	public void loginMember() {
		System.out.println("================== 로그인 =====================");
		System.out.print("아이디 입력 : ");
		String id = sc.nextLine();
		
		System.out.print("비밀번호 입력 : ");
		String pwd = sc.nextLine();
	
		//로그인체크
		Member loginMember = mc.loginMember(id, pwd);
		if(loginMember == null) {
			System.out.println("로그인에 실패하였습니다. id, pwd를 다시 확인하세요.");
		} else {
			System.out.println("로그인에 성공하였습니다.");
			System.out.println(loginMember.getUserName() + "님 반갑습니다.");
			
			this.loginMenu(loginMember);
		}
	}
	
	
	public void loginMenu(Member loginMember) {
		//loginMember 만약 관리자면 도서관리
		//loginMember 일반회원이면 도서대여/반납
		
		while(true) {
			System.out.println("===============메뉴선택=================");
			System.out.println("1. 관리자모드");
			System.out.println("2. 회원모드");
			System.out.println("9. 로그아웃");
	
			System.out.print("메뉴 입력 : ");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				//관리자모드
				new LibraryMenu(loginMember, bc, sc, rc).menu();
				break;
			case 2:
				//회원모드
				new CustomerMenu(loginMember, bc, sc, rc).menu();
				break;
			case 9:
				System.out.println("로그아웃 되었습니다.");
				return;
			default:
				System.out.println("잘못입력하였습니다. 다시입력해주세요");
			}
		}
	}

}












