package b.operator;

import java.util.Scanner;

public class Operator5 {
	/*
	 * 논리연산자
	 * 두개의 논리값을 연산해주는 연산자
	 * 논리연산한 결과도 논리값이 된다.
	 * 
	 * 논리값 && 논리값 : 왼쪽, 오른쪽에 두 논리값이 모두 true일 때만 결과가 true이다.
	 * 논리값 || 논리값 : 왼쪽, 오른쪽 두 값중 하나라도 true라면 결과는 true가 된다.
	 * 
	 * &&
	 * true && ture -> true;
	 * true && false -> false;
	 * false && ture -> false;
	 * false && false -> false;
	 * => 앞의 결과가 false일 경우 뒤의 조건은 궂이 실행하지 않는다.
	 * 
	 * ||
	 * true || ture -> true;
	 * true || false -> true;
	 * false || ture -> ture;
	 * false || false -> false;
	 * => 앞의 결과가 true일 경우 뒤의 조건은 궂이 실행하지 않아도 된다.
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		// 사용자에게 숫자를 입력받아 해당 숫자가 1~100사이의 값인지 확인
		int num1;
		System.out.print("정수 하나 입력 :");
		num1 = sc.nextInt();
		
		// 1 <= num1 <= 100 -> 1 <= num1 && num1 <= 100
		boolean result = (1 <= num1) && (num1 <= 100);
		System.out.println("사용자가 입력한 값은 1이상 100이하이다 : " + result);
		*/
		
		//사용자에게 알파벳 하나를 입력받아 대소문자를 확인
		//문자 하나 입력 : 
		// 사용자가 입력한 값이 대문자 입니다 : (true/false)
		/*
		char ch;
		System.out.print("문자 하나 입력 : ");
		// 문자하나를 입력받을 때는 charAt을 이용하자
		ch = sc.next().charAt(0);
		
		//1번 방법
		boolean res1 = (ch >= 65) && (ch <= 90);
		boolean res2 = (ch >= 'A') && (ch <= 'Z');
		boolean res3 = (ch >= 'a') && (ch <= 'z');
		
		System.out.println("사용자가 입력한 값이 대문자 입니다 : " + res2);
		System.out.println("사용자가 입력한 값이 소문자 입니다 : " + res3);
		System.out.println("사용자가 입력한 값이 알파벳입니다 : " + (res2 || res3));
		*/
		
		int num = 10;
		
		boolean result = (num > 5) && (++num > 0); 
		
		System.out.println("연산후의 num : " + num);
	}

}
