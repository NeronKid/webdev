package com.serving.accounting.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	@GetMapping("/")
	public ResponseEntity<String> sayHello() {
		return ResponseEntity.ok("Hello");
	}
	
	@PreAuthorize("hasAuthority('create')")
	@GetMapping("/getnum")
	public ResponseEntity<String> getNum(){
		return ResponseEntity.ok("100");
	}
	
	
}
