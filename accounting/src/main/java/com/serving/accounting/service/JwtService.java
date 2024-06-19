package com.serving.accounting.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface JwtService {

	public String extractUserName(String token);
	
	public String generateToken(UserDetails userDetails);

	public boolean isTokenValid(String token, UserDetails userDetails);
}
