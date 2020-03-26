package com.hibernate.spring.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.spring.entity.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Integer>  {
	List<UserInfo> findUserByUserNumber(int user_number);
	ArrayList<UserInfo> findByUserType(int user_type);
}
