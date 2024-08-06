package h.inherit.ex1;

public class Man {
	private String name;

	public Man() {
		super();
		System.out.println("Man 기본생성자 호출");
	}

	public Man(String name) {
		super();
		this.name = name;
		System.out.println("Man Name을 초기화하는 생성자 호출");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void tellYourName() {
		System.out.println("My name is " + this.name);
	}
}
