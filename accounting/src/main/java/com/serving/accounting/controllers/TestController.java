package com.serving.accounting.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("test/")
@AllArgsConstructor
public class TestController {
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome new user";
	}
	@GetMapping("/users")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String pageForUser() {
		return "Welcome back";
	}
	
	@GetMapping("/admins")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String pageForAdmins(){
        return "This is page for only admins";
    }


    @GetMapping("/all")
    public String pageForAll(){
        return "This is page for all employees";
    }
}
