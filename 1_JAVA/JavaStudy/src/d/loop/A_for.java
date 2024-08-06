package d.loop;

import java.util.Scanner;

public class A_for {
	/*
	 * <반복문>
	 * 프로그램 흐름을 제어하는 제어문 중 하나
	 * 어떤 실행코드를 반복적으로 수행시켜준다.
	 * 
	 * 크게 두 종류로 나뉨(for / while(do-while))
	 * 
	 * * for문
	 * 
	 * for(초기식; 조건식; 증감식){ //반복횟수를 지정하기 위해서 제시하는 것들 
	 * 		반복적으로 실행시키고자하는 코드더미
	 * }
	 * 
	 * - 초기식 : 반복문이 수행될 때 "처음에 단 한번만 실행하는 구문"
	 * 			(반복문 안에서 사용 될 변수를 선언및 초기화하는 작업)
	 * 
	 * - 조건식 : "반복문이 수행될 조건"을 작성하는 구문
	 * 			조건식이 true일 경우 해당 반복을 실행
	 * 			조건식이 false가 되는 순간 반복문을 탈출
	 * 			(초기식에서 제시된 변수를 가지고 조건식을 정함)
	 * 
	 * - 증감식 : 반복문을 제어하는 변수 값을 증감 시키는 구문
	 *         (보통 초기식에 제시된 변수를 가지고 증감을 시킴)
	 *         
	 *  tip
	 *  for문 안에 초기식, 조건식, 증감식 각각 생략 가능하다(단, 생략해서 쓰는 경우가 없다 -> while사용)
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
	
		//10번반복하는 반복문
//		for(int i=0; i < 10; i++) {
//			System.out.println("안녕하세요");
//		}
		 
		// i = 0 < 10 -> System.out.println("안녕하세요");
		// i = 1 < 10 -> System.out.println("안녕하세요");
		// i = 2 < 10 -> System.out.println("안녕하세요");
		// i = 3 < 10 -> System.out.println("안녕하세요");
		//...
		// i = 9 < 10 -> System.out.println("안녕하세요");
		// i = 10 < 10 -> 탈출
		
		//
		/*
		for(int i=11; i < 16; i++) {
			System.out.println("안녕하세요");
		}
		*/
		
		// 1~5까지 순차적으로 출력하세요 (1 2 3 4 5)
//		for(int i = 1; i <= 5; i++) {
//			System.out.print(i + " ");
//		}
		
		// 5~1까지 순차적으로 출력
//		for(int i = 5; i >= 1; i--) {
//			System.out.print(i + " ");
//		}
		
		//정수 n을 입력받아 1부터 n까지 1씩 증가시키면서 출력해라
		//정수입력 : 6
		// 1 2 3 4 5 6
		
		/*
		int num;
		
		System.out.print("정수입력 : ");
		num = sc.nextInt(); // 6
		
		// 
		for(int i=1; i <= num; i++) {
			System.out.print(i + " ");
		}
		*/
		
		// 1~10 숫자중 홀수만 출력
		// 1 3 5 7 9
		
		/*
		for(int i=1; i <= 10; i++) {
			if (i % 2 == 1) {
				System.out.print(i + " ");
			}
		}
		*/
		
		// 1부터 100까지의 총 합을 구해라
		// 1 + 2 + 3 ... 100
		
		/*
		int sum = 0;
		
		for(int i = 1; i < 101; i++) {
			sum += i;
		}
		
		System.out.println("1~100까지의 합 : " + sum);
		*/
		
		// 정수 n을 입력받아 1부터 n까지 1씩 증가하며 모든 수를 더해서 출력해라.
		
		//정수입력 : 5
		// 1부터 5까지의 합 : 15
		
		/*
		int n, sum = 0;
		System.out.print("정수입력 : ");
		n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			sum += i;
		}
		*/
		
		/*
		 * java.lang.Math 클래스에서 제공하는 random()메소드 호출하면 매번 다른 랜덤값을 받을 수 있다.
		 * 
		 * Math.random() 호출시 -> 0.0 ~ 0.9999999999999사이의 랜덤값을 반환
		 * 						0 <= ~ < 1.0
		 * int num = Math.random() // double형이라서 int로 랜덤값을 받을 수 없다.
		 * 
		 * int num = (int)(Math.random() * 10) -> 0 ~ 9
		 * 
		 * int num = (int)(Math.random() * 10) + 1 -> 1 ~ 10
		 * 
		 * int num = (int)(Math.random() * ((최대값 + 1) - 최소값)) + 최소값 
		 */
		
		/*
		int num = (int)Math.random() * 10;
		System.out.println(num);
		*/
		
		//random(1~10)한 숫자 n을 생성해서 1부터 n까지 모두 더한 값을 출력하세요.
		
		//random 수 : 5
		//1~5까지의 합 : 15
		
		/*
		int n, sum = 0;
		
		n = (int)(Math.random() * 10) + 1;
		for(int i = 1; i <= n; i++) {
			sum += i;
		}
		
		System.out.println("1부터 " + n + "까지의 합 : " + sum);
		
		sc.close();
		*/
		
		// random(5~50)한 순자 n을 생성해서 1부터 n까지의 숫자중 짝수만 출력해라(50포함)
		// random 수 : 10
		// 2 4 6 8
		
		// int num = (int)(Math.random() * ((최대값 + 1) - 최소값)) + 최소값 
		
		/*
		int n;
		n = (int)(Math.random() * 46) + 5;
		
		System.out.println("random 수 : " + n);
		for(int i = 1; i <= n; i++) {
			if(i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		*/
		
//		String str = "Hello";
		
		/*
		 * 각 인덱스별 문자 출력
		 * H -> str.charAt(0);
		 * e -> str.charAt(1);
		 * l -> str.charAt(2);
		 * l -> str.charAt(3);
		 * o -> str.charAt(4);
		 * 
		 * 문자열.length() : 문자열의 길이를 구하는 방법
		 */
		
		/*
		System.out.println(str.length());
		for(int i=0; i < str.length(); i++ ) {
			System.out.println(str.charAt(i));
		}
		*/
		
		//사용자에게 문자열을 입력받아 해당 문자열의 짝수자리 글자만 출력
		//문자열 입력 : hello
		//el
		
//		String str;
//		
//		System.out.print("문자열 입력 : ");
//		str = sc.next();
		
		//각 인덱스별 문자를 뽑아서 출력
		
		// apple 길이 : 5
		// 01234
		
		//strawberry 길이 : 10
		//0123456789
		
		/*
		for(int i=0; i < str.length(); i++) {
			if(i % 2 == 1) {
				System.out.println(str.charAt(i));
			}
		}
		*/
		
		// 구구단 2단을 출력해보자
		// 2 * 1 = 2
		// ...
		// 2 * 9 = 18
	
		/*
		System.out.print("원하는 구구단 : ");
		int dan = sc.nextInt();
		
		for(int i=1; i<10; i++) {
			System.out.println(dan + " * " + i + " = " + (dan * i));
		}
		*/
		
		/*
		 * 2 * 1 = 2
		 * 2 * 2 = 4
		 * 2 * 3 = 6
		 * ...
		 * 2 * 8 = 16
		 * 2 * 9 = 18
		 * 
		 * 3 * 1 = 3
		 * 3 * 2 = 6
		 * 3 * 3 = 9
		 * ...
		 * 3 * 8 = 24
		 * 3 * 9 = 27
		 */
		
		for(int j=2; j<10; j++) {
			for(int i=1; i<10; i++) {
				System.out.println(j + " * " + i + " = " + (j * i));
			}
		}
		
		
		
	}
	
	
}
