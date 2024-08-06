package test.t240704;

public class T_05 {

	public static void main(String[] args) {
		/*
		 	길이가 10인 배열을 선언하고 1부터 10까지의 값을 반복문을 이용하여 
			순서대로 배열 인덱스에 넣은 후 그 값을 출력하세요.
			
			ex.
			1 2 3 4 5 6 7 8 9 10 
		 */
		
		int[] arr = new int[10];
		
		for(int i=0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		
		for(int i=0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		/*
		 	길이가 10인 배열을 선언하고 1부터 10까지의 값을 반복문을 이용하여 
			역순으로 배열 인덱스에 넣은 후 그 값을 출력하세요.
			
			ex.
			10 9 8 7 6 5 4 3 2 1 
		 */
		
		int[] arr2 = new int[10];
		
		for(int i=0; i < arr.length; i++) {
			arr[i] = arr.length - i; // 0 ~ 9 -> 10 1
		}
		
		for(int i=0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
