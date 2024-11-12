package com.kh.etc.chat;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ChatServer extends TextWebSocketHandler{
	
	private final Map<String, WebSocketSession> userSessions = new ConcurrentHashMap<>();

	//클라이언트가 연결을 맺을 때 호출이되는 메소드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String nick = (String)session.getAttributes().get("nick");
		log.info("{} 연결됨...", nick);
		
		userSessions.put(nick, session);
	}

	//클라이언트로부터 메세지를 받을 때 호출되는 메소드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//세션에 저장되어있는 발송자 닉네임 가져오기
		String nick = (String)session.getAttributes().get("nick");
		
		//메세지 payload를 json객체로 파싱
		JsonObject obj = new JsonParser().parse(message.getPayload()).getAsJsonObject();
		
		log.info("message : {}", obj.get("message").getAsString());
		log.info("target : {}", obj.get("target").getAsString());
		
		MsgVo vo = new MsgVo();
		vo.setMsg(obj.get("message").getAsString()); // 메세지
		vo.setNick(nick); //발신자
		vo.setTargetNick(obj.get("target").getAsString()); //수신자
		vo.setTime(new Date().toLocaleString());
		
		sendMEssageUser(vo);
	}
	
	//특정 사용자에게 메세지를 전송하는 메소드
	private void sendMEssageUser(MsgVo vo) {
		
		WebSocketSession mySession = userSessions.get(vo.getNick());
		//수신자 세션정보 가져오기
		WebSocketSession targetSession = userSessions.get(vo.getTargetNick());
		
		if(targetSession != null && targetSession.isOpen()) {
			String str = new Gson().toJson(vo);
			//웹소켓 텍스트 전송규격 메세지로 변환
			TextMessage msg = new TextMessage(str);
			log.info("msg : {}",vo.getMsg());
			try {
				targetSession.sendMessage(msg);
				mySession.sendMessage(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	//클라이언트가 연결을 끊을 때 호출되는 메소드
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionClosed(session, status);
	}

}
