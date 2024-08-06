package test240719.object2;

public class Company {

	public static void main(String[] args) {
		Employee[] employees = new Employee[2];
		employees[0] = new Secretary("Hilery", 1, "secretary", 800);
		employees[1] = new Sales("Clinten", 2, "sales", 1200);
		
		System.out.println("name\t department\t salary");
		System.out.println("--------------------------------");
		for(Employee e : employees) {
			System.out.println(e.getName() + "\t " + e.getDepartment() + "\t " + e.getSalary());
		}
		
		System.out.println("인센티브 100지급");
		((Secretary)employees[0]).incentive(100);
		((Sales)employees[1]).incentive(100);
		
		System.out.println("name\t department\t salary\t \tax");
		System.out.println("--------------------------------");
		for(Employee e : employees) {
			System.out.println(e.getName() + "\t " + e.getDepartment() + "\t " + e.getSalary() + "\t " + e.tax());
		}
	}

}
