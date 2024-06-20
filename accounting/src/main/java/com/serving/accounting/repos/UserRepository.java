package com.serving.accounting.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.serving.accounting.models.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long>{
		@Query("SELECT value FROM users value WHERE value.username = username")
		Optional<UserInfo> findByUsername(String username);
		boolean existsByUsername(String username);
		boolean existsByEmail(String email);
}
