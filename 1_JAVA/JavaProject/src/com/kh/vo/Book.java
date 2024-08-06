package com.kh.vo;

public class Book {
	//필드
	private String title;
	private String author;
	private String category;
	private int price;
	
	//생성자
	public Book() {
		super();
	}
	public Book(String title, String author, String category, int price) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
	}
	
	//메소드
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "제목:" + title + " 작가:" + author + " 분류:" + category + " 가격:" + price;
	}
}
