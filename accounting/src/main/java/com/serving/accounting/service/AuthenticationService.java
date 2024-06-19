package com.serving.accounting.service;

import com.serving.accounting.models.JwtAuthenticationResponse;
import com.serving.accounting.models.SignInRequest;
import com.serving.accounting.models.SignUpRequest;

public interface AuthenticationService {

	public JwtAuthenticationResponse signUp(SignUpRequest request);
	
	public JwtAuthenticationResponse signIn(SignInRequest request);
}
