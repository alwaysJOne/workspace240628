package test.t240704;

import java.util.Scanner;

public class T_08 {

	public static void main(String[] args) {
		/*
		 “일“ ~ “토”까지 초기화된 문자열 배열을 만들고 0부터 6까지 숫자를 입력 받아
			입력한 숫자와 같은 인덱스에 있는 요일을 출력하고 
			범위에 없는 숫자를 입력 시 “잘못 입력하셨습니다“를 출력하세요.
			
			ex.
			0 ~ 6 사이 숫자 입력 : 4			0 ~ 6 사이 숫자 입력 : 7
			목요일						    잘못 입력하셨습니다.
			
			// 일 월 화 수 목 금 토
		 */
		
		Scanner sc = new Scanner(System.in);
		String[] strArr = {"일", "월", "화", "수", "목", "금", "토"};
		System.out.print("0~6사이의 숫자 입력 : ");
		int num = sc.nextInt();
		
		if(num >= 0 && num < 7) {
			System.out.print(strArr[num] + "요일");
		} else {
			System.out.println("잘못 입력하였습니다.");
		}
	}

}
