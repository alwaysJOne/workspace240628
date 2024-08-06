package q.thread.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerReveive implements Runnable{
	private Socket socket;

	public ServerReveive(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
			//반복을 돌면서 버퍼에 새로운 메세지가 도착하면 받아서 출력
			while(true) {
				String message = br.readLine();
				System.out.println("클라이언트로부터 전달받은 메세지 : " + message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
