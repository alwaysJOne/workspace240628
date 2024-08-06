package test240716.object2;

public class StudentTest {

	public static void main(String[] args) {
		Student[] students = new Student[3];
		students[0] = new Student("홍길순", 25, 171, 81, "201401", "영어영문학");
		students[1] = new Student("한사랑", 23, 183, 72, "201402", "건축학");
		students[2] = new Student("임꺽정", 26, 175, 65, "201403", "체육학");
		
		for(int i=0; i< students.length; i++) {
			System.out.println(students[i].toString());
		}
	}

}
