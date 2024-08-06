package l.io.ex2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ServeStream {
	/*
	 * 보조스트림 : 기반스트림만으로 부족했던 성능을 보다 향상시켜주는 스트림
	 * 			 기반스트림에서 제공하지 않는 추가적인 메소드 제공 / 데이터 전송 속도를 향상시켜준다.
	 * 		>> 외부매체와 직접적으로 연결되는 스트림이 아니다.(단독사용불가 -> 반드시 기반스트림과 함께사용)
	 */
	
	// 프로그램 -> 파일(출력)
	public void fileSave() {
		//FileWriter : 파일을 직접적으로 연결해서 2바이트 단위로 출력할 수 있는 기반스트림
		//BufferedWriter : 속도향상에 도움을 주는 보조스트림
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("l_buffer.txt"));){
			
//			//1. 기반스트림 생성
//			FileWriter fw = new FileWriter("l_buffer.txt");
//			
//			//2. 보조스트림 생성시 기반스트림 객체를 전달하면서 생성
//			BufferedWriter bw = new BufferedWriter(fw);
			
			
			bw.write("안녕하세요\n");
			bw.write("반갑습니다.");
			bw.newLine();
			bw.write("끝");
			bw.flush();
			
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//외부매체(파일) -> 프로그램
	public void fileRead() {
		//FileReader : 파일과 연결해서 2바이트 단위로 데이터를 입력받을 수 있는 객체
		//BufferedReader : 한줄씩 읽어오는 기능을 주는 보조스트림
		
		try (BufferedReader br = new BufferedReader(new FileReader("l_buffer.txt"));){
//			System.out.println(br.readLine());
//			System.out.println(br.readLine());
//			System.out.println(br.readLine());
//			System.out.println(br.readLine());
//			System.out.println(br.readLine());
//			System.out.println(br.readLine());
			
			String value = null;
			while((value = br.readLine()) != null) {
				System.out.println(value);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	//프로그램 -> 파일출력
	public void objectSave() {
		//출력할 데이터
		Product ph1 = new Product("아이폰1", 1000000);
		Product ph2 = new Product("아이폰2", 2000000);
		Product ph3 = new Product("아이폰3", 3000000);
		
		//FileOutputStream : 파일과 연결해서 1바이트 단위로 출력할 수 있는 기반스트림
		//ObjectOutputStream : 객체 단위로 출력할 수 있도록 도움을 주는 보조 스트림
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("product1.txt"));){
			oos.writeObject(ph1);
			oos.writeObject(ph2);
			oos.writeObject(ph3);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void objectRead() {
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("product1.txt"));){
			while(true) {
				System.out.println(ois.readObject());
			}
		} catch(EOFException e) {
			System.out.println("파일을 다 읽어드림");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
