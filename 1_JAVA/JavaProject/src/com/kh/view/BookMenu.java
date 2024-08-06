package com.kh.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.kh.controller.BookController;
import com.kh.vo.Book;



//사용자와의 소통을 위한 입출력을 담당하는 클래스
public class BookMenu {
	Scanner sc = new Scanner(System.in);
	BookController bc = new BookController();
	
	public void mainMenu() {
		System.out.println("== Welcome KH Library ==");
		
		while(true) {
			System.out.println("\n********** 메인 메뉴 **********");
			System.out.println("1. 새 도서 등록");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색 조회");
			System.out.println("4. 도서 정보 수정");
			System.out.println("5. 도서 삭제");
			System.out.println("9. 종료");
			System.out.print("메뉴 입력 : ");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				try {
					this.insertBook();
				}catch(InputMismatchException e) {
					sc.nextLine();
					System.out.println("잘못된 입력입니다.");
					System.out.println("도서추가를 실패하였습니다.");
				}
				break;
			case 2:
				this.selectBookList();
				break;
			case 3:
				this.searchBook();
				break;
			case 4:
				this.updateBook();
				break;
//			case 5:
//				this.deleteBook();
//				break;
			case 9:
				System.out.println("도서관리 프로그램 종료");
				return; //1.메소드종료 2.값반환
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	public void insertBook() {
	
		//도서정보를 저장
		System.out.println("=== 새 도서 추가 ==");
		System.out.println("책 정보를 입력해주세요.");
		
		Book newBook = this.createBook();
		bc.inertBook(newBook);
	}

	public void selectBookList() {
		System.out.println("\n==== 도서 전체 조회 ====");
		Book[] bookList = bc.getBookList();
		
		printBookList(bookList, "등록된 도서가 없습니다.");
	}

	public void searchBook() {
		System.out.println("\n==== 도서 검색 ====");
		System.out.print("검색 키워드 : ");
		String keyword = sc.nextLine();
		
		Book[] bookList = bc.searchBook(keyword);
	
		printBookList(bookList, "검색된 도서가 없습니다.");
	}
	
	public void updateBook() {
		System.out.println("\n==== 도서 수정 ====");
		this.selectBookList();
		System.out.print("수정할 도서번호 입력 : ");
		int index = sc.nextInt();
		sc.nextLine();
		
		//해당도서가 존재하는지부터 확인
		if(bc.isBook(index)) {
			System.out.println("수정할 도서 정보 입력");
			Book newBook = this.createBook();
			bc.updateBook(index, newBook);
			System.out.println("도서 정보 수정완료");
		} else {
			System.out.println("도서 번호를 잘못 입력하셨습니다.");
		}
	}
	
	//단순하게 BookList를 출력
	public void printBookList(Book[] bookList, String emptyMsg) {
		if(bookList == null || bookList[0] == null) {
			System.out.println(emptyMsg);
		} else {
			for(int i=0; i < bookList.length; i++) {
				Book b = bookList[i];
				if(b == null)
					break;
				System.out.println(i + "번 " + b.toString());
			}	
		}
	}
	
	public Book createBook() {
		System.out.print("도서명 : ");
		String title = sc.nextLine();
		
		System.out.print("저자명 : ");
		String author = sc.nextLine();
		
		System.out.print("장르(1. 인문 / 2.과학 / 3.외국어 / 4.자기개발 / 5.기타) : ");
		int categoryNumber = sc.nextInt();
		
		String genre = "기타";
		switch(categoryNumber) {
		case 1:
			genre = "인문";
			break;
		case 2:
			genre = "과학";
			break;
		case 3:
			genre = "외국어";
			break;
		case 4:
			genre = "자기개발";
			break;
		}
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		Book newBook = new Book(title, author, genre, price);
		return newBook;
	}
}





