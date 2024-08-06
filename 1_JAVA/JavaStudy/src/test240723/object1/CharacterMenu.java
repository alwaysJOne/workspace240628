package test240723.object1;

import java.util.Scanner;

public class CharacterMenu {
	public void menu() {
		// 사용자에게 문자열을 입력 받아 CharacterController의 countAlpha()에
		// 매개변수로 넘겨주어 반환 값을 출력함
		// 이 때 countAlpha()메소드를 호출하는 부분부터 try~catch를 이용하여 예외 처리
	
		Scanner sc = new Scanner(System.in);
		CharacterController cc = new CharacterController();
	
		try {
			System.out.print("문자열 : ");
			String str = sc.nextLine();
			int length = cc.countAlpha(str);
			System.out.println("\'" + str + "\'에 포함된 영문자 개수 : " + length);
		} catch(CharCheckException e) {
			System.out.println("문자열에 공백이 포함되어있습니다.");
			e.printStackTrace();
		} finally {
			sc.close();
			System.out.println("잘 종료되었습니다.");
		}
	}
}
