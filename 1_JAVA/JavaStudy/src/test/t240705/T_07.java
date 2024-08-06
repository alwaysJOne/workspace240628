package test.t240705;

import java.util.Scanner;

public class T_07 {

	public static void main(String[] args) {
		/*
		 사용자로부터 두 개의 값을 입력 받아 그 사이의 숫자를 모두 출력하세요.
		 만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력되면서
		 다시 사용자가 값을 입력하도록 하세요.

		ex.
		첫 번째 숫자 : 8	첫 번째 숫자 : 4	첫 번째 숫자 : 9
		두 번째 숫자 : 4 	두 번째 숫자 : 8 	두 번째 숫자 : 0
		4 5 6 7 8 		4 5 6 7 8 		1 이상의 숫자를 입력해주세요.
										첫 번째 숫자 : 6
										두 번째 숫자 : 2
										2 3 4 5 6 
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int num1, num2, max, min;
		while(true) {
			System.out.print("첫 번째 숫자 : ");
			num1 = sc.nextInt();
			
			System.out.print("두 번째 숫자 : ");
			num2 = sc.nextInt();
			
			//둘중 더 큰수 구하기
			max = (num1 > num2) ? num1 : num2;
			min = (num1 < num2) ? num1 : num2;
			
			if (min < 1 || max < 1) {
				System.out.println("1 이상의 숫자를 입력해주세요.");
			} else {
				for(int i = min; i <= max; i++) {
					System.out.print(i + " ");
				}
				break;
			}
		}
	}

}
