package test240708;

public class T_10 {

	public static void main(String[] args) {
		/*
		 2차원 배열에 들어있는 데이터들 중 3의 배수만 골라내서 새로운 1차원배열에 기록하고 출력한다. 
		 단 중복 값은 하나만 기록되게 한다.
		 
		 int [][] array = {{12, 41, 36, 56}, {82, 10, 12, 61}, {14, 16, 18, 78}, {45, 26, 72, 23}}; 
		int[] copyAr = new int[array의 행갯수 * 열갯수];
		 */

		int [][] array = {
				{12, 41, 36, 56}, 
				{82, 10, 12, 61}, 
				{14, 16, 18, 78}, 
				{45, 26, 72, 23}
				};
		int size = 0;
		
		for(int i=0; i<array.length; i++) {
			size += array[i].length;
		}
		
		int[] copyAr = new int[size];
		int copyIndex = 0;
		
		// 2차원배열 array을 전체 검사
		for(int i=0; i < array.length; i++) {
			for(int j=0; j < array[i].length; j++) {
				
				// 2차원배열의 i,j의 요소가 3의 배수인지 확인
				if(array[i][j] % 3 == 0) { 
					
					// i,j의 요소가 이미 copyAr들어있는 요소인지 확인
					boolean isCountinue = false;
					for(int k=0; k<copyIndex; k++) {
						if(copyAr[k] == array[i][j]) {
							isCountinue = true;
							break;
						}
					}
					
					//isCountinue -> true일 때는 반복값이 존재;
					//!isCountinue -> 반복값이 존재하지 않는다면 copyAr -> array[i][j]대입
					if (!isCountinue) {
						copyAr[copyIndex++] = array[i][j];	
					}
				}
			}
		}
		
		// copyAr출력
		System.out.print("copyAr : ");
		for(int i=0; i<copyIndex; i++) {
			System.out.print(copyAr[i] + " ");
		}
	}

}
