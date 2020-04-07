package com.hibernate.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.spring.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
}
