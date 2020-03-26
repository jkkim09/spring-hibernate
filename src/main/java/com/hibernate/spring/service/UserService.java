package com.hibernate.spring.service;

import javax.transaction.Transactional;

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
		team.setTeam_name("ateam");
		teamRepository.save(team);
		
		User user = new User();
		user.setUsername("김자경");
		user.setTeam(team);
		userRepository.save(user);
	}
	
	public void getUser(long user_number) {
//		Optional<User> users = userRepository.findById(user_number);
//		System.out.println(users.get().getTeam().getTeam_name());
//		List<User> users2 = userRepository.findByUsername("김자경");
//		for(User user : users2) {
//			System.out.println(user.getUsernumber());
//		}
		getUserManager();
	}
	
	@Transactional
	public void getUserManager() {
			User user = new User();
			Team team = new Team();
//			team.setTeam_name("bteam");
//			teamRepository.save(team);
			team.setTeam_number(1);
			teamRepository.delete(team);
			// team number 가 not null 이기때문에 
//			user.setTeam(team);
			user.setUsername("김자경 4");
			userRepository.save(user);			
	}
}
