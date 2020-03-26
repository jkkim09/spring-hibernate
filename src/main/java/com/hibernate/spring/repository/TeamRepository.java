package com.hibernate.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.spring.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
