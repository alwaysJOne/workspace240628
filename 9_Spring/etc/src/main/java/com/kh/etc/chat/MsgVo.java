package com.kh.etc.chat;

import lombok.Data;

@Data
public class MsgVo {
	private String msg;
	private String nick;
	private String targetNick;
	private String time;
}
