package com.hibernate.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.spring.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
