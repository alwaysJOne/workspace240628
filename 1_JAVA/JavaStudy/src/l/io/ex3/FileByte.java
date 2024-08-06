package l.io.ex3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileByte {
	/*
	 * "바이트 스트림"을 통한 입출력해보기
	 * 
	 * -바이트스트림 : 데이터를 1바이트 단위로 전송하는 통로(좁은통로 -> 한글깨짐)
	 * -기반스트림 : 외부매체와 직접적으로 연결하는 통로
	 * 
	 * xxxInputStream : xxx매체로부터 데이터를 입력받는 통로(외부로부터 데이터를 읽어오겠다.)
	 * xxxOutputStream : xxx매체로부터 데이터를 출력하는 통로(외부매체로 데이터를 내보내겠다.)
	 */
	
	//프로그램(자바) -> 외부매체(파일) 데이터를 출력(프로그램상의 데이터를 파일로 내보내보자)
	public void fileSave() {
	
		//1. FileOutputStream 객체 생성
		//해당파일이 없으면 새로만들어주고 통로연결 / 있으면 해당 파일에 통로연결 
		//FileOutputStream의 두번째 매개변수에 true를 전달하면 해당 파일이 존재할 경우 기존데이터에 이어서 작성을 한다.
	
		try (FileOutputStream fout = new FileOutputStream("byte_test.txt", true);){
			
			//2. 파일에 데이터 출력
			//   숫자를 출력하는 문자를 출력하면 실제로는 파일에 문자로 기록이 된다
			//   (0~127)
			fout.write('a');
			fout.write('9');
			fout.write('아'); //한글은 2byte여서 깨져서 저장됨
			
			byte[] arr = {102,103,104};
			fout.write(arr);
			fout.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace(); 
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
		
		//finally {
		//		try {
		//			fout.close();
		//		} catch (IOException e) {
		//			e.printStackTrace();
		//		}
		//	}
	}
	
	public void fileRead() {
		
		//1.스트림생성
		//2.스트림을 통해서 입력받음
		//3.사용이끝난 스트림 반납
		
		FileInputStream fin = null;
		
		try {
			//1.스트림생성
			fin = new FileInputStream("byte_test.txt");
			
			//2.파일로부터 데이터를 읽어들이고자 할때 read메소드 사용
			// 1byte씩 읽어옴 / 숫자로 읽어들임
			
//			System.out.println(fin.read());
//			System.out.println(fin.read());
//			System.out.println(fin.read());
//			System.out.println(fin.read());
//			System.out.println(fin.read());
//			System.out.println(fin.read());
//			System.out.println(fin.read());
//			System.out.println(fin.read());
//			System.out.println(fin.read());  //파일의 끝을 만나느 순간 -1을 반환한다.
			
			while(true) {
				int value = fin.read();
				if(value == -1) {
					break;
				}
				System.out.print((char)value);
			}
			
			int value = 0;
			while((value = fin.read()) != -1) {
				System.out.print((char)value);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { //이 안에 작성한 코드는 어떤 예외가 있더라도 마지막에 무조건 실행하고 빠져나가도록한다.
			try {
				//3.사용이끝난 스트림 반납
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
