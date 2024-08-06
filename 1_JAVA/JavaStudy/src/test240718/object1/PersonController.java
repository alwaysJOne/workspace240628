package test240718.object1;

public class PersonController {
	Person[] p = new Person[20];
	
	//학생객체 수를 countArr[0]에
	//근로자객체 수를 countArr[1]에 넣어서 반환
	public int[] personCount() {
		int[] countArr = new int[2];
		
		int studentCount = 0, employeeCount = 0;
		for(Person per : p) {
			if(per == null) {
				break;
			} else if(per instanceof Student) {
				studentCount++;
			} else if(per instanceof Employee) {
				employeeCount++;	
			}
		}
		
		countArr[0] = studentCount;
		countArr[1] = employeeCount;
		
		return countArr;
	}

	public void insertPerson(Person per) {
		for(int i=0; i<p.length; i++) {
			if(p[i] == null) {
				p[i] = per;
				return;
			}
		}
	}
	
	public Person[] printPerson() {
		return this.p;
	}
}

