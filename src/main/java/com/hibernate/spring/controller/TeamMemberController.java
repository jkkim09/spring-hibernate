package com.hibernate.spring.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class TeamMemberController {
	
	@RequestMapping("/save")
	public void save() {
		System.out.println("save");
	}
	
	@RequestMapping("/delete/{user_number}")
	public void delete(@PathVariable int user_number) {
		System.out.println("delete : " + user_number);
	}
}
