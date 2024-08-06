package test.t240704;

import java.util.Scanner;

public class T_07 {

	public static void main(String[] args) {
		/*
		 	문자열을 입력 받아 문자 하나하나를 배열에 넣고 검색할 문자가 문자열에 몇 개 들어가 있는지
			개수와 몇 번째 인덱스에 위치하는지 인덱스를 출력하세요.
			
			ex.
			문자열 : application
			문자 : i
			application에 i가 존재하는 위치(인덱스) : 4 8 
			i 개수 : 2
		 */

		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 : ");
		String str = sc.next(); // a p p l i c a t i o n
		
		System.out.print("문자 : ");
		char ch = sc.next().charAt(0); //i
		
		char[] chArr = new char[str.length()];
		for(int i=0; i < chArr.length; i++) {
			chArr[i] = str.charAt(i);
		}
		
		System.out.print(str + "에 " + ch + "가 존재하는 위치(인덱스) :");
		//str에서 i위치
		int count = 0;
		for(int i=0; i < chArr.length; i++) {
			if (chArr[i] == ch) { //문자열에서 가져온 n번째 문자와 입력받은 문자 비교
				System.out.print(i + " ");
				count++; //똑같은 문자를 찾았을 때 카운팅
			}
		}
		
		System.out.println();
		System.out.println(ch + "개수 : " + count);
		
	}

}
