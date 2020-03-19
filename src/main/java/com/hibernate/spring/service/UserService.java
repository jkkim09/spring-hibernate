package com.hibernate.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.spring.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public void getUser() {
		userRepository.findUserVOByUserNumber(3).forEach(user -> System.out.println(user));
	}
}
