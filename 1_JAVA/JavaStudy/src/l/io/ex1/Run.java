package l.io.ex1;

import java.io.File;
import java.io.IOException;

public class Run {

	/*
	 * 간단하게 파일을 만들어보자
	 * java.io.File클래스를 가지고
	 */
	public static void main(String[] args) {

		//1. 경로지정을 딱히 하지않고 파일 생성하기
		File f1 = new File("test.txt"); // 파일객체를 하나 만든상태(실제파일x)
		//2. 존재하는 폴더에 파일 생성
		File f2 = new File("D:\\test2.txt");
		//3. 존재하지 않는 경로에 파일 생성
//		File f3 = new File("D:\\tmp\\test.txt");
		
		try {
			
			f1.createNewFile(); // createNewFile메소드가 실행할 때 실제 파일이 만들어짐
			f2.createNewFile();
//			f3.createNewFile(); // 존재하지 않는 경로로 생성시 예외발생 -> IOException
			
			//3. 폴더먼저 만들고 파일만들어지게 하는 방법
			File tmpFolder = new File("D:\\tmp");
			tmpFolder.mkdir();
			
			File f3 = new File("D:\\tmp\\test.txt");
			f3.createNewFile();
			
			File f4 = new File("ttt.txt");
			
			//파일의 존재유무를 코드로 확인할 수 있다.
			System.out.println(f4.exists());
			System.out.println(f1.exists());
			
			//파일인지 확인하는 메소드
			System.out.println(f1.isFile()); 
			System.out.println(tmpFolder.isFile());
			
			//------------------------------------------------
			File folder = new File("parent");
			folder.mkdir();
			
			File file = new File("parent\\person.txt");
			file.createNewFile();
			
			System.out.println("파일명 : " + file.getName());
			System.out.println("파일경로 : " + file.getAbsolutePath());
			System.out.println("파일용량 : " + file.length());
			System.out.println("파일상위폴더 : " + file.getParent());
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
