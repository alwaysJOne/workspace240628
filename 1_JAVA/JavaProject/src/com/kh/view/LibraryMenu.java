package com.kh.view;

import java.util.List;
import java.util.Scanner;

import com.kh.controller.BookController;
import com.kh.controller.RentController;
import com.kh.vo.Book;
import com.kh.vo.Member;

//View : 사용자가 보게될 시각인 요소(화면) 출력및 입력
public class LibraryMenu {
	private Member loginUser;
	private Scanner sc;
	private BookController bc;
	private RentController rc;
	
	public LibraryMenu(Member loginUser,BookController bc, Scanner sc, RentController rc) {
		super();
		this.loginUser = loginUser;
		this.bc = bc;
		this.sc = sc;
		this.rc = rc;
	}
	/**
	 * 메인화면 : 가장 처음나타나는 화면으로 다양한 메뉴로 진입할 수 있다.
	 */
	public void menu() {
		
		while(true) {
			System.out.println("===============도서관리 메뉴=================");
			System.out.println("1. 도서등록");
			System.out.println("2. 도서수정");
			System.out.println("3. 도서목록");
			System.out.println("4. 도서삭제");
			System.out.println("5. 도서검색");
			System.out.println("9. 프로그램종료");
			System.out.print("메뉴 입력 : ");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				insertBook();
				break;
			case 2:
				updateBook();
				break;
			case 3:
				allPrintBook();
				break;
			case 4:
				deleteBook();
				break;
			case 5:
				searchBook();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못입력하였습니다. 다시입력해주세요");
			}
		}
	}
	
	//모든 책목록을 출력해주기 위한 메소드
	public void allPrintBook() {
		System.out.println("===============전체 도서 목록==============");
		List<Book> bList = bc.getBookList();
		
		System.out.printf("%7s %12s %5s\n", "장 르", "제 목", "글쓴이");
		for(Book b : bList) {
			b.printInfo();
		}
	}
	
	public void insertBook() {
		System.out.println("==================도서등록=====================");
		System.out.print("책제목 입력 : ");
		String title = sc.nextLine();
		
		System.out.print("저자 입력 : ");
		String author = sc.nextLine();
		
		System.out.print("장르 입력 : ");
		String genre = sc.nextLine();
		
		Book b = new Book(title, author, genre);
		if(bc.insertBook(b)) {
			System.out.println("책 등록 완료");
		} else {
			System.out.println("책 등록 실패");
		}
		
	}
	
	public void updateBook() {
		System.out.println("==================도서수정=====================");
		int i = 0;
		while(i < 3) {
			System.out.print("수정할 책제목 입력 : ");
			String updateTitle = sc.nextLine();
			
			//updateTitle과 같은제목의 책이 있나?
			Book searchBook = bc.searchBookByTitle(updateTitle);
			if (searchBook == null) {
				System.out.println("해당 제목의 책이 존재하지 않습니다.");
				i++;
				continue;
			}
			
			System.out.print("수정할 책제목 입력 : ");
			String title = sc.nextLine();
			
			System.out.print("수정할 저자 입력 : ");
			String author = sc.nextLine();
			
			System.out.print("수정할 장르 입력 : ");
			String genre = sc.nextLine();
			
			//searchBook -> 새로운 객체로 변경
			Book newBook = new Book(title, author, genre);
			if(bc.updateBook(searchBook, newBook)) {
				System.out.println("책 수정 성공");
			} else {
				System.out.println("책 수정 실패");
			}
			return;
		}
		
	}
	
	public void deleteBook() {
		this.allPrintBook();
		
		System.out.print("삭제할 책제목 입력 : ");
		String title = sc.nextLine();
		
		Book b = bc.searchBookByTitle(title);
		
		if(b == null) {
			System.out.println("입력한 책을 찾을 수 없습니다.");
			return;
		}
		
		if(bc.deleteBook(b)) {
			System.out.println("정상적으로 삭제하였습니다.");
		} else {
			System.out.println("삭제에 실패하였습니다.");
		}
	}
	
	public void searchBook() {
		System.out.println("==================도서검색==================");
		System.out.print("검색할 키워드를 입력해주세요 : ");
		String keyword = sc.nextLine();
		
		List<Book> bookList = bc.searchBook(keyword);
		if (bookList.isEmpty()) {
			System.out.println("검색결과가 없습니다.");
		} else {
			System.out.println("============검색도서목록==============");
			System.out.printf("%7s %12s %5s\n", "장 르", "제 목", "글쓴이");
			for(Book b : bookList) {
				b.printInfo();
			}
		}
	}
}
