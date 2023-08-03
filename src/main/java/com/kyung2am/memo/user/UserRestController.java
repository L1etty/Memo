package com.kyung2am.memo.user;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kyung2am.memo.user.domain.User;
import com.kyung2am.memo.user.service.UserService;

@RequestMapping("/user")
@RestController // @Controller + @ResponseBody
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/join")
	public Map<String, String> join(
			@RequestParam("loginId") String loginId
			,@RequestParam("password") String password
			,@RequestParam("name") String name
			,@RequestParam("email") String email) {
		
		
		Map<String, String> test = new HashMap<>();
		
		if(userService.addUser(loginId, password, name, email) == 1) {
			test.put("result", "success");
		}else {
			test.put("result", "fail");
		}
		
		return test;
	}
	
	@PostMapping("/login")
	public Map<String, String> login(
			@RequestParam("loginId") String loginId
			,@RequestParam("password") String password
			,HttpServletRequest request
			) {
		
		User user = userService.getUser(loginId, password);
		
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(user != null) {
			resultMap.put("result", "success");
			// 세션에 로그인 된 상태를 저장
			// 세션 객체 httpRequest
			HttpSession session = request.getSession();
			// 세션에 로그인된 사용자 정보를 저장
			// 세션에 userId 라는 키로 값이 저장되어 있으면 로그인된 상태
			
			session.setAttribute("userId", user.getId());
			session.setAttribute("userName", user.getName());
			
			
		}else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}

}
