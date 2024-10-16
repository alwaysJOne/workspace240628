package com.kh.etc.aoptest;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/test")
	public String test() {
		
		int num1 = 10;
		int num2 = 20;
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		
		return "redirect:/";
	}
}
