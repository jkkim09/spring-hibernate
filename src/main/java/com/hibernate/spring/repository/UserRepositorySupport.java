package com.hibernate.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

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
}
