package com.kyung2am.memo.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kyung2am.memo.user.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
