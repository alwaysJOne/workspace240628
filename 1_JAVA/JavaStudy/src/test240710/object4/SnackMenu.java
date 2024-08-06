package test240710.object4;

import java.util.Scanner;

public class SnackMenu {
	private Scanner sc = new Scanner(System.in);
	private SnackController scr = new SnackController();
	
	public void menu() {
		String kind;
		String name;
		String flavor;
		int numOf;
		int price;
		
		System.out.println("스낵류를 입력하세요.");
		
		System.out.print("종류 : ");
		kind = sc.next();
		
		System.out.print("이름 : ");
		name = sc.next();
		
		System.out.print("맛 : ");
		flavor = sc.next();
		
		System.out.print("개수 : ");
		numOf = sc.nextInt();
		
		System.out.print("가격 : ");
		price = sc.nextInt();
		
		//데이터를 setter를 이용해 저장하고 저장완료 되었다는 결과를 반환하는 메소드
		String res = scr.saveData(kind, name, flavor, numOf, price);
		System.out.println(res);
		
		System.out.print("저장한 정보를 확인하시겠습니까?(y/n) :");
		char ch = sc.next().charAt(0);
		if (ch == 'y') {
			// 저장된 데이터를 반환하는 메소드
			res = scr.confirmData();
			System.out.println(res);
		}
	}
}
