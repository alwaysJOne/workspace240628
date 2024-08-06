package c.controll;

import java.util.Scanner;

public class A_if2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//나이를 입력받아
		//13세이하 : 어린이
		//13세 초과 19세 이하 : 청소년
		//19세 초과 : 성인
		
		// 나이를 입력 : xx
		// xx세는 xxx에 속합니다.
		/*
		int age;
		
		System.out.print("나이를 입력 : ");
		age = sc.nextInt();
		
		//if문만을 이용해서
		if(age <= 13) {
			System.out.println(age + "세는 어린이에 속합니다.");
		}
		
		if(age > 13 && age <= 19) {
			System.out.println(age + "세는 청소년에 속합니다.");
		}
		
		if(age > 19) {
			System.out.println(age + "세는 성인에 속합니다.");
		}
		
		// if ~ else
		if(age <= 13) {
			System.out.println(age + "세는 어린이에 속합니다.");
		} else if(age <= 19){
			System.out.println(age + "세는 청소년에 속합니다.");
		} else {
			System.out.println(age + "세는 성인에 속합니다.");
		}
		*/
		
		//성별을 (m/f)(대소문자 상관x)로 입력받아 남학생인지 여학생인지
		//출력하는 프로그램을 작성하세요
		
		//성별(m/f) : X
		// 여학생입니다 / 남학생입니다 / 잘못입력하셨습니다.
		
		/*
		char gender;
		String result;
		
		System.out.print("성별(m/f) : ");
		gender = sc.next().charAt(0);
		
		if(gender == 'f' || gender == 'F') {
			result = "여학생";
		} else if(gender == 'm' || gender == 'M') {
			result = "남학생";
		} else {
			System.out.println("잘못입력하셨습니다.");
			return; // 함수를 끝낸다
		}
		
		System.out.println(result + "입니다.");
		*/
		
		//정수(양수)를 입력받아
		//짝수인지 홀수인지 출력하는 프로그램을 작성해라
		
		//정수 입력 : xx
		// 짝수다/ 홀수다 / 양수가 아닙니다.
		
		int num;
		
		System.out.print("정수 입력 : ");
		num = sc.nextInt();
		
		if(num > 0) {
			if(num % 2 == 0) {
				System.out.println("짝수다");
			} else {
				System.out.println("홀수다");
			}
		} else {
			System.out.println("양수가 아닙니다.");
		}
		
		if(num > 0 && num % 2 == 0) {
			System.out.println("짝수다.");
		} else if(num > 0 && num % 2 != 0) {
			System.out.println("홀수다.");
		} else {
			System.out.println("양수가 아닙니다.");
		}
		
		
		
	}
}
