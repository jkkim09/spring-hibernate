package com.hibernate.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.spring.entity.User;

public interface UserRepository extends JpaRepository<User, Long>  {
	List<User> findUserByUserNumber(long user_number);
}
