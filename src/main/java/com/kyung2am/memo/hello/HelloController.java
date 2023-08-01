package com.kyung2am.memo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@GetMapping("/hello")
	@ResponseBody
	public String Hello() {
		return "Hello World";
	}
	
	@GetMapping("/hello/jsp")
	public String HelloJsp() {
		return "/hello/hello";
	}
	
}
