package test240716.object1;

import java.util.Scanner;

//사용자로부터 입력을 받거나 결과를 보여주는 class
public class PointMenu {
	private Scanner sc = new Scanner(System.in);
	private CircleController cc = new CircleController();
	private RectangleController rc = new RectangleController();

	public void mainMenu() {
		while(true) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 원");
			System.out.println("2. 사각형");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int num = sc.nextInt();
			
			switch(num) {
			case 1:
				this.circleMenu();
				break;
			case 2:
				this.rectangleMenu();
				break;
			case 9:
				System.out.println("종료합니다.");
				return;
			default:
				System.out.println("잘못입력하셨습니다.");
			}
		}
	};

	public void circleMenu() {
			System.out.println("===== 원 메뉴 =====");
			System.out.println("1. 원 둘레");
			System.out.println("2. 원 넓이");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			int num = sc.nextInt();
			
			switch(num) {
			case 1:
				this.calcCircum();
				break;
			case 2:
				this.calcCircleArea();
				break;
			}
	};

	public void rectangleMenu() {
		System.out.println("===== 메뉴 =====");
		System.out.println("1. 사각형 둘레");
		System.out.println("2. 사각형 넓이");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
		int num = sc.nextInt();
		
		switch(num) {
		case 1:
			this.calcPerimeter();
			break;
		case 2:
			this.calcRectArea();
			break;
		}
	};

	public void calcCircum() {
		int x, y, radius;
		
		System.out.print("x 좌표 : ");
		x = sc.nextInt();
		
		System.out.print("y 좌표 : ");
		y = sc.nextInt();
		
		System.out.print("반지름 : ");
		radius = sc.nextInt();
	
		String result = cc.calcCircum(x, y, radius);
		System.out.println(result);
	};

	public void calcCircleArea() {
		int x, y, radius;
		
		System.out.print("x 좌표 : ");
		x = sc.nextInt();
		
		System.out.print("y 좌표 : ");
		y = sc.nextInt();
		
		System.out.print("반지름 : ");
		radius = sc.nextInt();
		
		String result = cc.calcArea(x, y, radius);
		System.out.println(result);
	};

	public void calcPerimeter() {
		int x, y, width, height;
		
		System.out.print("x 좌표 : ");
		x = sc.nextInt();
		
		System.out.print("y 좌표 : ");
		y = sc.nextInt();
		
		System.out.print("높이 : ");
		height = sc.nextInt();
		
		System.out.print("너비 : ");
		width = sc.nextInt();
		
		String result = rc.calcPerimeter(x, y, height, width);
		System.out.println(result);
	};

	public void calcRectArea() {
		int x, y, width, height;
		
		System.out.print("x 좌표 : ");
		x = sc.nextInt();
		
		System.out.print("y 좌표 : ");
		y = sc.nextInt();
		
		System.out.print("높이 : ");
		height = sc.nextInt();
		
		System.out.print("너비 : ");
		width = sc.nextInt();
		
		String result = rc.calcArea(x, y, height, width);
		System.out.println(result);
	};
}
