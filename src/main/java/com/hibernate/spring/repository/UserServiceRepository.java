package com.hibernate.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.spring.entity.UserService;


public interface UserServiceRepository extends JpaRepository<UserService, Long>{

}
