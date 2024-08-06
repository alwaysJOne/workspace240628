package test240708;

public class T_03 {

	public static void main(String[] args) {
		/*
		  1부터 100까지의 모든 정수들의 합과 평균을 구하는 프로그램을 작성한다. 
		  단, while문이나 do while문을 이용하여 작성한다.
		 */
		int sum = 0;
//		for(int i = 1; i < 101; i++) {
//			sum += i; 
//		}
		
		int i = 1;
		while(i < 101) {
			sum += i; 
			i++;
		}
		
		 System.out.println("합계 : " + sum);
		 System.out.println("평균 : " + (sum / 100.0));

	}

}
