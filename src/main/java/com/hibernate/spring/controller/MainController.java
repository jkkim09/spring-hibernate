package com.hibernate.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.spring.entity.User;
import com.hibernate.spring.entity.UserInfo;
import com.hibernate.spring.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class MainController {
	
	@Autowired
	UserService userService;
	

	@RequestMapping("/test")
	public String test() {
//		userService.getUser();
		ArrayList<UserInfo> items =  userService.test();
		
		for(UserInfo vo : items) {
			System.out.println("test");
			System.out.println(vo.getUser_join_date());
		}
		
		return "Test";
	}
	
	@RequestMapping("/save")
	public String save() {
		System.out.println("save");
		userService.save();
		return "save";
	}
	
	@RequestMapping("/update/{userNumber}")
	public String update(@PathVariable int userNumber) {
		System.out.println("update");
		userService.update(userNumber);
		return "update";
	}
	
	@RequestMapping("/delete/{userNumber}")
	public String delete(@PathVariable int userNumber) {
		System.out.println("delete : "+ userNumber);
		userService.delete(userNumber);
		return "delete";
	}
}
