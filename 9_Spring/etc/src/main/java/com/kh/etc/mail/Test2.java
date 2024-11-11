package com.kh.etc.mail;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
public class Test2 {

	private final JavaMailSender sender;
	
	@Autowired
	public Test2(JavaMailSender sender) {
		this.sender = sender;
	}
	
	@GetMapping("send")
	public String mail() {
		//메세지 생성
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("이메일 전송 테스트2");
		message.setText("이메일 테스트 전송입니다.");
		
		String[] to = {"wldnjsv1003@gmail.com"};
		message.setTo(to);
		
		String[] cc = {"wldnjsv1003@gmail.com"};
		message.setCc(cc);
		
		sender.send(message);
		
		return "redirect:/";
	}
	
	@GetMapping("hypermail")
	public String hypermail() throws MessagingException {
		//메세지 생성
		MimeMessage message = sender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
				
		String[] to = {"wldnjsv1003@gmail.com"};
		helper.setTo(to);
		
		String[] cc = {"wldnjsv1003@gmail.com"};
		helper.setCc(cc);
				
		helper.setSubject("이메일 전송 테스트2");
		
		//이메일찾기시에 이메일정보를 입력받아
		//uuid(겹치지않는 코유한 코드), 이메일, 시간을 데이터베이스에 기록
		//jj131315212/wldnjsv1003@gmail.com / 2024/11/11 12:44
		
		String url = ServletUriComponentsBuilder
				.fromCurrentContextPath()
				.port(7777).path("/changePassword")
				.queryParam("user_id", "wldnjsv1003")
				.queryParam("uuid", "jj131315212")
				.toUriString();
		
		//두번째 인자를 true로 보내면 html을 사용하겠다는 의미이다.
		helper.setText("이메일 변경 링크 <br> <a href='"+url+"'>사이트로 이동</a>", true);
		
		sender.send(message);
		
		return "redirect:/";
	}
	
	@GetMapping("snedfile")
	public String sendFile() throws MessagingException {
		//메세지 생성
		MimeMessage message = sender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
				
		String[] to = {"wldnjsv1003@gmail.com"};
		helper.setTo(to);
		
		String[] cc = {"wldnjsv1003@gmail.com"};
		helper.setCc(cc);
				
		helper.setSubject("파일전송 테스트");
		helper.setText("파일전송 테스트입니다.");
		
		//첨부파일 추가
		DataSource source = new FileDataSource("C:\\Users\\user1\\Desktop\\sample.jfif");
		helper.addAttachment(source.getName(), source);
		
		sender.send(message);
		return "redirect:/";
	}
	
	
}
