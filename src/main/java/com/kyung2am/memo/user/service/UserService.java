package com.kyung2am.memo.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyung2am.memo.common.EncryptUtils;
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
		
		// password 암호화
		String ecryptPassword = EncryptUtils.md5(password);
		
		
		User user = userRepository.save(User.builder()
				.loginId(loginId)
				.password(ecryptPassword)
				.name(name)	
				.email(email)
				.build());
		
		int count;
		if(user != null) {
			count = 1;
		}else {
			count = 0;
		}
		
		return count;
	}
	
	public User getUser(String loginId, String password){
		
		String ecryptPassword = EncryptUtils.md5(password);
		
		List<User> userList = userRepository.findByLoginIdAndPassword(loginId, ecryptPassword);
		
		// 비워진 경우
		if(userList.isEmpty()) {
			return null;
		}else {
			return userList.get(0);
		}
		
	}
	
}
