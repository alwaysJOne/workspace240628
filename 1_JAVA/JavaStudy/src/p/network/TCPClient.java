package p.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BufferedReader br = null;
		PrintWriter pw = null;

		//요청하고자하는 서버 IP : 192.168.30.2
		//포트번호 : 3000
		
		int port = 3000;
		String serverIP = "192.168.30.2";
		
		Socket socket = null;
		
		try {
			//1) 서버로 연결 요청을 보내는 구문(연결을 요청하고자하는 서버의 ip와 지정된 포트를 전달)
			socket = new Socket(serverIP, port);
			//만약 통신에 실패했다면 null값이 socket객체에 담김
			
			if(socket != null) { //서버와 잘 연결된 경우
				System.out.println("서버와 연결 성공");
				
				//2)서버와 입출력기반 스트림 생성
				//3) 보조스트림을 활용해서 성능 개선
				
				
				//입력용 스트림
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
				//출력용 스트림
				pw = new PrintWriter(socket.getOutputStream());
				
				while(true) {
					System.out.print("서버에게 보낼 내용 : ");
					String sendMessage = sc.nextLine();
					pw.println(sendMessage); //입력받은 내용 스트림에 담기
					pw.flush();//스트림에 담겨있는 내용을 강제로 보냄
					
					String message = br.readLine();
					System.out.println("서버로부터 전달받은 메세지 : " + message);
				}
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				pw.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
