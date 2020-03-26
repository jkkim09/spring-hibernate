package com.hibernate.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.spring.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class MainController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/save")
	public String save() {
		System.out.println("save");
		userService.save();
		return "save";
	}
	
	@RequestMapping("/getUser/{userNumber}")
	public String getUsser(@PathVariable long userNumber) {
		userService.getUser(userNumber);
		return "getUser";
	}
	
	@RequestMapping("/update/{userNumber}")
	public String update(@PathVariable int userNumber) {
		System.out.println("update");
		return "update";
	}
	
	@RequestMapping("/delete/{userNumber}")
	public void delete(@PathVariable int userNumber) {
		System.out.println("delete : "+ userNumber);
	}
}
