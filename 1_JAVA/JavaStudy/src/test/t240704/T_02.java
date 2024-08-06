package test.t240704;

import java.util.Scanner;

public class T_02 {
	public static void main(String[] args) {
		/*
		 사용자에게 관리자, 회원, 비회원 중 하나를 입력 받아 각 등급이 행할 수 있는 권한을 출력하세요.
		단, 관리자는 회원관리, 게시글 관리, 게시글 작성, 게시글 조회, 댓글 작성이 가능하고
		회원은 게시글 작성, 게시글 조회, 댓글 작성이 가능하고
		비회원은 게시글 조회만 가능합니다.
		
		ex.
		권한을 확인하고자 하는 회원 등급 : 관리자
		회원관리 게시글관리 게시글작성 댓글작성 게시글조회 
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("권한을 확인하고자 하는 회원 등급 : ");
		String role = sc.next();
		String access = "";
		
//		if(role.equals("관리자")) {
//			System.out.println("회원관리 게시글 관리 게시글 작성 게시글 조회 댓글 작성");
//		}else if(role.equals("회원")) {
//			System.out.println("게시글 작성 게시글 조회 댓글 작성");
//		}else if(role.equals("비회원")) {
//			System.out.println("게시글 조회");
//		}else {
//			System.out.println("잘못입력하셨습니다.");
//		}
		
		switch(role) {
		case "관리자":
			access += "회원관리 게시글 관리 ";
		case "회원":
			access += "게시글 작성 댓글 작성";
		case "비회원":
			access += "게시글 조회";
			break;
		default:
			System.out.println("잘못입력하셨습니다.");
			return;
		}
		System.out.println();
	}
}
