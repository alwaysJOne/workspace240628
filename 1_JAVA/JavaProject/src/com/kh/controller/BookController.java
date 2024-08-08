package com.kh.controller;

import java.util.ArrayList;
import java.util.List;

import com.kh.vo.Book;

public class BookController {
	private List<Book> bookList = new ArrayList<>();
	
	public boolean insertBook(Book b) {
		return bookList.add(b);
	}
	
	/**
	 * 
	 * @param title
	 * @return Book(제목이 일치하는 책이 있을 경우). null(없을경우)
	 */
	public Book searchBookByTitle(String title) {
		for(Book b : bookList) {
			if(b.getTitle().equals(title)) {
				return b;
			}
		}
		
		return null;
	}
	
	public boolean updateBook(Book oldBook, Book newBook) {
		int i = bookList.indexOf(oldBook); // 검색해온 책이 몇번째 인덱스에 존재하는지 반환
		Book b = bookList.set(i, newBook); // 찾은 인덱스위치 책을 새로운 책으로 수정한다.
		return b != null;
	}
}
