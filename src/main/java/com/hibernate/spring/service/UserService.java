package com.hibernate.spring.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.spring.entity.Team;
import com.hibernate.spring.entity.User;
import com.hibernate.spring.repository.TeamRepository;
import com.hibernate.spring.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TeamRepository teamRepository;
	
	public void save() {
		Team team = new Team();
		team.setTeam_name("atime");
		teamRepository.save(team);
		
		User user = new User();
		user.setUser_name("±èÀÚ°æ");
		user.setTeam(team);
		userRepository.save(user);
	}
	
	public void getUser(long user_number) {
		System.out.println(userRepository.findUserByUserNumber(user_number));
	}
}
