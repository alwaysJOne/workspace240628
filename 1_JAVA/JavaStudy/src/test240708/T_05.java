package test240708;

import java.util.Scanner;

public class T_05 {

	public static void main(String[] args) {
		/*
		 키보드로 2개의 정수형 데이터를 입력 받아, 두 수가 모두 1부터 9까지의 수일 때만 두 수의 곱
		 이 한자리 수인지 두자리 수인지를 출력한다.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		if(num1 >= 1 && num1 <= 9 && num2 >= 1 && num2 <= 9) {
//			int result = num1 * num2;
//			if(result >= 10) {
//				System.out.println("두자리 수 입니다.");
//			} else {
//				System.out.println("한자리 수 입니다.");
//			}
			
			System.out.println((num1 * num2 >= 10) ? "두자리 수 입니다." : "한자리 수 입니다.");
		}
	}

}
