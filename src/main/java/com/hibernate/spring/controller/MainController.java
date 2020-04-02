package com.hibernate.spring.controller;

import javax.transaction.Transactional;

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
	
	@RequestMapping("/update/{userNumber}")
	public String update(@PathVariable long userNumber) {
		System.out.println("update");
		userService.update(userNumber);
		return "update";
	}
	
	@RequestMapping("/getUser/{userNumber}")
	public String getUsser(@PathVariable long userNumber) {
		System.out.println("getUser : "+ userNumber);
		userService.getUser(userNumber);
		return "getUser";
	}
	
	@RequestMapping("/getUserNameAndUserNumber/{userNumber}/{userName}")
	public void getUserNameAndUserNumber(@PathVariable long userNumber, @PathVariable String userName) {
		System.out.println("getUserNameAndUserNumber : "+userNumber+" , "+userName);
		userService.getUserNameAndUserNumber(userNumber, userName);
	}
	
	@RequestMapping("/getUserService")
	public void getUserService() {
		System.out.println("getUserService");
		userService.getUserService();
	}
		
	@RequestMapping("/delete/{userNumber}")
	public void delete(@PathVariable int userNumber) {
		System.out.println("delete : "+ userNumber);
	}
	
	@Transactional
	@RequestMapping("/transactional")
	public void transactional() {
		userService.transactional();
	}
	
	@RequestMapping("/getAll")
	public void getAll() {
		userService.getAll();
	}

	@RequestMapping("/queryDSL")
	public void queryDSL() {
		userService.queryDSL();
	}
	
	@RequestMapping("/orderBy")
	public void orderBy() {
		userService.orderBy();
	}
	
	@RequestMapping("/join")
	public void join() {
		userService.join();
	}
}