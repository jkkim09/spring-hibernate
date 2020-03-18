package com.hibernate.spring.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="user_info")
public class UserVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_number")
	private Integer user_number;
	
	private String user_identify_code;

	private Integer user_type;
	
	private Integer user_authorization;
	
	private String user_email;
	
	private Integer user_authentication;
	
	private Integer user_contact_number;
	
	private Integer user_additional_information;
	
	private String user_join_date;

	private String user_secession_date;
	
	private String user_last_login_date;
	
	private Integer user_trust;
}
