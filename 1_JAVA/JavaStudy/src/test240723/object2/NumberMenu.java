package test240723.object2;

import java.util.Scanner;

public class NumberMenu {
	public void menu() {
		
		Scanner sc = new Scanner(System.in);
		// 사용자에게 두 정수를 입력 받아 NumberController의 checkDouble()에
		// 매개변수로 넘겨주어 반환 값을 출력함
		// 이 때 checkDouble()메소드를 호출하는 부분부터 try~catch를 이용하여 예외 처리
		
		System.out.print("정수1 : ");
		int num1 = sc.nextInt();
		
		System.out.print("정수2 : ");
		int num2 = sc.nextInt();
		
		NumberController nc = new NumberController();
		try {
			boolean isDouble = nc.checkDouble(num1, num2);
			System.out.printf("%d은(는) %d의 배수인가 ? %b \n",num1,num2,isDouble);
		} catch (NumRangeException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
}
