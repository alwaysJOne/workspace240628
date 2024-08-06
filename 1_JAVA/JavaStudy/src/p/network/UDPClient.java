package p.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPClient {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("보낼메세지 : ");
		String msg = sc.nextLine();
		
		InetAddress inet;
		int port = 4000;
		
		try (DatagramSocket dsoc = new DatagramSocket();){
			inet = InetAddress.getByName("192.168.30.2");
		
			//전송할 데이터 생성 DatagramPacket(전송할 데이터의 byte배열, 전송할데이터의 길이, ip정보를 담은 inetaddress객체, 전송할 port)
			DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length, inet, port);
			dsoc.send(dp);
		
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
