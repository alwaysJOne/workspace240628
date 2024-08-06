package test240711.object4;

public class StudentMenu {
	private StudentController ssm = new StudentController();

	public StudentMenu() {
		System.out.println("========== 학생 정보 출력 ==========");
		Student[] stArr = ssm.printStudent();
		for(int i=0; i<stArr.length; i++) {
			String stInfo = stArr[i].inform();
			System.out.println(stInfo);
		}
		
		System.out.println("========== 학생 성적 출력 ==========");
		double[] avgArr = ssm.avgScore();
		System.out.println("학생 점수 합계 : " + avgArr[0]);
		System.out.println("학생 점수 평균 : " + avgArr[1]);
		
		System.out.println("========== 성적 결과 출력 ==========");
		for(int i=0; i < stArr.length; i++) {
			if(ssm.CUT_LINE > stArr[i].getScore()) {
				System.out.println(stArr[i].getName() + "학생은 재시험 대상입니다.");
			} else {
				System.out.println(stArr[i].getName() + "학생은 통과입니다.");
			}
		}

	}
	
}
