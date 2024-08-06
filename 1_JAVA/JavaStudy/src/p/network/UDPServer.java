package p.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {

	public static void main(String[] args) {
		
		int port = 4000;
				
		//서버가 4000포트를 결합하여 요청을 받을 준비를 한다.
		try (DatagramSocket dsoc = new DatagramSocket(port)){
			
			//전송받은 데이터를 지정할 바이트배열
			byte[] data = new byte[60000];
			
			//클라이언트로부터 받을 peacket객체 생성
			DatagramPacket dp = new DatagramPacket(data, data.length);
			System.out.println("데이터 받을 준비 완료");
			
			while(true) {
				//데이터전송된 것 받아주기
				dsoc.receive(dp);
				
				//데이터확인
				System.out.println("클라이언트 ip : " + dp.getAddress());
				String message = new String(dp.getData(), "UTF-8");
				System.out.println("클라이언트가 보낸 내용 : " + message);
				
			}
			
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
