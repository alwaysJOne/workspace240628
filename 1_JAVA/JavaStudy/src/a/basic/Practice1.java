package a.basic;

import java.util.Scanner;

public class Practice1 {
	/*
	 * 키보드로 정수 두개를 입력받아 두 수의 합, 차, 곱, 나누기한 값을 출력하세요.
	 * 
	 * 첫번째 정수 : (키보드로 숫자입력)
	 * 두번째 정수 : (키보드로 숫자입력)
	 * 
	 * 더하기 : n
	 * 빼기 : n
	 * 곱하기 : n
	 * 나누기 : n
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1, num2;
		
		System.out.print("첫번째 정수 : ");
		num1 = sc.nextInt();
		sc.nextLine();
		
		System.out.print("두번째 정수 : ");
		num2 = sc.nextInt();
		sc.nextLine();
		
		System.out.println("더하기 : " + (num1 + num2));
		System.out.println("빼기 : " + (num1 - num2));
		System.out.println("곱하기 : " + (num1 * num2));
		System.out.println("나누기 : " + (num1 / num2));
	}
}
