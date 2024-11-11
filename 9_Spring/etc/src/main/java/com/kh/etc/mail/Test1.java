package com.kh.etc.mail;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

//직접 도구를 생성해서 이메일을 전송해보자

/*
 * Email Protocol
 * SMTP
 * 이메일을 전송할 때 사용하는 프로토콜
 * 
 * POP
 * 이메일 서버에 도착한 메일을 클라이언트로 가져올 때 사용하는 프로토콜
 * 
 * IMAP
 * 이메일 서버에 직접 접속해서 이메일을 확인할 때 사용하는 프로토콜
 */
public class Test1 {
	public static void main(String[] args) {
		//MIME 형식의 이메일을 보내기 위해서는 JavaMailSender인터페이스를 사용한다.
		
		//계정설정
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost("smtp.gmail.com");
		sender.setPort(587);
		sender.setUsername("wldnjsv1003@gmail.com");
		sender.setPassword("jxur mdkj uxub ecwv");
		
		//옵션설정
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", true);
		
		sender.setJavaMailProperties(prop);
		
		//메세지 생성
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("이메일 전송 테스트");
		message.setText("이메일 테스트 전송입니다.");
		
		String[] to = {"wldnjsv1003@gmail.com"};
		message.setTo(to);
		
		String[] cc = {"wldnjsv1003@gmail.com"};
		message.setCc(cc);
		
		sender.send(message);
	}
}




