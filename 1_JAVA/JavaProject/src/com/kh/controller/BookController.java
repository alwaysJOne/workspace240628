package com.kh.controller;

import com.kh.vo.Book;

//controller의 역할
//vo객체를 이용해서 기능을 수행해주는 역할
public class BookController {
	private Book[] bookList = new Book[100];

	public BookController() {
		super();
		bookList[0] = new Book("아프니까 청춘이다", "최지원", "인문",25000 );
		bookList[1] = new Book("자바에 정석", "남궁섬", "기타",30000 );
		bookList[2] = new Book("대화의 기술", "김수민", "인문",45000 );
		bookList[3] = new Book("암 정복기", "최장군", "의료",15000 );
		
	}
	
	public void inertBook(Book bk) {
		// bookList에 bk저장
		//가장 앞쪽에 비어있는 공간(null)을 찾아서 bk저장
		
		for(int i=0; i<bookList.length; i++) {
			if(bookList[i] == null) {
				bookList[i] = bk;
				break;
			}
		}
	}
	
	public Book[] getBookList() {
		return this.bookList;
	}
	
	//keyword가 제목에 포함되어있는 도서 목록 반환
	public Book[] searchBook(String keyword) {
		Book[] searchBook = new Book[this.bookList.length];
		int index = 0;
		
		for(int i=0; i < this.bookList.length; i++) {
			if(bookList[i] == null) {
				break;
			} else if (bookList[i].getTitle().contains(keyword)) {
				searchBook[index] = bookList[i];
				index++;
			}
		}
		
		return searchBook;
	}
	
	//해당 index의 도서가 있으면 true
	//                 없으면 false
	public boolean isBook(int index) {
		//index 배열의 길이보다 작아야함 0~99
		//this.bookList[index] != null
		if(index >= 0 && index < bookList.length && bookList[index] != null) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public void updateBook(int index, Book b) {
		this.bookList[index] = b;
	}
}









