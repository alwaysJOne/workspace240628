package i.polymorphism.ex2;

public class Avante extends Car{

	public Avante(String color, String fuel, int year) {
		super(color, fuel, year);
	}

	public void drive() {
		System.out.println("슝~ 슝~");
	}
	
	public void moveAvante() {
		System.out.println("아반떼 이동");
	}
}
