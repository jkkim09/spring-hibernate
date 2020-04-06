package com.hibernate.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hibernate.spring.service.UserService;;

@SpringBootTest
class SpringHibernateApplicationTests {

	@Autowired
	UserService userService;
	
	@Test
	void contextLoads() {
		System.out.println("junit test");
		userService.queryDSL();
	}

}
