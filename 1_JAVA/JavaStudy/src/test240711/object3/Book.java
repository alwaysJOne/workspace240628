package test240711.object3;

public class Book {
	
	private String title; //제목
	private String genre; //장르
	private String author; //저자
	private int number;//책번호
	
	public Book(String title, String genre, String author, int number) {
		super();
		this.title = title;
		this.genre = genre;
		this.author = author;
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String toString() {
		return "제목 : " + this.title + " 장르 : " + this.genre + " 저자 : " + this.author + " 책번호 : " + this.number;
	}

}
