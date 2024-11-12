package com.kh.etc.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping("detail")
	public String movePage(String page) {
		switch(page) {
		case "publicData":
			return "apiSample";
		case "summernote":
			return "summernote";
		case "chat":
			return "chat";
		}
		
		return "redirect:/";
	}
	
}
