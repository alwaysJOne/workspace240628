package com.kh.view;

import java.util.List;
import java.util.Scanner;

import com.kh.controller.BookController;
import com.kh.controller.RentController;
import com.kh.vo.Book;
import com.kh.vo.Member;

public class CustomerMenu {
	private Member loginUser;
	private Scanner sc;
	private BookController bc;
	private RentController rc;
	
	public CustomerMenu(Member loginUser,BookController bc, Scanner sc, RentController rc) {
		super();
		this.loginUser = loginUser;
		this.bc = bc;
		this.sc = sc;
		this.rc = rc;
	}
	
	public void menu() {
		
		while(true) {
			System.out.println("===============도서대여 메뉴=================");
			System.out.println("1. 도서대여");
			System.out.println("9. 프로그램종료");
			System.out.print("메뉴 입력 : ");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				rentBook();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못입력하였습니다. 다시입력해주세요");
			}
		}
	}
	
	public void rentBook() {
		System.out.println("=================대여가능 책 목록======================");
		List<Book> bList = bc.getBookList();
		List<Book> ableList = rc.getRentAble(bList);
		
		System.out.printf("%7s %12s %5s\n", "장 르", "제 목", "글쓴이");
		for(Book b : ableList) {
			b.printInfo();
		}
		
		System.out.println("어떤 책을 대여하시겠습니까?(제목) : ");
		String title = sc.nextLine();
		
		for (Book b : ableList) {
			if (b.getTitle().equals(title)) {
				if(rc.insertRentBook(b, loginUser)) {
					System.out.println("대여를 완료하였습니다.");
					return;
				}
			}
		}
		
		System.out.println("대여가능한 책을 확인후 다시 이용바랍니다.");
	}
}
