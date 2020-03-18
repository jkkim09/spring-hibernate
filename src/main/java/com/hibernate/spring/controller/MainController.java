package com.hibernate.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MainController {

	@RequestMapping("/test")
	public String test() {
		return "Test";
	}
}
