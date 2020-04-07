package com.hibernate.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.hibernate.spring.entity.Game;
import com.hibernate.spring.entity.Item;
import com.hibernate.spring.entity.QGame;
import com.hibernate.spring.entity.QItem;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class GameRepositorySupport extends QuerydslRepositorySupport{
	private final JPAQueryFactory queryFactory;
	
	public GameRepositorySupport(JPAQueryFactory queryFactory) {
		super(Game.class);
		this.queryFactory = queryFactory;
	}
	
	public List<Item> getItem() {
		QItem qItem = QItem.item;
		List<Item> items = queryFactory.selectFrom(qItem).fetch();
		return items;
	}
	
	public List<Game> getGame() {
		QGame qGame = QGame.game;
		return queryFactory.selectFrom(qGame).fetch();
	}
}
