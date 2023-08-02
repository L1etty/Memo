package com.kyung2am.memo.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyung2am.memo.user.domain.User;
import com.kyung2am.memo.user.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public int addUser(
			String loginId
			,String password
			,String name
			,String email
			) {
		
		User user = User.builder()
				.loginId(loginId)
				.password(password)
				.name(name)
				.email(email)
				.build();
		
		user = userRepository.save(user);
		
		int count;
		if(user != null) {
			count = 1;
		}else {
			count = 0;
		}
		
		return count;
	}
	
}
