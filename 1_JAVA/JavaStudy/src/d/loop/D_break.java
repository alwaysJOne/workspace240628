package d.loop;

import java.util.Scanner;

public class D_break {
	/*
	 * break;   : 반복문,switch문 안에서 사용되는 분기문
	 * 			  break;가 실행되는 순간 현재 속해있는 가장 가까운 반복문 또는 switch문을 강제로 탈출함
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//랜덤값(1~100) 발생시키고 그 랜덤값을 출력(이 과정을 계속 반복)
		//단, 발생한 값이 3의 배수(3으로 나누면 0)일 경우 반복문을 종료
		
		while(true) {
			int random = (int)(Math.random() * 100) + 1; 
			
			System.out.println(random);
			
			if(random % 3 == 0) {
				break;
			}
		}
		
		
//		int random;
//		do {
//			random = (int)(Math.random() * 100) + 1; 
//			
//			System.out.println(random);
//			
//		} while(random % 3 != 0);
		
		//사용자에게 문자열을 입력받아 해당 문자열의 길이를 출력(과정 반복)
		// 단, 사용자가 입력한 문자열이 "exit"일 경우 반복문을 탈출
		
		String str;
		
		while(true) {
			System.out.print("문자열 입력 : ");
			str = sc.next(); // 문자열입력받기
			
			if(str.equals("exit")) {
				break;
			}
			
			System.out.println("길이 : " + str.length());
		}
	}
}
