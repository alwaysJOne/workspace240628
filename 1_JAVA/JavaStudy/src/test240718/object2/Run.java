package test240718.object2;

public class Run {

	public static void main(String[] args) {
		// PhoneController객체 생성
		PhoneController phController = new PhoneController();
		
		// method() 호출 후 반환 값을 String 배열에 담고
		String[] results = phController.method();
		
		// 반복문을 이용하여 String배열의 각 인덱스 출력
		for(String res : results) {
			System.out.println(res);
			System.out.println();
		}

	}

}
