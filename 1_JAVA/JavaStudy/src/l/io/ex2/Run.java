package l.io.ex2;

public class Run {
	/*
	 	프로그램상의 데이터를 외부매체로 출력한다거나 또는 외부매체로부터 입력을 받아오려고한다.!
	 	이 때 반드시 외부매체와 연결되는 통로를 만들어줘야 한다 => 스트림
	 	
	 	*스트림의 특징
	 	*- 단방향 : 입력이면 입력 / 출력이면 출력만 가능
	 	*			=> 입력과 출력을 동시에 하고자 한다면 -> 입력스트림, 출력스트림을 따로 열어줘야한다.
	 	*- 선입선출(FIFO) : 통로가 파이프같은 개념이기 때문에 먼저 보낸값이 먼저 나온다.
	 	*- 시간지연(delay)가 발생할 수 있다.
	 	
	 	
	 	*스트림의 구분
	 	> 통로의 사이즈(1byte / 2byte)
	 	- 바이트스트림 : 1byte만 왔다갔다 할 수 있는 통로 -> 입력(InputStream), 출력(OutputStream)
	 	- 문자스트림 : 2byte가 왔다갔다 할 수 있는 통로 -> 입력(Reader), 출력(Writer)
	 	
	 	> 외부매체와 직접 연결유무
	 	- 기반스트림 : 외부매체와 직접적으로 연결되는 통로(필수)
	 	- 보조스트림 : 기반스트림을 보조하는 통로(속도를 빠르게 하거나, 유용한 기능을 제공하기위한 보조역할)
	 				=> 단독으로 사용불가! 반드시 기반스트림과 함께 사용할 수 있다.
	 */
	
	

	public static void main(String[] args) {
//		new ServeStream().fileSave();
//		new ServeStream().fileRead();
//		new ServeStream().objectSave();
		new ServeStream().objectRead();

	}

}
