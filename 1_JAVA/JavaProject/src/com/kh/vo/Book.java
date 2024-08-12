package com.kh.vo;

import java.util.Objects;

public class Book {
	private String title;
	private String author;
	private String genre;
	
	public Book(String title, String author, String genre) {
		super();
		this.title = title;
		this.author = author;
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(title, author, genre);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Book) {
			Book book = (Book)obj;
			
			if(this.title.equals(book.getTitle()) &&
				this.author.equals(book.getAuthor()) &&
				this.genre.equals(book.getGenre())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return genre + " " + title +  " " + author;
	}
	
	public void printInfo() {
		System.out.printf("%7s %12s %5s\n", this.genre, this.title, this.author);
	}
	
	public boolean containKeyword(String keyword) {
		return this.title.contains(keyword) || this.author.contains(keyword) || this.genre.contains(keyword);
	}
}
