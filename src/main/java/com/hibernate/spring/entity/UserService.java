package com.hibernate.spring.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class UserService {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long service_id;
	
	private String service_name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_number")
	User user;
}
