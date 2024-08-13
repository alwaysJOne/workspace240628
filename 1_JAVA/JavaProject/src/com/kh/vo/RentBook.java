package com.kh.vo;

import java.util.Date;

//책을 빌리는 기준
//모든책은 한권뿐이라는 가정
//모든 책의 제목은 겹치지 않는다.
public class RentBook {
	private String title;
	private int userNo;
	private Date rentDate;
	
	public RentBook() {
		super();
	}

	public RentBook(String title, int userNo, Date rentDate) {
		super();
		this.title = title;
		this.userNo = userNo;
		this.rentDate = rentDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	@Override
	public String toString() {
		return "RentBook [title=" + title + ", userNo=" + userNo + ", rentDate=" + rentDate + "]";
	}
}
