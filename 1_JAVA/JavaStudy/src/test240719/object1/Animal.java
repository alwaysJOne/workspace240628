package test240719.object1;

public abstract class Animal {
	private String name;
	private String kinds;
	
	protected Animal() {
		
	}

	protected Animal(String name, String kinds) {
		super();
		this.name = name;
		this.kinds = kinds;
	}

	@Override
	public String toString() {
		return "저의 이름은" + name + "이고, 종류는 " + kinds + "입니다.";
	}
	
	public abstract void speak();
}
