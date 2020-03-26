package com.hibernate.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.spring.service.UserService;

@RestController
@RequestMapping("/api/v2")
public class TeamMemberController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/save")
	public void save() {
		System.out.println("save");
		
	}
	
	@RequestMapping("/delete/{user_number}")
	public void delete(@PathVariable int user_number) {
		System.out.println("delete : " + user_number);
	}
}
