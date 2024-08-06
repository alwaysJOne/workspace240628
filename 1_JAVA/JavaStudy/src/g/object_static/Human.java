package g.object_static;

public class Human {
	String name;
	int age;
	static int count = 0;
	
	public Human(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		
		this.count++;
	}
	
	public Human() {
		super();
		this.count++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void inform() {
		System.out.println("이름 : " + this.name);
		System.out.println("나이 : " + this.age);
		System.out.println("고객번호 : " + this.count);
	}
}
