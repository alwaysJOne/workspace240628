package com.kh.etc.chat;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ChatServer extends TextWebSocketHandler{

	//클라이언트가 연결을 맺을 때 호출이되는 메소드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info("연결됨...");
	}

	//클라이언트로부터 메세지를 받을 때 호출되는 메소드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		super.handleTextMessage(session, message);
	}

	//클라이언트가 연결을 끊을 때 호출되는 메소드
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionClosed(session, status);
	}

}
