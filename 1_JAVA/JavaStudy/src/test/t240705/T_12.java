package test.t240705;

import java.util.Scanner;

public class T_12 {

	public static void main(String[] args) {
		/*
		  사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요. 컴퓨터가 가위인지 보인지 주먹인지는
			랜덤한 수를 통해서 결정하도록 하고, 사용자에게는 직접 가위바위보를 받으세요.
			사용자가 “exit”를 입력하기 전까지 가위바위보를 계속 진행하고 “exit”가 들어가면 반복을 멈추고
			몇 번의 승부에서 몇 번 이기고 몇 번 비기고 몇 번 졌는지 출력하세요.

			당신의 이름을 입력해주세요 : 박신우          가위바위보 : exit
			가위바위보 : 가위                        3전 0승 2무 1패
			컴퓨터 : 가위
			박신우 : 가위
			비겼습니다.
			
			가위바위보 : 가위
			컴퓨터 : 바위
			박신우 : 가위
			졌습니다 ㅠㅠ
			
			가위바위보 : 가위
			컴퓨터 : 가위
			박신우 : 가위
			비겼습니다.

			//컴퓨터에 랜덤으로 "가위,바위,보"중 하나를 부여해야한다.
			//문자열을 랜덤으로 줄 수 없으니 우리는 랜덤 숫자를 부여하자
			//		int com = (int)(Math.random() * 3); //0(가위) 1(바위) 2(보)
			//		gameArr[0] -> 가위
			//		gameArr[1] -> 바위
			//		gameArr[2] -> 보
		 */
		
		//키보드로부터 입력받기위해서 
		Scanner sc = new Scanner(System.in);
	
		
		String[] gameArr = {"가위", "바위", "보"};
		
		String name;
		int win=0, draw=0, loss=0;
		
		System.out.print("당신의 이름을 입력해주세요 : ");
		name = sc.next();
		
		
		while(true) {
			System.out.print("가위바위보 : ");
			String user = sc.next();
	
			if (user.equals("exit")) {
				System.out.printf("%d전 %d승 %d무 %d패", (win + draw + loss), win, draw, loss);
				break;
			}

			int rand = (int)(Math.random() * 3);
			String com = gameArr[rand];
			
			if (user.equals(com)) {
				System.out.println("비겼습니다.");
				draw++;
			} else if((user.equals("가위") && com.equals("보")) || 
					  (user.equals("바위") && com.equals("가위")) ||
					  (user.equals("보") && com.equals("바위"))
					) {
				System.out.println("이겼습니다.");
				win++;
			} else {
				System.out.println("졌습니다 ㅠㅠ");
				loss++;
			}
		}
		
	}

}
