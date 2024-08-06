package m.api.ex1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class D_Date {
	public void method01() {
		Date date1 = new Date();
		System.out.println(date1);
		
		//내가 원하는 날짜(2024년 12월 12일)로 세팅
		//1) 생성자를 통해서 생성
		Date date2 = new Date(2024 - 1900, 12 - 1, 12);
		System.out.println(date2);
		
		//2) 기본생성자로 생성한 후에 setter메소드로 값 변환
		date1.setYear(2024 - 1900);
		date1.setMonth(6-1);
		date1.setDate(28);
		date1.setHours(9);
		date1.setMinutes(0);
		date1.setSeconds(37);
		System.out.println(date1);
		
		System.out.println(date1.getTime());
		
		System.out.println(1900 + date1.getYear() + "년 " );
		
		//SimpleDateFormat
		//시간을 보여주기위한 형식을 지정하는 객체
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String date5 = sdf.format(date1);
		System.out.println(date5);
	}
}
