package c.controll;

import java.util.Scanner;

public class A_if1 {
	/*
	 * 기본적으로 프로그램의 진행은 순차적으로 이루어진다.
	 * 단, 이 순차적인 흐름을 바꾸고자할 때 제어문이라는 것을 이용해서 직접 제어가 가능하다.
	 * 
	 * 선택적으로 실행시키고자 한다면 => 조건문
	 * 반복적으로 실행시키고자 한다면 => 반복문
	 * 
	 * *조건문
	 * "조건식"을 통해 참 또는 거짓을 판단하여 참일경우 그에 해당하는 코드를 실행
	 * 
	 * 조건식의 결과는 true/false여야한다.
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		 * if문 단독으로 사용하는 경우
		 * 
		 * if(조건식){
		 * 	  ...실행문
		 * }
		 * 
		 * 조건식이 true -> 중괄호 블럭안의 코드를 실행
		 * 조건식이 false -> 중괄호 블럭안의 코드를 무시하고 넘어간다.
		 */
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		
		if(num > 0) {
			System.out.println("양수이다.");
		}
		
		if(num == 0) {
			System.out.println("0이다.");
		}
		
		if(num < 0) {
			System.out.println("음수이다.");
		}
		
		//====================================================
		
		if(num > 0) {
			System.out.println("양수이다.");
		} else {
			if(num == 0) {
				System.out.println("0이다.");
			} else {
				System.out.println("음수이다.");
			}
		}
		
		//===============================================
		if(num > 0) {
			System.out.println("양수이다.");
		} else if(num == 0) {
			System.out.println("0이다.");
		} else {
			System.out.println("음수이다.");
		}
		
	}
}
