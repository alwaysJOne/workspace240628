package f.object.ex4;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		/*
			// choi객체 생성 최지원, 15살, 영어 : 60, 수학 : 70, 국어: 80
			// kim객체 생성 김도한, 18살, 영어 : 95, 수학 : 50, 국어: 70
			Student choi = new Student("최지원", 15, 70, 60, 80);
			Student kim = new Student("김도한", 18, 50, 95, 70);
			
			//choi의 모든 과목의 평균을 출력
			System.out.println(choi.getName() + "님의 평균 : " + choi.getEvg());
			//kim의 모든 과목의 평균을 출력
			System.out.println(kim.getName() + "님의 평균 : " + kim.getEvg());
		*/
		
		//사용자로부터 이름, 나이, 영어점수, 수학점수, 국어점수를 입력받아
		//평균을 구하고 출력하는 프로그램 작성
		// ex) 이름 : 최지원
		//	   나이 : 15
		//	   영어점수 : 80
		//	   수학점수 : 100
		//	   국어점수 : 75
		// 최지원님의 평균 : 85
		
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		System.out.print("영어점수 : ");
		int enScore = sc.nextInt();
		
		System.out.print("수학점수 : ");
		int mathScore = sc.nextInt();
		
		System.out.print("국어점수 : ");
		int koScore = sc.nextInt();
		
		Student choi = new Student(name, age, mathScore, enScore, koScore);
		choi.printEvg();
	}

}
