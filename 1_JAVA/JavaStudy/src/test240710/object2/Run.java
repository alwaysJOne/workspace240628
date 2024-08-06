package test240710.object2;

public class Run {

	public static void main(String[] args) {
//		Product p1 = new Product("조던1", 500000, "나이키");
//		p1.information();
		
//		Student st = new Student(1, 3, "최지원", 190, '여');
//		st.information();

		Book b1 = new Book();
		Book b2 = new Book("홍길동전", "길벗", "허균");
		Book b3 = new Book("자바란무엇인가?", "kh", "최지원", 100000, 0.2);
		
		b1.inform();
		System.out.println();
		b2.inform();
		System.out.println();
		b3.inform();
	}

}
