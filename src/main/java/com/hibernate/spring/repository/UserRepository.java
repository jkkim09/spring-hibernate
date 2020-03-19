package com.hibernate.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.spring.dto.UserVO;

public interface UserRepository extends JpaRepository<UserVO, Integer>  {
	List<UserVO> findUserVOByUserNumber(int user_number);
}
