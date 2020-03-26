package com.hibernate.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.spring.entity.User;
import com.hibernate.spring.entity.UserInfo;
import com.hibernate.spring.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public void getUser() {
		userRepository.findUserByUserNumber(3).forEach(user -> System.out.println(user));
	}
	
	public ArrayList<UserInfo> test() {
		return userRepository.findByUserType(1);
	}
	
	public void save() {
		// user_type, user_join_date
		UserInfo user = new UserInfo();
		user.setUserType(0);
		userRepository.save(user);
		System.out.println(user.getUserNumber());
	}
	
	public void update(int userNumver) {
		UserInfo user = new UserInfo();
		user.setUserNumber(userNumver);
		user.setUser_email("wkrud203");
		userRepository.save(user);
		System.out.println(user);
	}
	
	public void delete(int userNumber) {
		UserInfo user = new UserInfo();
		user.setUserNumber(userNumber);
		userRepository.delete(user);
	}
}
