package com.serving.accounting.service.impl;

import com.serving.accounting.models.JwtAuthenticationResponse;
import com.serving.accounting.models.Role;
import com.serving.accounting.models.SignInRequest;
import com.serving.accounting.models.SignUpRequest;
import com.serving.accounting.models.User;


import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService{
	private final UserService userService;
	 private final JwtService jwtService;
	    private final PasswordEncoder passwordEncoder;
	    private final AuthenticationManager authenticationManager;

	    /**
	     * Регистрация пользователя
	     *
	     * @param request данные пользователя
	     * @return токен
	     */
	    public JwtAuthenticationResponse signUp(SignUpRequest request) {

	        var user = User.builder()
	                .username(request.getUsername())
	                .email(request.getEmail())
	                .password(passwordEncoder.encode(request.getPassword()))
	                .role(Role.ROLE_USER)
	                .build();

	        userService.create(user);

	        var jwt = jwtService.generateToken(user);
	        return new JwtAuthenticationResponse(jwt);
	    }

	    /**
	     * Аутентификация пользователя
	     *
	     * @param request данные пользователя
	     * @return токен
	     */
	    public JwtAuthenticationResponse signIn(SignInRequest request) {
	        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
	                request.getUsername(),
	                request.getPassword()
	        ));

	        var user = userService
	                .userDetailsService()
	                .loadUserByUsername(request.getUsername());

	        var jwt = jwtService.generateToken(user);
	        return new JwtAuthenticationResponse(jwt);
	    }
}
