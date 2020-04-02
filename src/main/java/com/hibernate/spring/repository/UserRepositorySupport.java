package com.hibernate.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.hibernate.spring.entity.QTeam;
import com.hibernate.spring.entity.QUser;
import com.hibernate.spring.entity.User;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class UserRepositorySupport extends QuerydslRepositorySupport{
	private final JPAQueryFactory queryFactory;
	
	public UserRepositorySupport(JPAQueryFactory queryFactory) {
		super(User.class);
		this.queryFactory = queryFactory;
	}

	public List<User> QfindByUsername(String name) {
		QUser user = QUser.user;
		return queryFactory.selectFrom(user).where(user.username.eq(name)).fetch();
	}
	
	public List<User> orderBy() {
		QUser user = QUser.user;
		List<User> items = queryFactory.selectFrom(user).where(user.username.eq("aaaa")).orderBy(user.usernumber.desc()).fetch();
		return items;
	}
	
	public void join() {
		QUser user = QUser.user;
		QTeam team = QTeam.team;
		System.out.println("join");
		List<User> list = (List<User>) queryFactory.from(user).innerJoin(user.team, team).fetchJoin().fetch();
//		List list = queryFactory.from(user).innerJoin(user.team, team).fetch();
		System.out.println(list);
		for(User item : list) {
			System.out.println(item.getTeam().getTeam_number());
		}
	}
}
