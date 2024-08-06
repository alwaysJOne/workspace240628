package h.inherit.ex2;

public class Desktop extends Product{
	private boolean allinOne; // 일체형 여부

	public Desktop() {
		super();
		System.out.println("Desktop()");
	}

	//super 부모객체의 정보에 접근할 수 있는 키워드
	public Desktop(String brand, String pCode, String pName, int price, boolean allinOne) {
		super(brand, pCode, pName, price);
		this.allinOne = allinOne;
	}
	
	//오버라이딩
	//-> 부모클래스에 있는 메소드를 자식 클래스에서 내용만 재정의 하는 것
	@Override
	public String information(){
		return super.information() + " 올인원:" + this.allinOne; 
	}
}
