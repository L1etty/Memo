package com.kyung2am.memo.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kyung2am.memo.user.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public List<User> findByLoginIdAndPassword(String loginId, String password);
	
}
