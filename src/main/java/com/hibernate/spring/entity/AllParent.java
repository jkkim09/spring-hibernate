package com.hibernate.spring.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class AllParent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long parent_id; 
	
	private String parent_name;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="parent_id")
	private List<User> user = new ArrayList<User>();
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="parent_id")
	private List<Team> team = new ArrayList<Team>();
}
