package j.Interface.ex1;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//인터페이스를 상속받은 클래스는 그냥 클래스이다.
		Dog d1 = new Dog();
		d1.eat();
		d1.makeSound();
		
		//인터페이스에서도 다형성은 성립된다.
		//부모의 참조변수로 자식객체를 담을 수 있다.
		Animal[] ani = new Animal[5];
		
		for(int i=0; i<ani.length; i++) {
			System.out.println("추가할 동문을 선택해주세요.");
			System.out.print("1. 강아지 2. 고양이 3. 토끼 : ");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				ani[i] = new Dog();
				break;
			case 2:
				ani[i] = new Cat();
				break;
			case 3:
				ani[i] = new Rabbit();
			}
		}
		
		for(int i=0; i<ani.length; i++) {
			if(ani[i] instanceof Baby) {
				System.out.println("토끼는 아기라 못움직여요");
			} else {
				ani[i].move();
			}
		}

	}

}
