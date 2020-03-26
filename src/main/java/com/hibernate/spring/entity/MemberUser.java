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
public class MemberUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long member_number;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_number")
	Team tema;
}
