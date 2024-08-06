package e.array;

import java.util.Scanner;

public class A_Array3 {
	public static void main(String[] args) {
		// 1. 크기가 10인 정수형 배열 생성후
			//int[] arr = new int[10];
		// 2. 반복문을 통해서 0번인덱스부터 마지막인덱스까지 모든값을 1로 초기화
		// 0~(배열의 길이 - 1)까지 반복
//			for(int i=0; i < arr.length; i++) {
//				arr[i]=1;
//			}
			
		// 3. 반복문을 통해서 0~마지막인덱스까지 전부 출력
//			for(int i=0; i< arr.length; i++) {
//				System.out.println(arr[i]);
//			}
		
		
		Scanner sc = new Scanner(System.in);
		/*
		// 4. 사용자에게 배열의 길이를 입력받아 해당크기의 문자열배열을 생성해라.
		// 길이 입력 : x
		int size;
		
		System.out.print("길이 입력 : ");
		size = sc.nextInt();
		
		String[] strArr = new String[size];
		
		//5. 반복문을 활용해서 매번 사용자에게 과일명을 입력받아 그값을 strArr에 대입(0~마지막인덱스)
		//좋아하는 과일을 입력 : 바나나(반복)
		for(int i=0; i < strArr.length; i++) {
			System.out.print("좋아하는 과일을 입력 : ");
			strArr[i] = sc.next();
		}
		
		//6. 반복문을 이용해서 srtArr에있는 모든 값을 출력
		for(int i=0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}
		*/
		
		/*
		//사용자에게 문자열 하나 입력받은 후 
		//각각의 인덱스에 있는 문자들을 char배열에 옮겨담기
		
		//1. 사용자에게 문자열 하나 입력받은 후
		System.out.print("문자열 입력 : ");
		String str = sc.next(); //apple
		
		//2. char배열 생성하기(길이 => 문자열의 길이)
		char[] chArr = new char[str.length()];
		
		//3. 반복문을 통해서 해당 문자열에서 각각 인덱스별 문자를 char배열에 각 인덱스값에 대입
		for(int i=0; i < chArr.length; i++) {
			chArr[i] = str.charAt(i);
		}
		
		//4. char배열의 모든 index값을 전체 출력
		for(int i=0; i < chArr.length; i++) {
			System.out.println(chArr[i]);
		}
		*/
		
		//사용자에게 배열의 길이를 입력받아 해당 길이의 정수형배열 arr을 생성한다.
		//arr에 모든 인덱스값에 1~100사이의 랜덤값을 할당해주고
		//arr에 모든 값을 출력한 후
		//이중 짝수인 값의 총 합을 구해서 출력
		
		//정수입력 : 3
		//4 7 15
		//짝수 총 합 : 4
		
		System.out.print("정수 입력 : ");
		int size = sc.nextInt();
		int sum = 0;
		
		int[] arr = new int[size];
		for(int i=0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 100) + 1;
		}
		
		for(int i=0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		for(int i=0; i < arr.length; i++) {
			if(arr[i] % 2 == 0) {
				sum += arr[i];
			}
		}
		
		System.out.println();
		System.out.print("짝수의 총 합 : " + sum);
		
		
		
		
		
		
		
		
	}
}
