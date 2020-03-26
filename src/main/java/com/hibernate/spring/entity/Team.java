package com.hibernate.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long team_number;
	
	@Column(nullable = false)
	private String team_name;
}
