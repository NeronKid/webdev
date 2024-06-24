package com.serving.accounting.controllers;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serving.accounting.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Аутентификация")
public class AuthController {
	
	/*
	@Operation(summary = "Регистрация пользователя")
    @PostMapping("/register")
	public ResponseEntity<Void> register( @RequestBody UserDto userDto) {
		 authService.register(userDto);
		 return ResponseEntity.ok().build();
	}
	*/
	
    @Operation(summary = "Авторизация пользователя")
    @PostMapping("/login")
    public UserDetailsService signIn() {
    	UserDetails user =
    			User.withDefaultPasswordEncoder()
    				.username("user")
    				.password("password")
    				.roles("USER")
    				.build();
        return new InMemoryUserDetailsManager(user);
    }
}
