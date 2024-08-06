package h.inherit.ex1;

public class Run {

	public static void main(String[] args) {
//		Man man1 = new Man("최지원");
//		man1.tellYourName();
		
		BusinessMan man2 = new BusinessMan("최지원","KH", "강사");
		System.out.println(man2.toString());
	}

}
