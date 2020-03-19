package com.hibernate.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.spring.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class MainController {
	
	@Autowired
	UserService userService;
	

	@RequestMapping("/test")
	public String test() {
		userService.getUser();
		return "Test";
	}
}
