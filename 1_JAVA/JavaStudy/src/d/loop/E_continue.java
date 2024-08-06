package d.loop;

public class E_continue {
	/*
	 * continue: 반복문 안에 기술되는 구문
	 *     		 continue;코드를 실행시 그 뒤의 코드를 실행하지 않고 곧바로 다시 반복문의 상단으로 이동
	 */
	
	public static void main(String[] args) {
		// 1부터 10까지 홀수 출력
		
		/*
		for(int i=1; i <= 10; i++) {
			if(i % 2 == 1) {
				System.out.println(i + " ");
			}
		}
		
		for(int i=1; i <= 10; i++) {
			if(i % 2 == 0) { //만약 i가 짝수라면
				continue; // 반복문의 나머지를 실행하지않고 즉시 다음 반복을 진행
			}
			
			System.out.println(i + " ");
		}
		*/
		
		//1부터 100까지의 총 합계
		// 단, 6의 배수값은 빼고
		
		
		int sum = 0;
		
		for(int i=1; i <= 100; i++) {
			if(i % 6 == 0) {
				continue;
			}
			sum += i; 
		}
		
		int i = 0;
		while(true) {
			if(i < 10) {
				i++;
				continue;
			}
			
			break;
		}
		
		
		
		
		
		
		
		
	}
}
