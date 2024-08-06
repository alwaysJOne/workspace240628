package e.array;

public class A_Array2 {
	public static void main(String[] args) {
//		int i = 10;
//		int[] iArr = new int[5];
//		System.out.println(iArr.hashCode());
//		
//		double[] dArr = new double[3];
//		System.out.println(dArr.hashCode());
		
		/*
		 * 실제 리터럴값을 곧바로 담을 수 있는 변수를 일반변수라고 한다.
		 * 주소값을 담고 있는 변수는 참조 변수(레퍼런스 변수)라고 표현
		 * 
		 * 기본자료형(원시타입) : boolean, int, char, byte, long, double등등으로 선언된 변수
		 * => 실제 리터럴값을 바로 담을 수 있다.
		 * 
		 * 그외 자료형(String, Scanner, int[], double[], char[]...) -> 참조변수
		 */
		
		int[] iArr = new int[10]; // 0~9번 인덱스 사용가능, 0으로 초기화되어있음
		for(int i=0; i < iArr.length; i++) {
			System.out.println(iArr[i]);
		}
		
		double[] dArr = new double[4]; // 0~3번 인덱스 사용가능, 0으로 초기화되어있음
		for(int i=0; i < dArr.length; i++) {
			System.out.println(dArr[i]);
		}
		
		//내가 각 인덱스의 초기화를 하지 않아도 값들이 담겨있다.
		// Heap이라는 메모리공간은 절대 빈공간을 허용하지 않는다.
		// => 공간이 만들어질 때 JVM이 기본값으로라도 초기화를 진행한다.
		
		System.out.println(iArr); //배열의 자료형 + @ + 주소값의 16진수형태
		System.out.println(iArr.hashCode()); // 주소값의 10진수 형태
		
		int[] arr = null; // 아무것도 참조하고있지 않음
		System.out.println(arr);
		
		/*
		 * null을 가지고 있는 참조변수에 접근하여 다른 정보를 구하고자 하면 어떻게 될까?
		 * 항상 오류가 발생한다.
		 * 
		 * System.out.println(arr.hashCode());
		 */
		
		arr = new int[5];
		/*
		 * ArrayIndexOutOfBoundsException
		 * : 배열에 부적절한 인덱스 제시하면 발생하는 에러
		 * System.out.println(arr[5]);
		 */
		
		//배열의 가장 큰 단점
		// - 한번 지정된 배열의 크기는 변경이 불가하다.
		// => 배열의 크기를 변경하고자한다면 다시 만들어야한다.
		System.out.println(arr.hashCode());
		arr = new int[7];
		System.out.println(arr.hashCode());
		//주소값이 변경되었다 -> 새로운 곳을 참조하고 있다.
		
		/*
		 * 연결이 끊어진 기존 배열은 Heap영역에 둥둥 떠다닌다(어떤 변수에도 참조되지 않는 상태, 불러올 수 없는 메모리)
		 * => 일정시간이 지나면 "가비지컬렉터(GC)"가 알아서 지워줌
		 * => 자바에서의 "자동메모리관리" 특징 => 개발자가 코드에만 집중할 수 있다. 
		 */
		
		arr = null;
		// 배열을 강제로 삭제시키고자 한다면 => 연결고리를 끊어주면 된다.(null 대입)
	
		int[] arr2 = {1,1,1,1,1};
		int[] arr3 = {1,1,1,1,1};
		System.out.println(arr2 == arr3); // false => 각 참조변수는 ==을 통해서 비교시 주소값을 비교하기 때문에
		
		arr3 = arr2;
		System.out.println(arr2 == arr3);
	
		arr3[0] = 100;
		System.out.println(arr2[0]);
	
	}
}
