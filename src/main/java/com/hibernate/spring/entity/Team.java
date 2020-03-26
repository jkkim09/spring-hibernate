package com.hibernate.spring.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;


@Entity
@Data
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long team_number;
	
	private String team_name;
	
	@OneToMany(mappedBy = "team")
    private List<User> user;
}
