package com.serving.accounting.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serving.accounting.models.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Long>{
		Optional<UserInfo> findByUsername(String username);
		boolean existsByUsername(String username);
		boolean existsByEmail(String email);
}
