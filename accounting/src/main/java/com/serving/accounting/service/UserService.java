package com.serving.accounting.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.serving.accounting.models.UserInfo;

@Service
public interface UserService {
	
	public UserInfo save(UserInfo user);
	
	public UserInfo create(UserInfo user);
	
	public UserInfo getByUsername(String username);
	
	public UserDetailsService userDetailsService();
	
	public UserInfo getCurrentUser();
	
	public void getAdmin();
}
