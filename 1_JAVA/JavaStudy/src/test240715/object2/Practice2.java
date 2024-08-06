package test240715.object2;

public class Practice2 {

	public static void main(String[] args) {
		//주어짂 String 데이터를 “,”로 나누어 5개의 실수 데이터들을 꺼내어 합과 평균을 구핚다. 
		//단, String 문자열의 모든 실수 데이터를 배열로 만들어 계산핚다.

		//문자열.split(구분자)
		//문자열은 구분자로 나눠서 배열로 반환하는 메소드
		
		//배열에 들어있는 모든 요소를 가져와서 사용하는 경우가 매우많다.
		//for(자료형 변수명 : 배열) {
		//		변수명 -> 배열에 있는 모든 요소가 한번씩 들어와서 반복
		//}
		
		String str = "1.22,4.12,5.93,8.71,9.34";
		String[] sArr = str.split(",");
		
		//실수데이터를 저장할 배열
		double[] dArr = new double[sArr.length];
		for(int i=0; i<sArr.length; i++) {
			dArr[i] = Double.parseDouble(sArr[i]);
		}
		
		double sum = 0;
//		for(int i=0; i<dArr.length; i++) {
//			double d = dArr[i];
//			sum += d;
//		}
		
		for(double d : dArr) {
			sum += d;
		}
		
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + (sum/dArr.length));
	}

}
