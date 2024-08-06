package test240718.object1;

import java.util.Scanner;

public class PersonMenu {
	Scanner sc = new Scanner(System.in);
	PersonController pc = new PersonController();

	public void mainMenu() {
		
		while(true) {
			int[] countArr = pc.personCount();
			
			System.out.println("학생은 최대 3명까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 학생은 "+countArr[0]+"명입니다.");
			System.out.println("사원은 최대 10명까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 사원은 "+countArr[1]+"명입니다.\n");
		
			System.out.println("1. 학생 메뉴");
			System.out.println("2. 사원 메뉴");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				this.studentMenu();
				break;
			case 2:
				this.employeeMenu();
				break;
			case 9:
				System.out.println("종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	public void studentMenu() {
		while(true) {
			System.out.println();
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 보기");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				this.insertStudent();
				break;
			case 2:
				this.printStudent();
				break;
			case 9:
				System.out.println("메인으로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
		
	
	}

	public void employeeMenu() {
		System.out.println("employeeMenu");
	}

	public void insertStudent() {
		String name, major;
		int age, grade;
		double height, weight;
		
		while(true) {
			System.out.print("학생 이름 : ");
			name = sc.next();
			
			System.out.print("학생 나이 : ");
			age = sc.nextInt();
			
			System.out.print("학생 키 : ");
			height = sc.nextDouble();
			
			System.out.print("학생 몸무게 : ");
			weight = sc.nextDouble();
			
			System.out.print("학생 학년 : ");
			grade = sc.nextInt();
			
			System.out.print("학생 전공 : ");
			major = sc.next();
			
			int[] personCount = pc.personCount();
			if(personCount[0] == 3) {
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가를 종료하고 학생 메뉴로 돌아갑니다.");
				return;
			}
			
			pc.insertPerson(new Student(name, age, height, weight, grade, major));
			
			System.out.print("그만하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
			char ch = sc.next().charAt(0);
			if (ch == 'n' || ch == 'N') {
				return;
			}
		}
	}

	public void printStudent() {
		Person[] pArr = pc.printPerson();
		for(Person p : pArr) {
			if(p == null) {
				break;
			}
			
			if(p instanceof Student)
				System.out.println(p.toString());
		}
	}

	public void insertEmployee() {
		String name, dept;
		int age, salary;
		double height, weight;
		
		while(true) {
			System.out.print("직원 이름 : ");
			name = sc.next();
			
			System.out.print("직원 나이 : ");
			age = sc.nextInt();
			
			System.out.print("직원 키 : ");
			height = sc.nextDouble();
			
			System.out.print("직원 몸무게 : ");
			weight = sc.nextDouble();
			
			System.out.print("직원 월급 : ");
			salary = sc.nextInt();
			
			System.out.print("직원 부서 : ");
			dept = sc.next();
			
			int[] personCount = pc.personCount();
			if(personCount[1] == 3) {
				System.out.println("직원을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가를 종료하고 학생 메뉴로 돌아갑니다.");
				return;
			}
			
			pc.insertPerson(new Employee(name, age, height, weight, salary, dept));
			
			System.out.print("그만하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
			char ch = sc.next().charAt(0);
			if (ch == 'n' || ch == 'N') {
				return;
			}
		}
	}

	public void printEmployee() {
		Person[] pArr = pc.printPerson();
		for(Person p : pArr) {
			if(p == null) {
				break;
			}
			
			if(p instanceof Employee)
				System.out.println(p.toString());
		}
	}
}
