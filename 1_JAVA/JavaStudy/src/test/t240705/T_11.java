package test.t240705;

import java.util.Scanner;

public class T_11 {

	public static void main(String[] args) {
		/*
		 1부터 100 사이의 정수 중 임의의 난수가 정해지고 사용자는 정해진 난수를 맞추는데 
		 몇 번 만에 맞췄는지 출력하세요.
			ex.
			90
			1~100 사이의 임의의 난수를 맞춰보세요 : 0
			1~100 사이의 숫자를 입력해주세요.
			1~100 사이의 임의의 난수를 맞춰보세요 : 101
			1~100 사이의 숫자를 입력해주세요.
			1~100 사이의 임의의 난수를 맞춰보세요 : 50
			UP !
			1~100 사이의 임의의 난수를 맞춰보세요 : 75
			UP !
			1~100 사이의 임의의 난수를 맞춰보세요 : 83
			UP !
			1~100 사이의 임의의 난수를 맞춰보세요 : 93
			DOWN !
			1~100 사이의 임의의 난수를 맞춰보세요 : 89
			UP !
			1~100 사이의 임의의 난수를 맞춰보세요 : 92
			DOWN !
			1~100 사이의 임의의 난수를 맞춰보세요 : 90
			정답입니다 !!
			7회만에 맞추셨습니다.
		 */
		Scanner sc = new Scanner(System.in);
		
		int rand = (int)(Math.random() * 100) + 1;
		System.out.println(rand);
		
		int count = 0;
		
		while(true) {
			System.out.print("1~100 사이의 임의의 난수를 맞춰보세요 : ");
			int num = sc.nextInt();
			
			if(!(num >= 1 && num <= 100)) {
				System.out.println("1~100사이의 숫자를 입력하세요.");
				continue;
			} 
			
			count++;
			
			if (num == rand) {
				System.out.println("정답입니다.");
				System.out.println(count + "회만에 맞추셨습니다.");
			} else if (num > rand) {
				System.out.println("DOWN !");
			} else {
				System.out.println("UP !");
			}
		}
	}

}
