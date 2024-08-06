package f.object.ex3;
import f.object.ex2.BankAccount;

public class Run {

	public static void main(String[] args) {
		//클래스명 참조변수명 = new 생성자();
//		Book b1 = new Book("불안을 이기는 심리학", "자기계발", "황양밍", 120); 
//		Book b2 = new Book("자바란 무엇일까?", "전공서적", "최지원", 350);  
//		Book b3 = new Book("당신을 소모시키는 모든 것을 차단하라", "자기계발", "푸수", 130);  
//		
//		System.out.println(b1.toString());
//		System.out.println(b2.toString());
//		System.out.println(b3.toString());
		
		
		Book b1 = new Book("불안을 심리학", "자기계발", "황양밍", 120); 
		b1.setTitle("불안을 이기는 심리학");
		
		System.out.println(b1.getTitle());
	}
	
	public static void check(Book tmp) {
		System.out.println("tmp");
		System.out.println(tmp.toString());
	}
	public static void check(int tmp) {
		tmp = 10;
		System.out.println("tmp : "  + tmp);
	}

}
