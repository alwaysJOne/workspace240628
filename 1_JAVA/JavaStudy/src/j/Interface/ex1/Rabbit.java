package j.Interface.ex1;

public class Rabbit implements Animal, Baby{

	@Override
	public void move() {
		
	}

	@Override
	public void eat() {
		System.out.println("냠냠 먹습니다");
	}

	@Override
	public void makeSound() {
		System.out.println("음메~");
	}
	
}
