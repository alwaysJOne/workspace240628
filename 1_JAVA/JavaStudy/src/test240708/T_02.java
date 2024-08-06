package test240708;

public class T_02 {

	public static void main(String[] args) {
		/*
		 2단에서 5단까지의 구구단의 결과 중 홀수인 것만 출력한다. 단, for문을 이용한다. 
		 */
		for(int j=2; j < 6; j++) {
			for(int i=1; i<10; i++) {
				if ((j * i) % 2 == 1) {
					System.out.println(j + " * " + i + " = " + (j * i));
				}
			}
		}
	}

}
