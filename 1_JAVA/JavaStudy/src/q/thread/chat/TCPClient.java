package q.thread.chat;

import java.io.IOException;
import java.net.Socket;

public class TCPClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 3000);
			
			//서버로부터 메세지를 받는 쓰레드
			ClientReceive task1 = new ClientReceive(socket);
			task1.start();
			
			//서버에 메세지를 보내는 쓰레드
			ClientSend task2 = new ClientSend(socket);
			task2.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
