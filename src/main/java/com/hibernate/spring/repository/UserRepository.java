package com.hibernate.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.spring.entity.User;

public interface UserRepository extends JpaRepository<User, Long>  {
	List<User> findUserByUsernumber(long usernumber);
	List<User> findByUsername(String username);
	User findByUsernameAndUsernumber(String username, long usernumber);
}
