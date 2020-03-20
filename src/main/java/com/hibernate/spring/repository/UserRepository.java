package com.hibernate.spring.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.spring.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>  {
	List<User> findUserByUserNumber(int user_number);
	ArrayList<User> findByUserType(int user_type);
}
