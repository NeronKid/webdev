package com.serving.accounting.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.serving.accounting.models.Greeting;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.get(), String.format(template, name));
	}
	
	/*
	@GetMapping("/accounting")
	public Account accounting() {
		
		return null;
	}
	*/
	
	/*
	@GetMapping("/login")
	public UserInfo userInfo () {
		
		return null;
	}
	*/
	
	/*
	@GetMapping("/register")
	public UserInfo userReg() {
		
		return null;
	}
	*/
	
	/*
	@GetMapping("/accounting/new")
	public  {
		
		return null;
	}
	*/
	
	/*
	@GetMapping("/accounting/details")
	public  {
		
		return null;
	}
	*/
}