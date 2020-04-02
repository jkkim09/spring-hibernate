package com.hibernate.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.spring.entity.AllParent;
import com.hibernate.spring.entity.Team;
import com.hibernate.spring.entity.User;
import com.hibernate.spring.repository.AllParentRepository;
import com.hibernate.spring.repository.TeamRepository;
import com.hibernate.spring.repository.UserRepository;
import com.hibernate.spring.repository.UserRepositorySupport;
import com.hibernate.spring.repository.UserServiceRepository;


@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserRepositorySupport userRepositoryySupport;
	
	
	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	UserServiceRepository userServiceRepository;
	
	@Autowired
	AllParentRepository allRepository;
	
	public void save() {
		Team team = new Team();
		team.setTeam_name("ateam");
		teamRepository.save(team);
		
		User user = new User();
		user.setUsername("aaaa");
		user.setTeam(team);
		userRepository.save(user);
	}
	
	public void update(long user_number) {
		User user = new User();
		user.setUsernumber(user_number);
		user.setUsername("aaaa");
		Optional<User> user_info = userRepository.findById(user_number);
		Team user_tream = user_info.get().getTeam();
		user.setTeam(user_tream);
		userRepository.save(user);
	}
	
	public void getUser(long user_number) {
		Optional<User> users = userRepository.findById(user_number);
		System.out.println(users.get().getTeam().getTeam_name());
		List<User> users2 = userRepository.findByUsername("aaaa");
		for(User user : users2) {
			System.out.println(user.getUsernumber());
		}
	}
	
	public void getUserNameAndUserNumber(long userNumber, String userName) {
		User users = userRepository.findByUsernameAndUsernumber(userName, userNumber);
		System.out.println(users);
	}
	
	public void transactional() {
		
			User user = new User();
			Team team = new Team();
			team.setTeam_name("bteam");
			teamRepository.save(team);

			// rollback
//			user.setTeam(team);
			user.setUsername("aaaa");
			userRepository.save(user);			
	}
	
	
	public void getUserService() {
		Optional<com.hibernate.spring.entity.UserService> userService = userServiceRepository.findById(1L);
		System.out.println(userService);
	}
	
	public void getAll() {
		Optional<AllParent> all = allRepository.findById(1L);
		List<User> users = all.get().getUser();
		System.out.println(users);
		for(User user: users) {
			System.out.println(user);
		}
	}
	
	public void queryDSL() {
		System.out.println("queryDSL");
		List<User> users = userRepositoryySupport.QfindByUsername("aaaa");
		for(User user : users) {
			System.out.println(user);
		}
	}
}
